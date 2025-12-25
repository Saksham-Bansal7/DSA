class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for  (int i = 0; i < k; i++){
            pq.offer(new int[]{nums[i],i});
        }
        int[] res = new int[nums.length-k+1];
        res[0] = pq.peek()[0];
        for(int i = k; i < nums.length; i++){
            pq.offer(new int[]{nums[i],i});
            while (pq.peek()[1] <= i - k) {
            pq.poll();
        }
            res[i-k+1] = pq.peek()[0];
        }
        return res;

    }
}