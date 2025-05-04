from typing import List
from collections import defaultdict


class Solution:
    def numEquivDominoPairs(self, dominoes: List[List[int]]) -> int:
        count = defaultdict(int)
        res=0
        for i in range(len(dominoes)):
            key =str(min(dominoes[i][0],dominoes[i][1]))+"-"+str(max(dominoes[i][0],dominoes[i][1])) 
            if key in count:
                res+=count[key]
            count[key]+=1

        return res
        
s= Solution()
s.numEquivDominoPairs(dominoes = [[1,2],[2,1],[3,4],[5,6]])
s.numEquivDominoPairs(dominoes = [[1,2],[1,2],[1,1],[1,2],[2,2]])
