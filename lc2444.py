from typing import List


class Solution:
    def countSubarraysBF(self, nums: List[int], minK: int, maxK: int) -> int:
        N = len(nums)
        cnt =0
        i=0
        while i<N:
            mn = mx = nums[i]
            mark =-1
            jmp=-1
            for j in range(i, N):
                mn = min(mn , nums[j])
                mx = max(mx , nums[j])
                # invalid subarr
                if mn < minK or mx > maxK:
                    jmp=j
                    break
                if mn == minK and mx== maxK and mark==-1:
                    mark=j
            if mark==-1:
                i+=1
                continue

            if jmp!=-1:
                cnt+= jmp - mark
                i=jmp+1
            else :
                cnt+= N- mark
                i+=1
        print(cnt)
        return cnt

    def countSubarrays(self, nums: List[int], minK: int, maxK: int) -> int:
        N = len(nums)
        cnt =0
        invalid=-1
        # indexes
        minF=-1
        maxF=-1
        # find valid subs till the left of pointer
        for i in range(N):
            if nums[i]==minK:
                minF= i
            if nums[i]==maxK:
                maxF= i

            if nums[i] >maxK or nums[i]< minK:
                invalid=i

            tmp = min(minF, maxF)

            #tmp < 0 means they are not set
            if tmp < 0 or tmp - invalid < 0:
                continue

            cnt += tmp - invalid

        print(cnt)
        return cnt

s= Solution()
s.countSubarrays(nums = [1,3,5,2,7,5], minK = 1, maxK = 5)
s.countSubarrays( nums = [1,1,1,1], minK = 1, maxK = 1)
        
