from typing import List
class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        res=[]
        left=0
        right =len(matrix[0])-1 
        top =0
        bottom= len(matrix)-1
        while(top<=bottom and left<=right):
            # left to right
            for i in range(left, right+1):
                res.append(matrix[top][i])
            top+=1
            if top>bottom:
                break
            # top to bottom
            for i in range(top, bottom+1):
                res.append(matrix[i][right])
            right-=1
            if left>right:
                break
            # right to left
            for i in range(right, left-1 ,-1):
                res.append(matrix[bottom][i])
            bottom-=1
            # bottom to top
            for i in range(bottom, top-1 ,-1):
                res.append(matrix[i][left])
            left+=1
        return res
s= Solution()
s.spiralOrder([[1,2,3,4],[5,6,7,8],[9,10,11,12]])
s.spiralOrder([[1,2,3],[4,5,6],[7,8,9]])


        
