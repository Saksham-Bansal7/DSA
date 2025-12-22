class Solution {
    public int findDuplicate(int[] nums) {
    int n = nums.length;

    for (int i = 0; i < n; i++) {
        while (nums[i] != i + 1) {
            int temp = nums[nums[i] - 1];

            if (temp == nums[i]) {
                return nums[i];  
            }

            nums[nums[i] - 1] = nums[i];
            nums[i] = temp;
        }
    }

    return -1; 
}

}