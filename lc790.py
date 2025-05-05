class Solution:
    
    MOD = 10**9+7

    def numTilings(self, n: int) -> int:
        dp = [[-1] * 4 for _ in range(n+1)]

        def makeState(t1, t2):
            if not t1 and not t2: return 3
            if t1 and not t2: return 1
            if not t1 and t2: return 2
            return 0

    # t1 t3
    # t2 t4
        def f(i, t1, t2):
            if i == n:
                return 1
            state = makeState(t1,t2)

            if dp[i][state]!=-1:
                return dp[i][state]

            if i == 1 and state==0:
                print("debug")
            t3, t4 =0,0
            if i+1 < n:
                t3,t4 = i+1 , i+1
            cnt =0
            # vertical domino
            if t1 and t2 :
                cnt+= f(i+1, True, True)
            # tromino top,bottom-(2,1)
            if t1 and t2 and t3:
                cnt+= f(i+1, False, True)

            # tromino top,bottom-(1,2)
            if t1 and t2 and t4:
                cnt+= f(i+1, True,False)

            if t1 and not t2 and t3 and t4 :
                cnt+= f(i+1, False, False)

            # tromino top,bottom-(1,2)
            if not t1 and t2 and t3 and t4:
                cnt+= f(i+1, False, False)
            # two domino horizontal
            if t1 and t2 and t3 and t4:
                cnt+= f(i+1, False, False)
            if t1 and not t2 and t3:
                cnt+= f(i+1, False, True)
            if not t1 and t2 and t4:
                cnt+= f(i+1, True, False)
            if not t1 and not t2:
                cnt+= f(i+1, True, True)
            dp[i][state] = cnt% Solution.MOD
            return dp[i][state]

        r =f(0, True, True)
        print(f"n:{n} ,output: {r}") 
        return r

s= Solution()
s.numTilings(3)
s.numTilings(1)
