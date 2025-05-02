class Solution:
    def pushDominoes(self, dominoes: str) -> str:
        D = len(dominoes)
        rightPush=[-1]*D
        leftPush=[-1]*D
        lastSeenR=-1
        lastSeenL=-1
        for i in range(D):
            if dominoes[i]=='R':
                lastSeenR = i
            if dominoes[i]=='L':
                lastSeenR = -1
            rightPush[i]=lastSeenR

        for i in reversed(range(D)):
            if dominoes[i]=='L':
                lastSeenL = i
            if dominoes[i]=='R':
                lastSeenL = -1
            leftPush[i]=lastSeenL
        res =[]
        for i in range(D):
            if leftPush[i]==-1 and rightPush[i] != -1:
                res.append('R')
                continue
            if leftPush[i]!=-1 and rightPush[i] == -1:
                res.append('L')
                continue
            leftForce=abs(i - leftPush[i]) 
            rightForce=abs(i - rightPush[i]) 
            if leftForce - rightForce ==0:
                res.append(".")
            elif leftForce - rightForce < 0:
                res.append('L')
            else:
                res.append('R')

        res = "".join(res)
        print(f"{dominoes}, output: {res}")
        return res
        
s= Solution()
s.pushDominoes(dominoes = "RR.L")
s.pushDominoes(dominoes = ".L.R...LR..L..")
