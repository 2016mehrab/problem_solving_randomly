import math
from typing import List
class Solution:
    def isPrime(self,num):
        if num == 1:
            return False
        if num > 2 and num%2==0:
            return False
        for i in range(3, int(math.sqrt(num)+1),2 ):
            if num%i == 0:
                return False
        return True

    def closestPrimes(self, left: int, right: int) -> List[int]:
        r =[]
        for i in range(left,right+1):
            if self.isPrime(i):
                if len(r)>0:
                    tmp =r[-1]-i
                    tmp =abs(tmp) 
                    if tmp<=2:
                        return [r[-1], i]
                r.append(i)
                
        i=0
        a=-1
        b=-1
        min_diff = float("inf")
        for j in range(1,len(r)):
            diff= abs(i-j)
            if diff < min_diff:
                min_diff = diff
                a=r[i]
                b=r[j]
            i+=1

        return [a,b] if a!=-1 else [-1,-1]



        
s= Solution()
print(s.closestPrimes(10,19))
print(s.closestPrimes(4,6))
print(s.closestPrimes(19,31))
print(s.closestPrimes(69346,69379))
