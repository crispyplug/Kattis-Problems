
/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class BestTimeToBuyAndSellStocks {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		while (sc.hasNext()) {
			String n = sc.nextLine();
			String[] line = n.split(",");
			for (String x : line) {
				int l = Integer.parseInt(x.trim());
				list.add(l);
			}
		}
		// System.out.println(maxProfit(list));
	}

	public static int maxProfit(int[] stocks) {
		int maxProfit = 0;
		int currentProfit = 0;
		int currentBuy = -1;
		for (int i = 0; i < stocks.length; i++) {
			if (currentBuy == -1) {
				currentBuy = stocks[i];
			} else {
				currentProfit = (stocks[i] - currentBuy);
				if (currentProfit < 0) {
					currentProfit = 0;
					currentBuy = stocks[i];
				}
				if (currentProfit > maxProfit) {
					maxProfit = currentProfit;
				}

			}
		}

		return maxProfit;
	}
}
