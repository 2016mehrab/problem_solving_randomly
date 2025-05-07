from typing import List
import heapq


class Solution:
    dirs= [[1,0], [-1,0], [0,1],[0, -1]]
    INF = 10**9 + 1
    def minTimeToReach(self, moveTime: List[List[int]]) -> int:
        M = len(moveTime)
        N= len(moveTime[0])
        res =  [[Solution.INF] * N for _ in range(M) ]
        heap= []
        res[0][0] = 0
        heapq.heappush(heap,(0,0,0))
        while heap:
            currTime, x,y = heapq.heappop(heap)
            if x == M-1 and y == N-1:
                print(f"grid: {moveTime}")
                print(f"output: {currTime}")
                return currTime
            for dir in  Solution.dirs:
                new_x = x+dir[0]
                new_y = y+dir[1]
                if new_x >= M or new_y >=N or  new_x<=-1 or new_y<=-1:
                    continue
                wait =max(moveTime[new_x][new_y] - currTime, 0) 
                newTime =wait+currTime+1
                if res[new_x][new_y] > newTime:
                    res[new_x][new_y] = newTime
                    heapq.heappush(heap,(newTime, new_x,new_y) )



        return -1
s= Solution()
s.minTimeToReach(moveTime = [[0,4],[4,4]])
s.minTimeToReach([[0,0,0],[0,0,0]])
        
