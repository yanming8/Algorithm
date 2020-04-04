package dynamicprogramming;

/**
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Administrator
 *
 */
public class StockMaxProfit2 {
	public int maxProfit(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}
		int[][] dp = new int[prices.length][2];
		for (int i = 0; i < dp.length; i++) {
			if (i == 0) {
				dp[i][0] = 0;
				dp[i][1] = 0 - prices[i];
				continue;
			}
			if (i == 1) {
				dp[1][0] = Math.max(0, dp[0][1] + prices[i]);
				dp[1][1] = Math.max(dp[0][1], 0 - prices[i]);
				continue;
			}
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
			dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
		}
		return dp[prices.length - 1][0];
	}

	public int maxProfit1(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}
		int dp_i_0 = 0;
		int dp_i_1 = Integer.MIN_VALUE;
		int dp_pre_0 = 0;
		for (int i = 0; i < prices.length; i++) {
			int temp = dp_i_0;
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
			dp_pre_0 = temp;
		}
		return dp_i_0;
	}
}
