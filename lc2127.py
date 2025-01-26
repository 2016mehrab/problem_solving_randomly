from typing import List
from collections import defaultdict, deque


class Solution:

    def BFS(self, start, adj, visited):
        q= deque()
        q.append([start, 0])
        maxDist=0
        while q:
            curr, dist = q.popleft()
            for neighbor in adj[curr]:
                if not visited[neighbor]:
                    visited[neighbor]=True
                    q.append([neighbor,dist+1])
                    maxDist=max(dist+1, maxDist)
        return maxDist


    def maximumInvitations(self, favorite: List[int]) -> int:
        N = len(favorite)
        adj = defaultdict(list)
        for idx,n in enumerate(favorite):
            u= idx
            v=n
            # reverse 
            adj[v].append(u)

        longestCycleCount=0
        coupleGroups=0
        visited= [False] * N
        for i in range(N):
            if not visited[i]:
                # track length on each node
                map = {}
                currNode= i
                currNodeCount=0
                while not visited[currNode]:
                    visited[currNode] =True
                    map[currNode] =currNodeCount
                    nextNode = favorite[currNode]
                    currNodeCount+=1

                    # cycle detected
                    if nextNode in map:
                        cycleLength = currNodeCount - map[nextNode]
                        longestCycleCount =max(longestCycleCount, cycleLength)
                        # cycle consists of two
                        if cycleLength==2:
                            tmpVisited= [False] * N
                            tmpVisited[currNode]=True
                            tmpVisited[nextNode]=True
                            coupleGroups+=2+self.BFS(currNode, adj, tmpVisited) + self.BFS(nextNode, adj, tmpVisited)
                        break
                    currNode = nextNode

        return max(coupleGroups, longestCycleCount)





s= Solution()
print(s.maximumInvitations( [2,2,1,2]))
print(s.maximumInvitations([1,2,0]))
print(s.maximumInvitations([3,0,1,4,1]))


