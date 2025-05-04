from typing import List
from collections import defaultdict


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        len_wordlist= defaultdict(set)
        steps = set()
        for word in wordDict: 
            len_wordlist[len(word)].add(word)
            steps.add(len(word))

        

        cache= defaultdict(bool)
        res =self.helper(s,steps, len_wordlist,cache)
        print(f"wordDict:{wordDict}")
        print(f"output: {res}")
        return res

    def helper(self, s,steps, len_wordlist,cache ):
        # base
        if s=='':
            return True
        if s in cache:
            return cache[s]
        for step in steps:
            if step<=len(s) and s[0:step] in len_wordlist[step]:
                if self.helper(s[step:], steps, len_wordlist,cache):
                    cache[s]=True
                    return True
        cache[s]=False
        return False

s= Solution()
s.wordBreak(s = "leetcode", wordDict = ["leet","code"])
s.wordBreak(s = "applepenapple", wordDict = ["apple","pen"])
s.wordBreak(s = "catsandog", wordDict = ["cats","dog","sand","and","cat"])
s.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"])
        
