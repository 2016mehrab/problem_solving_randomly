from collections import defaultdict

class Solution:
    MOD = 10**9+7
    def countBalancedPermutations(self, num: str) -> int:
        dp = defaultdict(int)
        digit_count  = [0] * 10
        N = len(num)
        def digitSum(num_str):
            sum=0
            for ch in num_str:
                n = int(ch)
                digit_count[n]+=1
                sum+= n
            return sum

        ds =digitSum(num) 
        if ds%2==1:
            return 0

        def helper(idx, evenSum, oddSum):

            if idx== N :
                return 1 if evenSum==oddSum else 0
            key = (idx,evenSum,oddSum,tuple(digit_count))
            if key in dp:
                return dp[key]
            cnt =0
            for i,n in enumerate(digit_count) :
                # taking 
                 #can't take
                if n<= 0:
                    continue
                if idx%2==0:
                    evenSum+= i
                else:
                    oddSum+= i
                digit_count[i]=max(digit_count[i]-1, 0)
                #call recursion for next position
                cnt= (cnt +helper(idx+1,evenSum,oddSum))%Solution.MOD

                # restore 
                digit_count[i]+=1
                if idx%2==0:
                    evenSum-= i
                else:
                    oddSum-= i
            dp[key] =cnt%Solution.MOD
            return cnt


            
            
        # needs to be in a loop
        r = helper(0, 0, 0)

        print(f"num:{num}, output:{r}")
        return r

s= Solution()
s.countBalancedPermutations("123")
s.countBalancedPermutations("112")
s.countBalancedPermutations("12345")
s.countBalancedPermutations("022")
s.countBalancedPermutations( "9346321721")
s.countBalancedPermutations("96509861244547846")
        
