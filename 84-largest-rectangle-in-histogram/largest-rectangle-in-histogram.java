class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (st.isEmpty() || heights[st.peek()] <= heights[i]) {
                st.push(i);
            }
            else{
                int height = heights[st.pop()];
                int width = st.empty() ? i : i - st.peek()-1;
                i--;
                res = Math.max(res, width*height);
            }
        }
        while(!st.isEmpty()){
            int height = heights[st.pop()];
            int width = st.empty() ? n : n-st.peek()-1;
            res = Math.max(height*width , res);
        }
        return res;
    }
}