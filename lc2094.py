from typing import List
from collections import defaultdict 


class Solution:
    def findEvenNumbers(self, digits: List[int]) -> List[int]:
        freqs= [0] * 10
        res =[]
        for i in digits:
            freqs[i]+=1
        for i in range(1,10):
            if freqs[i]<1:
                continue
            freqs[i]-=1
            for j in range(10):
                if freqs[j]<1:
                    continue
                freqs[j]-=1
                for k in range(0,10,2):
                    if freqs[k] > 0:
                        res.append(i*100+j*10+k)
                freqs[j]+=1
            freqs[i]+=1

        print(f"digits:{digits}, output:{res}")
        return res

s= Solution()
s.findEvenNumbers( digits = [2,1,3,0])
s.findEvenNumbers(digits = [2,2,8,8,2])
s.findEvenNumbers(digits = [3,7,5])

        
