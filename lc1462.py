from typing import List
from collections import defaultdict

class Solution:

    def checkIfPrerequisite(self, numCourses: int, prerequisites: List[List[int]], queries: List[List[int]]) -> List[bool]:
        adj= defaultdict(list)
        courseToPrereq= defaultdict(set)
        
        for prereq,course in  prerequisites:
            adj[course].append(prereq)

        visited=[False] * (numCourses)
        for c in range(numCourses):
            if not visited[c]:
                self.DFS(c,adj,visited,courseToPrereq)


        r=[False]* len(queries)
        for i,arr in enumerate(queries):
            if arr[0] in courseToPrereq[arr[1]]:
                r[i]=True


        print(courseToPrereq)
        print(r)
        print("*********")
        return r

    def DFS(self,start, adj, visited, courseToPrereq):
        if visited[start]:
            return
        visited[start] =True
        for n in adj[start]:
            self.DFS(n,adj,visited, courseToPrereq)
            # adding neighbors of neighbors
            courseToPrereq[start].add(n)
            courseToPrereq[start].update(courseToPrereq[n])



s= Solution()
s.checkIfPrerequisite(3,[[1,2],[2,0]],[[1,0],[1,2]])
s.checkIfPrerequisite(2,[[1,0]],[[0,1],[1,0]])
s.checkIfPrerequisite(2,[],[[1,0],[0,1]])
s.checkIfPrerequisite(3,[[1,2],[1,0],[2,0]],[[1,0],[1,2]])
