package problems;

/**
 * Created by WangSai on 2019-05-19 23:49
 *
 * 题目链接：https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * 题目描述：
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Example 2:
 *
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 */


public class P122_BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length-2; i++) {
            int profit = maxProfit(prices, i, prices.length - 1);
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;

    }

    private int maxProfit(int[] prices, int left, int right) {
        for (int i = left; i < right; i++) {
            int price = prices[i];

        }
        return 0;
    }
}
