from typing import List


class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        N =len(nums)
        product_left =[1]* N
        product_right =[1]* N
        res = [1]* N
        product_curr_left=1
        product_curr_right=1

        for i in range(N):
            if i==0:
                product_left[i]=1
                product_right[N-i-1]=1
                product_curr_left=nums[i]
                product_curr_right=nums[N-i-1]
                continue

            product_left[i]=product_curr_left* product_left[i-1]
            product_right[N-i-1]=product_curr_right* product_right[N-i]
            product_curr_left = nums[i]
            product_curr_right = nums[N-i-1]

        for i in range(N):
            res[i] = product_left[i] * product_right[i]

        print(f"nums: {nums}")
        print(f"left: {product_left}")
        print(f"right: {product_right}")

        return res
s= Solution()
s.productExceptSelf(nums = [1,2,3,4])
s.productExceptSelf(nums = [-1,1,0,-3,3])

        
