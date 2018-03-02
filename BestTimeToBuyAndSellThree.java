/*
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 */
public class BestTimeToBuyAndSellThree {
	public int maxProfit(int[] prices) {

		return maxProfitSingular(prices);
	}

	private int maxProfitSingular(int[] prices) {
		int maxProfit = 0;
		int current = 0;
		if (prices.length == 0) {
			return 0;
		}
		int[] left = new int[prices.length];
		int[] right = new int[prices.length];
		left[0] = 0;
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			left[i] = Math.max(left[i - 1], prices[i] - min);
		}

		right[prices.length - 1] = 0;
		int max = prices[prices.length - 1];
		for (int j = prices.length - 2; j >= 0; j--) {
			max = Math.max(max, prices[j]);
			right[j] = Math.max(right[j + 1], max - prices[j]);
		}

		for (int k = 0; k < prices.length; k++) {
			maxProfit = Math.max(maxProfit, left[k] + right[k]);
		}

		return maxProfit;
	}
}
