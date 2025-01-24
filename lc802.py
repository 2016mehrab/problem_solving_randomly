from typing import List


class Solution:
    def __markCycleDFS(self,curr, visited, inrecursion, grid):
        visited[curr] = True
        inrecursion [curr]=True
        for n in grid[curr]:
            if not visited[n] and self.__markCycleDFS(n,visited,inrecursion, grid ):
                return False 

            elif inrecursion[n]:
                return True
        inrecursion[curr] = False
        return False

    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        M = len(graph)
        visited = [False] * M
        inrecursion = [False] * M
        r=[]
        for n in range(M):
            if not visited[n]: 
                self.__markCycleDFS(n, visited, inrecursion, graph)
        for i in range(M) :
            if not inrecursion[i]:
                r.append(i)
        
        print(r)
        return r

s= Solution()
graph1 = [[1,2],[2,3],[5],[0],[5],[],[]]
graph2 = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
s.eventualSafeNodes(graph1)
s.eventualSafeNodes(graph2)
