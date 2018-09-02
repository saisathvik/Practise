class Solution:
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        n = len(prices)
        if n < 2:
            return 0
        profits = [0]
        buy_price, profit = prices[0], 0
        for i in range(1, n):
            if buy_price+profit < prices[i]:
                profit = prices[i] - buy_price
            elif buy_price > prices[i]:
                buy_price = prices[i]
            profits.append(profit)

        profit_max = profits[-1]
        sell_price, profit = prices[-1], 0
        for i in range(n-2, -1, -1):
            if sell_price-profit > prices[i]:
                profit = sell_price - prices[i]
            elif sell_price < prices[i]:
                sell_price = prices[i]
            if profit_max < profit + profits[i]:
                profit_max = profit + profits[i]
        return profit_max


if __name__ == "__main__":
    prices = [1,2,4,2,5,7,2,4,9,0]
    print(Solution().maxProfit(prices))
