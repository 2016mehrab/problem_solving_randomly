from typing import List
from collections import deque


class Solution:
    directions = [[-1,0], [1,0], [0,1], [0,-1]]
    def BFS(self, row, col, grid, visited):
        totalFish =0
        q= deque()
        q.append([row,col])
        visited[row][col]=True
        while q:
            tr, tc = q.popleft()
            totalFish+= grid[tr][tc]
            for dr,dc in self.directions:
                nr=dr+tr
                nc=dc+tc
                if 0 <= nr < len(grid) and 0 <= nc < len(grid[0]) and not visited[nr][nc] and not grid[nr][nc]==0:
                    q.append([nr,nc])
                    visited[nr][nc]=True

        return totalFish




    def findMaxFish(self, grid: List[List[int]]) -> int:
        M, N=len(grid), len(grid[0])
        visited=[[False for _ in range(N)] for _ in range(M)]
        fish=0
        for row in range(M):
            for col in range(N):
                if grid[row][col] !=0 and not visited[row][col]:
                    fish= max(fish, self.BFS(row, col ,grid, visited))


        
        print(fish)
        return fish



s= Solution()
s.findMaxFish([[0,2,1,0],[4,0,0,3],[1,0,0,4],[0,3,2,0]])
s.findMaxFish([[1,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,1]])
