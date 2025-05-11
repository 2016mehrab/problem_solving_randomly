from typing import List


class Solution:
    def threeConsecutiveOdds(self, arr: List[int]) -> bool:
        oddStreak=0
        for i in arr:

            if oddStreak>= 3:
                return True
            if i & 1 ==1:
                oddStreak+=1
            else:
                oddStreak =0 
        return oddStreak>= 3
s= Solution()
s.threeConsecutiveOdds(arr = [2,6,4,1])
s.threeConsecutiveOdds( arr = [1,2,34,3,4,5,7,23,12])
s.threeConsecutiveOdds([1,1,2,1,1])
