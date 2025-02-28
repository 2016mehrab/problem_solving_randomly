class Solution:
    def bt(self,i,j, str1, str2,dp):
        if (i,j) in dp:
            return dp[(i,j)]
        if i >= len(str1):
            return str2[j:]
        if j >= len(str2):
            return str1[i:]
        if str1[i] == str2[j]:
            return str1[i] + self.bt(i+1,j+1, str1, str2,dp)
        res1 = str1[i]+ self.bt(i+1,j, str1, str2,dp)
        res2 = str2[j]+ self.bt(i,j+1, str1, str2,dp)
        if len(res1) > len(res2):
            dp[( i,j )] = res2
            return res2

        dp[( i,j )] = res1
        return res1

    def shortestCommonSupersequenceTP(self, str1: str, str2: str) -> str:
        dp = {}
        res =self.bt(0,0,str1,str2, dp)
        print(res)
        return res


s = Solution()
# s.shortestCommonSupersequence("abac", "cab")
# s.shortestCommonSupersequence("abac", "xz")

        
