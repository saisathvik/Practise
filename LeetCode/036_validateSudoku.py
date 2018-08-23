class Solution:
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        # check rows
        for i in range(9):
            if not(self.checkList(board[i])):
                return False
        
        #check columns
        for j in range(9):
            if not(self.checkList([row[j] for row in board])):
                return False
            
        #check 3x3 squares
        for i in range(3):
            for j in range(3):
                if not(self.checkList([board[x][y] for x in range(3*i,3*(i+1)) for y in range(3*j,3*(j+1))]) ):
                    return False
        return True
                
    def checkList(self, sudoku_group):
        
        # nums = ["1","2","3","4","5","6","7","8","9"]
        
        #Group can be a row or column or 3x3 square of Sudoku
        if len(sudoku_group) != 9:
            return False
        
        #if number repeats in a group, it is not valid
        sudoku_group = [x for x in sudoku_group if x != "."]
        if len(sudoku_group) == len(set(sudoku_group)):
            return True
        """
        if sudoku_group.count(".")+len(set(sudoku_group)) == 10:
            return True
        """
