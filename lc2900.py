from typing import List


class Solution:
    def getLongestSubsequence(self, words: List[str], groups: List[int]) -> List[str]:
        tmp=groups[0]
        res =[]
        res.append(words[0])
        for i in range (len(words)):
            for j in range(i+1,len(words)):
                if groups[j] !=tmp:
                    res.append(words[j])
                    tmp = groups[j]
            break
        print(res)
        return res

s = Solution()
s.getLongestSubsequence(["c","w","h","s"], [0,0,0,1])

        
