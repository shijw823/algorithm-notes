package com.demo.practice;

/**
 * @author shijianwei
 * @date 2025/12/29
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 */
public class MaxProfitTest {

    // 时间复杂度O(n)，空间复杂度O(1)
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    // 这个更好记
    public int maxProfit_(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    // https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/submissions/151494882/
    public int maxProfit2(int[] prices) {
        int maxProfit = 0;

        for(int i=1;i<prices.length;i++) {
            maxProfit += Math.max(0, prices[i] - prices[i-1]);
        }

        return maxProfit;
    }
}
