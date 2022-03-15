package leetcode;

public class BestTimeBuySellStock {

    public static void main(String[] args) {
        BestTimeBuySellStock btbss = new BestTimeBuySellStock();
        System.out.println(btbss.maxProfit1(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(btbss.maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public int maxProfit1(int[] prices) {
        int max1 = 0;
        int max2 = 0;
        for (int i = 1; i < prices.length; i++) {
            max1 = Math.max(0, max1 += prices[i] - prices[i - 1]);
            max2 = Math.max(max1, max2);
        }
        return max2;
    }

    public int maxProfit2(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int sell = 0;
        for (int price : prices) {
            buy = Math.min(price, buy);
            sell = Math.max(sell, price - buy);
        }
        return sell;
    }
}
