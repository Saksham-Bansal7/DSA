class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();

        int [] dp = new int[m];
        Arrays.fill(dp,1);

        int res = 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<i;j++){

                boolean ok  = true;
                for(int k=0;k<n;k++){
                    if (strs[k].charAt(j) > strs[k].charAt(i)) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }


            }
            res = Math.max(res,dp[i]);
        }
        return m- res;
    }

}