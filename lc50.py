class Solution:
    def myPow(self, x: float, n: int) -> float:
        def fast_expo(num, expo):
            if expo==0:
                return 1
            half= fast_expo(num,expo//2)
            res = half * half
            if(expo%2==1):
                res *= num

            return res
        m = fast_expo(x, abs(n))
        m= 1/m if n<0 else m
        print(f"x:{x}, n:{n}, output:{m}")
        return m
s= Solution()
# s.myPow(x = 2.00000, n = 10)
# s.myPow(x = 2.10000, n = 3)
s.myPow(x = 2.00000, n = -2)
        
