class Solution:
    def minimumRecolorsBF(self, blocks: str, k: int) -> int:
        minCnt=k
        for i in range(len(blocks) - k+1):
            j=i
            count =0
            while(j-i+1<=k and j<len(blocks)):
                if blocks[j] =='W':
                    count+=1
                j+=1
            minCnt = min(minCnt, count)

        print(minCnt)
        return minCnt 

    def minimumRecolors(self, blocks: str, k: int) -> int:
        minCnt=k
        l=0
        count=0
        for r in range(len(blocks)):
            if blocks[r] =='W':
                count+=1
            if r-l+1 == k:
                minCnt = min(minCnt, count)
                if blocks[l] == 'W':
                    count-=1
                l+=1

        print(minCnt)
        return minCnt 

        

s = Solution()
s.minimumRecolors("WBBWWBBWBW", 7)
s.minimumRecolors("WBWBBBW", 2)
s.minimumRecolors("BWWWBB", 6)
