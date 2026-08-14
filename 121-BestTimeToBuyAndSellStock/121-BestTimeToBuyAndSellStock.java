// Last updated: 8/14/2026, 10:08:58 AM
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            // update minimum buying price
            if (price < minPrice) {
                minPrice = price;
            } 
            // calculate profit if selling today
            else {
                int profit = price - minPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }
}