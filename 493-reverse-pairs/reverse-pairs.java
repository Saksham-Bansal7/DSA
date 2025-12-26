class Solution {
    public int reversePairs(int[] nums) {
        return sort(nums , 0 , nums.length - 1);
    }
    public int sort(int[] nums , int left , int right) {
        if (left >= right) return 0;
        int mid = (left + right)/2;
        int res = sort(nums , left , mid);
        res += sort(nums , mid+ 1 , right);
        res += merge(nums , left , mid, right);
        return res;
    }

    public int merge(int[] nums , int left , int mid ,int right) {
    int count = 0;
    int j = mid + 1;

    for (int i = left; i <= mid; i++) {
        while (j <= right && nums[i] > (long)2 * nums[j]) {
            j++;
        }
        count += (j - (mid + 1));
    }

    ArrayList<Integer> res = new ArrayList<>();
    int i = left;
    j = mid + 1;

    while (i <= mid && j <= right) {
        if (nums[i] > nums[j]) {
            res.add(nums[j++]);
        } else {
            res.add(nums[i++]);
        }
    }

    while (i <= mid) res.add(nums[i++]);
    while (j <= right) res.add(nums[j++]);

    for (int k = left; k <= right; k++) {
        nums[k] = res.get(k - left);
    }

    return count;
}

}