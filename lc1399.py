class Solution:
    def countLargestGroup(self, n: int) -> int:
        map=[0]*37
        def digitSum(num):
            sum=0
            while(num>0):
                sum+=num%10
                num//=10

            return sum
        res=1
        for i in range(1,n+1):
            idx=digitSum(i)
            map[idx]+=1
            res=max(res, map[idx])
        cnt=0
        for num in map:
            if num==res:
                cnt+=1


        print(cnt)
        return cnt

s= Solution()
s.countLargestGroup(13)
s.countLargestGroup(2)
s.countLargestGroup(9999)
        
