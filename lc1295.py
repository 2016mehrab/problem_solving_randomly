from typing import List


class Solution:
    def findNumbers(self, nums: List[int]) -> int:
        # 100000
        # 10000 - 99999 -Odd
        # 1000 - 9999 -Even
        # 10 - 99 -Even
        cnt=0
        for num in nums:
            if 10<=num<=99 or 1000<=num<=9999 or num==100000:
                cnt+=1
        print(f"{nums}: {cnt}")
        return cnt
        
s= Solution()
s.findNumbers( nums = [12,345,2,6,7896])
s.findNumbers(nums = [555,901,482,1771])
