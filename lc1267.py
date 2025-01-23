from typing import List

class Solution:
    def countServers(self, grid: List[List[int]]) -> int:
        M,N= len(grid), len(grid[0])
        rowServerMap = [0] * M
        colServerMap = [0] * N
        # preprocess how many servers according to rows and cols
        for row in range(M):
            for col in range(N):
                if grid[row][col] ==1:
                    rowServerMap[row]+=1
                    colServerMap[col]+=1
        r=0
        for row in range(M):
            for col in range(N):
                if grid[row][col] ==1 and max(rowServerMap[row],colServerMap[col])> 1 :
                    r+=1
        print(r)
        return r





s= Solution()
grid1 = [[1,0],[0,1]]

grid2=[[1,0],[1,1]]
grid3 = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
s.countServers(grid1)
s.countServers(grid2)
s.countServers(grid3)
