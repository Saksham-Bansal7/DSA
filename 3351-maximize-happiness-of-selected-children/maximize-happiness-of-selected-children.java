class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long res = 0;
        for (int i = 0; i <k; i++) {
            res += Math.max(0,happiness[happiness.length-i-1]-i);
        }
        
        return res;
    }
}