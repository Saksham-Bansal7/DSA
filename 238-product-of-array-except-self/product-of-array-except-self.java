class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] suffix = new int[n];
        suffix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            suffix[i] = nums[i] * suffix[i - 1];
        }
        int [] prefix = new int[n];
        prefix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            prefix[i] = nums[i] * prefix[i + 1];
        }

        int [] result = new int[n];
        result[0] = prefix[1];
        result[n - 1] = suffix[n - 2];
        for (int i = 1; i < n-1; i++) {
            result[i] = suffix[i-1] * prefix[i+1];
        }
        return result;
    }
}