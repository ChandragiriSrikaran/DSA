class Solution {
    public int maxProfit(int[] prices) {
        int buy=prices[0];
        int prof=Integer.MIN_VALUE;
        int n=prices.length;
        for(int i=0;i<n;i++){
            prof=Math.max(prof,prices[i]-buy);
            buy=Math.min(buy,prices[i]);
        }
        return prof;
    }
}