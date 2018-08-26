class Solution:
    def minDistance(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        """
        m, n = len(word1), len(word2)

        arr = [[0]*(m+1) for _ in range(n+1)]

        for i in range(m+1):
            arr[0][i] = i
        for i in range(n+1):
            arr[i][0] = i

        for i in range(1, n+1):
            for j in range(1, m+1):
                if word2[i-1] == word1[j-1]:
                    arr[i][j] = arr[i-1][j-1]
                else:
                    arr[i][j] = 1 + min(arr[i-1][j-1], arr[i-1][j], arr[i][j-1])
                

        return arr[n][m]
