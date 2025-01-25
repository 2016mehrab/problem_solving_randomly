from collections import deque
from typing import List


class Solution:
    def lexicographicallySmallestArrayBF(self, nums: List[int], limit: int) -> List[int]:
        N = len(nums)
        for i in range(N):
            idx=-1
            curr= nums[i]
            while(True):
                for j in range(i+1,N):
                    if nums[j]<curr and abs(curr-nums[j]) <= limit:
                        idx=j

                if idx!=-1:
                    nums[i],nums[idx]=nums[idx], nums[i]
                    idx=-1
                else:
                    break

        print(nums)
        return nums


    def lexicographicallySmallestArray(self, nums: List[int], limit: int) -> List[int]:
        N = len(nums)
        sorted_nums = sorted(nums)
        curr_grp = 0
        num_to_grp={}

        num_to_grp[sorted_nums[0]]= curr_grp

        grp_to_list= {}
        grp_to_list[curr_grp] = deque([sorted_nums[0]])

        for i in range(1,N):
            if abs(sorted_nums[i] - sorted_nums[i-1]) > limit:
                curr_grp+=1
            num_to_grp[sorted_nums[i]] = curr_grp
            if curr_grp not in grp_to_list:
                grp_to_list[curr_grp] =deque()
            grp_to_list[curr_grp] . append(sorted_nums[i])

        for i,num in enumerate(nums):
            group = num_to_grp[num]
            smallest_in_group = grp_to_list[group].popleft()
            nums[i] = smallest_in_group




        print(num_to_grp)
        print(grp_to_list)
        print(nums)
        print("+++++++++++++++++++")
        return nums

nums1=[1,5,3,9,8]
nums2 = [1,7,6,18,2,1]
nums3=[1,7,28,19,10]
s= Solution()
s.lexicographicallySmallestArray(nums1, 2)
s.lexicographicallySmallestArray(nums2, 3)
s.lexicographicallySmallestArray(nums3, 3)

