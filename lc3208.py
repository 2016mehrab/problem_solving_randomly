from typing import List


class Solution:
    def numberOfAlternatingGroups(self, colors: List[int], k: int) -> int:
        groups=0
        N=len(colors)
        l=0
        for r in range(1,N+k-1):
            if colors[r%N] == colors[(r-1)%N]:
                l=r
            if r-(l)+1 ==k:
                groups+=1
                l+=1

        print(groups)
        return groups

s= Solution()
s.numberOfAlternatingGroups([0,1,0,1,0],3)
s.numberOfAlternatingGroups( [0,1,0,0,1,0,1],6)
s.numberOfAlternatingGroups([1,1,0,1],4)
        
