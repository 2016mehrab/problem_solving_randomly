def triTiling(n):
    dp = [[-1] * 8 for _ in range(n+1) ]
    if n%2==1:
        return 0
    def encodeState(t1,t2,t3):
        T1,T2,T3=0,0,0
        T1 |= t1
        T2 |= t2
        T3 |= t3
        return T1*4 + T2*2 + T3 * 1

    def f(i , t1,t2,t3):
        if i==n and t1 and t2 and t3:
            return 1
        elif i==n:
            return 0
        state = encodeState(t1,t2,t3)
        if dp[i][state]!=-1:
            return dp[i][state]

        cnt =0
        if t1 and t2 and t3:
            cnt+=f(i+1, False,True, True)
            cnt+=f(i+1, False,False, False)
            cnt+=f(i+1, True,True,False )
        if not t1 and t2 and t3:
            cnt+=f(i+1, True,False, False)
            cnt+=f(i+1, True,True,True )
        if t1 and t2 and not  t3:
            cnt+=f(i+1, False, False, True)
            cnt+=f(i+1, True,True,True )
        if t1 and not t2 and t3:
            cnt+=f(i+1, False,  True,False)
        if not t1 and t2 and  not t3:
            cnt+=f(i+1,   True ,False,True)
        if t1 and not t2 and  not t3:
            cnt+=f(i+1,   False,True,True)
        if not t1 and not t2 and  t3:
            cnt+=f(i+1, True,True, False)
        if not t1 and not t2 and not t3:
            cnt+=f(i+1, True,True, True)

        dp[i][state]= cnt
        return dp[i][state]
    r = f(0, True, True,True)
    return r

while True:
    n= int(input())
    if n==-1:
        break
    print(triTiling(n))

