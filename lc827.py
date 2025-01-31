from collections import defaultdict, deque
from typing import List
class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        moves= [[-1, 0], [1,0], [0,1], [0,-1]]
        M = len(grid)
        def out_of_bounds(r,c):
            return (r<0 or c<0 or r>=M or c>=M)

        size = defaultdict(int)
        label=2
        def bfs(r,c,label):
            grid[r][c] =label
            area=0
            q=deque()
            q.append([r,c])
            while q:
                r_,c_= q.popleft()
                area+=1
                for mr, mc in moves:
                    nr, nc = r_+mr, c_+mc
                    if(out_of_bounds(nr,nc) or grid[nr][nc]==0 or grid[nr][nc]==label):
                        continue
                    q.append([nr,nc])
                    grid[nr][nc]=label
            return area

                        

        
        for r in range (M):
            for c in range (M):
                if grid[r][c]==1:
                   size[label]=bfs(r,c,label) 
                   label+=1
        
        def connect(r,c):
            visit=set([0])
            res =1
            for mr, mc in moves:
                nr, nc = r+mr, c+mc
                if not out_of_bounds(nr,nc) and grid[nr][nc] not in visit:
                    res+=size[grid[nr][nc]]
                    visit.add(grid[nr][nc])
            return res

        res=0 if not size else max(size.values())
        for r in range (M):
            for c in range (M):
                if grid[r][c]==0:
                    res = max(res, connect(r,c))
        print(res)
        return res
                   
s = Solution()
s.largestIsland( [[1,0],[0,1]])
s.largestIsland([[1,1],[1,0]])
s.largestIsland([[1,1],[1,1]])

