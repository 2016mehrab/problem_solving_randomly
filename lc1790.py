class Solution:
    def areAlmostEqual(self, s1: str, s2: str) -> bool:
        notEq= []
        if len(s1) != len(s2):
            return False
        if s1 == s2:
            return True
        for i in range(len(s1)):
            if s1[i]!=s2[i]:
                notEq.append([i,i])
            if len(notEq)>2:
                return False
        
        if len(notEq)<2:
            return False
        s1i, s2i= notEq.pop()
        return s1[s1i] == s2[notEq[0][1]] and s2[s2i] == s1[notEq[0][0]] 

s= Solution()
print(s.areAlmostEqual("bank", "kanb"))
print(s.areAlmostEqual("attack", "defend"))
print(s.areAlmostEqual("kelb", "kelb"))

