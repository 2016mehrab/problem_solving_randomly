from typing import List

class Solution:
    MAX=12000
    def coinChange(self, coins: List[int], amount: int) -> int:
        # dp [k] = minimum coins to make amount k
        dp=[Solution.MAX]  * (amount+1)
        dp[0] =0
        # dp[1] =1
        # dp[2] =1
        # dp[5] =1
        for i in range(1,amount+1):
            # i = amount
            for coin in coins:
                if i-coin <0:
                    continue
                # current coin +
                if( dp[i] > dp[i-coin]):
                    dp[i] =1+ min(dp[i],dp[i-coin])


#        dp [amount] = min(dp[amount-coin1], dp[amount-coin2], dp[amount-coin3])
        if dp[amount] >=Solution.MAX:
            dp[amount] =-1
        print(f"{coins}, {amount} : {dp[amount]}")
        return dp[amount]


s= Solution()
s.coinChange(coins = [1,5,2], amount = 11)
s.coinChange(coins = [2], amount = 3)
s.coinChange(coins = [1], amount = 0)
s.coinChange(coins = [2,5,10,1], amount = 27)
        
