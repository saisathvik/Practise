class Solution:
    def maxProfit(self, k, prices):
        """
        :type k: int
        :type prices: List[int]
        :rtype: int
        """
        n = len(prices)
        if n < 2:
            return 0
        res = self.checkMax(k, prices)
        if res > 0:
            return res
        dp = [[0]*n for _ in range(k+1)]
        for i in range(1, k+1):
            maxdiff = 0 - prices[0]
            for j in range(1, n):
                dp[i][j] = max(dp[i][j-1], prices[j] + maxdiff)
                maxdiff = dp[i-1][j] - prices[j] if dp[i-1][j] - prices[j] > maxdiff else maxdiff 
        return dp[k][n-1]
    
    def checkMax(self, k, prices):
        kmax, res = 0, 0
        for i in range(len(prices)-1):
            comp = prices[i+1] - prices[i]
            if comp > 0:
                res += comp
                kmax += 1
        if k >= kmax:
            return res
        else:
            return -1


if __name__ == "__main__":
    prices = [3, 3, 5, 0, 0, 3, 1, 4]
    k = 2
    print(Solution().maxProfit(k, prices))
