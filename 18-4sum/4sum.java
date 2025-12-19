class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        Set<Set<Integer>> set = new HashSet<>();

        for (int l = 0; l < nums.length; l++) {
            for (int i = l+1; i < nums.length - 2; i++) {
                Set<Integer> tempSet = new HashSet<>();
                tempSet.add(nums[l]);
                tempSet.add(nums[i]);
                if (set.contains(tempSet)) {
                    continue;
                }
                set.add(tempSet);

                int j = i + 1;
                int k = nums.length - 1;

                while (j < k) {
                    long sum =(long) nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        res.add(temp);

                        while (j < k && nums[j] == nums[j + 1]) j++;
                        while (j < k && nums[k] == nums[k - 1]) k--;

                        j++;
                        k--;
                    }
                    else if (sum < target) {
                        j++;
                    }
                    else {
                        k--;
                    }
                }
            }
        }


        return res;
    }
}