class Solution:
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        n = len(triangle)
        if n == 1:
            return triangle[0][0]

        for i in range(n-1, 0, -1):
            for j in range(i):
                triangle[i-1][j] += triangle[i][j] if triangle[i][j] < triangle[i][j+1] else triangle[i][j+1]

        return triangle[0][0]


if __name__ == "__main__":
    triangle = [[2],
                [3, 4],
                [6, 5, 7],
                [4, 1, 8, 3]]
    print(Solution().minimumTotal(triangle))
