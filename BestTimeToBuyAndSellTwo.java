/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
public class BestTimeToBuyAndSellTwo {
	public int maxProfit(int[] stocks) {
		int maxProfit = 0;
		int current = 0;
		if (stocks.length == 0) {
			return 0;
		}
		int valley = stocks[0];
		int peak = stocks[0];

		while (current < stocks.length - 1) {
			while (current < stocks.length - 1
					&& stocks[current] >= stocks[current + 1]) {
				current++;
			}
			valley = stocks[current];
			while (current < stocks.length - 1
					&& stocks[current] <= stocks[current + 1]) {
				current++;
			}
			peak = stocks[current];
			maxProfit += peak - valley;
		}

		return maxProfit;
	}
}
