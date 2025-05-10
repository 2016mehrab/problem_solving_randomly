from typing import List


class Solution:
    def minSum(self, nums1: List[int], nums2: List[int]) -> int:
        zeroCntNum1 = 0
        zeroCntNum2 = 0
        sumNum1=0
        sumNum2=0
        for n in nums1:
            zeroCntNum1+=1 if n==0 else 0
            sumNum1+=n
            sumNum1+=1 if n==0 else 0

        for n in nums2:
            zeroCntNum2+=1 if n==0 else 0
            sumNum2+=n
            sumNum2+=1 if n==0 else 0

            # can't make sum1 equal to sum2
        if sumNum1 < sumNum2 and zeroCntNum1 ==0:
            return -1
        if sumNum1 > sumNum2 and zeroCntNum2 ==0:
            return -1
        return max(sumNum1, sumNum2)

s = Solution()

s.minSum(nums1 = [3,2,0,1,0], nums2 = [6,5,0])
s.minSum(nums1 = [2,0,2,0], nums2 = [1,4])
s.minSum([8,13,15,18,0,18,0,0,5,20,12,27,3,14,22,0], [29,1,6,0,10,24,27,17,14,13,2,19,2,11])
        
