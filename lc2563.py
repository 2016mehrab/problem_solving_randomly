# can be sorted order doesn't matter
#[0, 1, 4, 4, 5, 7]
#lower =3 ,upper =6
# for 0 -> 4,4,5,
#p= for 0 how many lower than 3?-> 1
# q=for 0 how many lower than equal 6?-> 1,4,4,5
# so between = q-p


from typing import List


class Solution:
    def countFairPairs(self, nums: List[int], lower: int, upper: int) -> int:
        #returns the first number that is exactly lower than the provided
        # find me the index 
        N = len(nums)
        cnt =0
        nums= sorted(nums)
        def lowerBound(start, end , target):
            idx=-1
            left =start
            right =end
            while left <N and right<N and left<= right:
                mid = (left+right)//2
                if(nums[mid] >= target):
                    right= mid -1
                else:
                    idx = mid
                    left = mid +1
            return idx
        # find the first num thats bigger than target
        def upperBound(start, end , target):
            idx=-1
            left =start
            right =end
            while left <N and right<N and left<= right:
                mid = (left+right)//2
                if(nums[mid] <= target):
                    left= mid + 1
                else:
                    idx = mid
                    right = mid -1

            return idx

        for i in range(N):
            # lower than lower
            tmp1=lowerBound(i+1,N-1,lower-nums[i] )
            if tmp1 ==-1 :
                p=0
            else: p = tmp1 -i

            tmp2=upperBound(i+1,N-1, upper-nums[i] ) 
            if tmp2==-1:
                q = N -i -1
            else : 
                q = tmp2 -i -1

            if q-p<0:
                continue
            cnt+= q-p


        return cnt
        
s=Solution()
s.countFairPairs(nums = [0,1,7,4,4,5], lower = 3, upper = 6)
s.countFairPairs(nums = [1,7,9,2,5], lower = 11, upper = 11)
