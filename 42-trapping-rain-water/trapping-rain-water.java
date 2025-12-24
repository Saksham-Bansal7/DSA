class Solution {
    public int trap(int[] height) {
        int res = 0;
        
        Stack<Integer> st = new Stack<>();
        st.push(height[0]);
        for (int i = 1; i < height.length; i++) {
            if(st.peek() <= height[i]) {
                st.push(height[i]);
            }
        }
        int max = st.pop();
        int currMax = height[height.length - 1];
        for(int i = height.length-1; i >= 0; i--) {
            if(currMax < height[i]) {
                currMax = height[i];
            }
            if(max == height[i] && !st.empty()) {
                max = st.pop();
            }
            int water = Math.min(max, currMax) - height[i];
            if (water > 0) {
                res += water;
            }
        }
        return res;
    }
}