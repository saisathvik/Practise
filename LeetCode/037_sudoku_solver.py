import copy
class Solution:
    def solveSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        N = {"1","2","3","4","5","6","7","8","9"}
        
        # create dict for possible values with position in board as key
        poss = {}
        
        for i in range(9):
            for j in range(9):
                if board[i][j] == ".":
                    elm = set( board[i] + [row[j] for row in board] + [board[x][y] for x,y in self.points_in_box(i,j)] ) - {"0"}
                    poss[(i,j)] = list(N - elm)
        
        self.solve_dict(board,poss)
        
    def points_in_box(self,i,j):
        box_x, box_y = 3*int(i/3),3*int(j/3)
        box = [(box_x + x,box_y + y ) for x in range(0,3) for y in range(0,3)]
        return box
    
    def remove_the_poss(self,poss,t,v):
        for p in poss.keys():
            if p[0] == t[0] or p[1] == t[1] or p in self.points_in_box(t[0],t[1]):
                if v in poss[p]:
                    poss[p].remove(v)
        del poss[t]

    def solve_dict(self,board,poss):
        if len(poss) == 0:
            return 0 # dictionary solved
        
        min_poss = min(poss.items(), key = lambda x : len(x[1]))
        
        if len(min_poss[1]) == 0:
            return 1 # dictionary unsolvable
        
        if len(min_poss[1]) == 1:
            board[min_poss[0][0]][min_poss[0][1]] = min_poss[1][0]
            self.remove_the_poss(poss,min_poss[0],min_poss[1][0])
            return self.solve_dict(board,poss)
        
        elif len(min_poss[1]) > 1:
            temp_poss = copy.deepcopy(poss)
            self.remove_the_poss(temp_poss,min_poss[0],min_poss[1][0])
            flag = self.solve_dict(board,temp_poss)
            
            del  temp_poss
            
            if flag == 0:
                board[min_poss[0][0]][min_poss[0][1]] = min_poss[1][0]
                return 0
            elif flag == 1:
                poss[min_poss[0]].remove(min_poss[1][0])
                return self.solve_dict(board,poss)
