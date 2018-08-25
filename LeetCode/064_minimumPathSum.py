class Solution:
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        height, width = len(grid), len(grid[0])
        sums = [[0]*width for _ in range(height)]

        sums[-1][-1] = grid[-1][-1]

        for j in range(width-2,-1,-1):
            sums[-1][j] = sums[-1][j+1] + grid[-1][j]

        for i in range(height-2,-1,-1):
            sums[i][-1] = sums[i+1][-1] + grid[i][-1]
            for j in range(width-2,-1,-1):
                sums[i][j] = min(sums[i+1][j], sums[i][j+1]) + grid[i][j]

        return sums[0][0]


if __name__ == "__main__":
    grid = [ [1,3,1], [1,5,1],[4,2,1]]
    print(Solution().minPathSum(grid))
