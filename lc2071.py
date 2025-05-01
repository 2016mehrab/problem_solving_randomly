from typing import List
from collections import deque

class Solution:

    def isPossible(self,mid, pills, strength,tasks, workers):
        worker_deck= deque()
        W = len(workers)
        # start with the strongest
        worker_pointer =W-1 
        # looping over tasks
        for i in range(mid-1,-1, -1):
            # check who can do the strongest task with or
        # without pills
            task = tasks[i] 
            while worker_pointer >= W-mid  and  workers[worker_pointer]+ strength >= task:
                worker_deck.appendleft(workers[worker_pointer])
                worker_pointer-=1
            # no worker able to do the task
            if not worker_deck:
                return False
            if worker_deck[-1] >= task:
                worker_deck.pop()
            else:
                if pills>0:
                    # do it with weakest worker
                    worker_deck.popleft()
                    pills-=1
                    #no pills so can't do the task
                else:
                    return False
        return True 
            
    def maxTaskAssign(self, tasks: List[int], workers: List[int], pills: int, strength: int) -> int:
        res=0
        T=len(tasks)
        W = len(workers)
        sortedWorkers = sorted(workers)
        sortedTasks = sorted(tasks)
        l=1
        r=min(T,W)
        while(l<=r):
            mid=(l+r)//2
            if self.isPossible(mid,pills,strength,sortedTasks, sortedWorkers):
                res=mid
                l=mid+1
            else :
                r=mid-1

        print(f"tasks:{tasks}, workers: {workers}, pills:{pills}(s={strength}), output: {res}")
        return res

s = Solution()

s.maxTaskAssign(tasks = [3,2,1], workers = [3,0,3], pills = 1, strength = 1)
s.maxTaskAssign(tasks = [5,4], workers = [0,0,0], pills = 1, strength = 5)
s.maxTaskAssign(tasks = [10,15,30], workers = [0,10,10,10,10], pills = 3, strength = 10)
s.maxTaskAssign([5,9,8,5,9],[1,6,4,2,6],1,5)
        
s.maxTaskAssign([74,41,64,20,28,52,30,4,4,63],[38], 0, 68)
s.maxTaskAssign(tasks = [5, 4, 2], workers = [3, 3, 3], pills = 1, strength = 2)
s.maxTaskAssign(tasks = [5, 4, 1], workers = [2, 2, 5], pills = 1, strength = 3)
s.maxTaskAssign(tasks = [5, 9, 1], workers = [2, 2, 5], pills = 1, strength = 7)
