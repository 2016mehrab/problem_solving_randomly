from typing import List
from collections import defaultdict, deque


class Solution:
    def canReachBFS(self,u,v,totalNodes,adj):
        q=deque()
        q.append(u)
        visited=[False] * (totalNodes+1)
        visited[u]=True
        while q:
            curr= q.popleft()
            for n in adj[curr]:
                if visited[n]:
                    continue
                if n==v:
                    return True
                q.append(n)
                visited[n]=True

        return False

    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        V = len(edges)
        adj = defaultdict(set)
        for u, v in edges:
            if not self.canReachBFS(u,v,V, adj):
                adj[u].add(v)
                adj[v].add(u)
            else:
                print([u,v])
                return [u,v]


            
        return []


s=Solution()
s.findRedundantConnection([[1,2],[1,3],[2,3]])
s.findRedundantConnection([[1,2],[2,3],[3,4],[1,4],[1,5]])
        
