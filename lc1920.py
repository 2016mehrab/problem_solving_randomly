from typing import List


class Solution:
    def buildArray(self, nums: List[int]) -> List[int]:
        ans =[0]* len(nums)
        for i in range (len(nums)):
            ans[i] = nums[nums[i]]


        print(f"nums:{nums}, output:{ans}") 
        return ans
s= Solution()
s.buildArray(nums = [0,2,1,5,3,4])
s.buildArray(nums = [5,0,1,2,3,4])

        
