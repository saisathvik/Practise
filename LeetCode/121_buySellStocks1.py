class Solution:
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        n = len(prices)
        
        if n < 2:
            return 0

        buy_price = prices[0]
        profit = 0

        for i in range(1, n):
            if buy_price+profit < prices[i]:
                profit = prices[i]-buy_price
            elif buy_price > prices[i]:
                buy_price = prices[i]

        return profit

if __name__ == "__main__":
    prices = [7, 1, 5, 3, 6, 4]
    print(Solution().maxProfit(prices))
