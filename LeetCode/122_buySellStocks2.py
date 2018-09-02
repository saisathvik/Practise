class Solution:
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        n = len(prices)
        if n < 2:
            return 0
        profit = 0
        for i in range(n-1): 
            profit += prices[i+1] - prices[i] if prices[i+1] > prices[i] else 0

        return profit
        

if __name__ == "__main__":
    prices = [7, 1, 5, 3, 6, 4]
    print(Solution().maxProfit(prices))
