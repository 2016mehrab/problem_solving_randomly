from typing import List


# if we find a valid sequence we can generate all the other sequences by 
# adding K{integer} to each element because that won't change the difference
# why that works?
# to prove it , lets take a sequence M={w,x,y,z,} that can't be generated from an earlier sequence
# N={3,4,1,5}. It's not possible. There will always exists a K and by subtracting that
# from M will make it equal N. {w-k, x-k, y-k, z-k}={3,4,1,5}. As N,M follows the valid
# difference and M's nums are bigger than N, M can be absolutly generated from N as 
# the valid difference didn't change.
# 

class Solution:
    def numberOfArrays(self, differences: List[int], lower: int, upper: int) -> int:
        N = len(differences)
        cnt=0
        min_num = max_num =curr=0
        for d in differences:
            curr+=d
            min_num= min(min_num,curr)
            max_num= max(max_num,curr)
            # early exit
            if(max_num-min_num > upper - lower):
                return 0

        # even
        # tmp1 = alpha low/ starting offset
        # tmp2 = alpha high/ ending offset
        # if we add the starting offset with the generated sequence
        # then we would get the first valid sequence in the bounds
        tmp1 =upper-max_num
        tmp2 =lower-min_num
        cnt= tmp1 - tmp2  +1
        print(f"input :{differences} \noutput: {cnt}" )
        if cnt<0:
            return 0
        return cnt

            


s=Solution()
s.numberOfArrays(differences = [1,-3,4], lower = 1, upper = 6)
s.numberOfArrays(differences = [3,-4,5,1,-2], lower = -4, upper = 5)
s.numberOfArrays(differences = [4,-7,2], lower = 3, upper = 6)
s.numberOfArrays([-2,-2,-2], -5, -1)
s.numberOfArrays(differences = [3, -2, 4],
lower = 1,
upper = 10)
s.numberOfArrays([16550,-34031,14413,17198,9481,-3532,-27686,2316], -6880,39458)

        
