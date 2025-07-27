from typing import List


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        M = len(board)
        N = len(board[0])

        # 0 -> 1 represented by 2
        # 1 -> 0 represented by 3
        # 1 -> 1 represented by 4
        # 1 -> 0 represented by 5

        def getLiveNeighbors(x,y):
            R=x+1
            C=y+1
            start_x = max(0,x-1)
            start_y = max(y-1,0)
            cnt=0
            for r in range(start_x, min(M,R+1) ):
                for c in range(start_y, min(C+1, N)):
                    if r==x and c==y:
                        continue
                    if (board[r][c]==1 or board[r][c]==3 or board[r][c]==4 or board[r][c]==5):
                        cnt+=1
            return cnt
                    

        for r in range(M):
            for c in range(N):
                livingNgbr = getLiveNeighbors(r,c)
                if (board[r][c]==1 or board[r][c]==3 or board[r][c]==4 or board[r][c]==5):
                    if livingNgbr < 2:
                        # dies of under-population
                        board[r][c] =5
                    elif livingNgbr>=2 and livingNgbr <=3:
                        # lives
                        board[r][c] =4
                    else :
                        # dies of overpopulation
                        board[r][c] =3
                else :
                    if livingNgbr ==3:
                        # reproduction
                        board[r][c] =2
        # 0 -> 1 represented by 2
        # 1 -> 0 represented by 3
        # 1 -> 1 represented by 4
        # 1 -> 0 represented by 5
        for r in range(M):
            for c in range(N):
                if board[r][c] ==3 or board[r][c] ==5:
                    board[r][c] =0
                elif board[r][c] ==2 or board[r][c] ==4 :
                    board[r][c] =1

        for r in board:
            print(r)
            print()






s=Solution()
s.gameOfLife(board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]])
        
