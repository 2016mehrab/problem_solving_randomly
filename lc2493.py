from collections import defaultdict, deque
from typing import List

class Solution:
    def magnificentSets(self, n: int, edges: List[List[int]]) -> int:
        adj= defaultdict(list)
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)
        
        def getConnectedComponents(src):
            q=deque([src])
            component=set([src])
            while q:
                node= q.popleft()
                for neighbor in adj[node]:
                    if neighbor in component:
                        continue
                    q.append(neighbor)
                    component.add(neighbor)
                    visited.add(neighbor)

            return component

        def BFS(src):
            q=deque([(src, 1)])
            dist = {src:1}
            while q:
                node , length = q.popleft()
                for neigbhor in adj[node]:
                    if neigbhor in dist:
                        # node and its neighbor have the same length (or group) this would imply two nodes are in the same group and share an edge
                        if dist[neigbhor]==length:
                            return -1
                        continue
                    q.append((neigbhor, length+1))
                    dist[neigbhor]= length+1

            return max(dist.values())


        visited = set()
        r=0
        for i in range(1, n+1):
            if i in visited:
                continue

            visited.add(i)
            component= getConnectedComponents(i)
            maxCount =0
            for src in component:
                length = BFS(src)

                if length == -1:
                    return -1

                maxCount= max(maxCount , length)

            r+=maxCount

        print(r)
        return r

s= Solution()
s.magnificentSets(6,[[1,2],[1,4],[1,5],[2,6],[2,3],[4,6]])
s.magnificentSets(3,[[1,2],[2,3],[3,1]])
