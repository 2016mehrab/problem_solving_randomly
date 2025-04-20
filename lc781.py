from collections import Counter
from typing import Collection, List
import math


class Solution:
    def numRabbits(self, answers: List[int]) -> int:
        map = Counter(answers)
        cnt =0
        for k,v in map.items():
            cnt+= (k+1)* math.ceil(v/(k+1))
       

        print(cnt)
        return cnt

s= Solution()
s.numRabbits([1,1,2])
s.numRabbits([10,10,10])
