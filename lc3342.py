from typing import List
import heapq

class Solution:
    dirs = [[0,1], [0, -1], [1,0], [-1,0]]
    MAX= 10**9+10000
    def minTimeToReach(self, moveTime: List[List[int]]) -> int:
        M = len(moveTime)
        N = len(moveTime[0])
        res=[[Solution.MAX] * N for _ in range(M)]
        heap = []
        #            (time, x, y ,next step use)
        heapq.heappush(heap, (0,0,0,1))
        while heap:
            time ,x,y, currentTurn  = heapq.heappop(heap)
            if x == M-1 and y==N-1:
                print(f"grid: {moveTime}")
                print(f"output: {time}")
                return time

            for dir in Solution.dirs:
                new_x = x+dir[0]
                new_y = y+dir[1]
                if new_x>=M or new_y >=N or new_y<=-1 or new_x<=-1:
                    continue
                wait=max(moveTime[new_x][new_y]- time,0) 
                new_time = time+wait+ currentTurn
                next_turn = 1 if currentTurn ==2 else 2
                if new_time < res[new_x][new_y]:
                    res[new_x][new_y] = new_time
                    heapq.heappush(heap, (new_time, new_x,new_y, next_turn))
        
        

        return -1

s =Solution()
s.minTimeToReach(moveTime = [[0,4],[4,4]])
s.minTimeToReach([[0,0,0,0],[0,0,0,0]])
s.minTimeToReach(moveTime = [[0,1],[1,2]])
