class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;

        long res;
        long curr_price = 0;

        for(int i=0; i<n; i++){
            curr_price += (long) strategy[i] * prices[i];
        }

        res =curr_price;

        for(int i=0; i<k; i++){
            if(i<k/2){
                curr_price += (long)prices[i]*(-strategy[i]);
            }
            else{
                curr_price += (long)prices[i]*(1-strategy[i]);
            }
        }
        res = Math.max(res,curr_price);

        for (int i = k ; i < n ; i++){
            curr_price += (long)prices[i]*(1-strategy[i]);
            curr_price += (long)prices[i-k]*(strategy[i-k]);
            curr_price += (long)prices[i-k/2]*(-1);
            res = Math.max(res,curr_price);
        }
        return res;
    }
}