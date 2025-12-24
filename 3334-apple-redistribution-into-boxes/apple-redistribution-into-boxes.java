class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int total = 0;
        for (int i = 0; i < apple.length; i++) {
            total += apple[i];
        }
        
        for (int i = capacity.length-1; i >=0; i--) {
            total -= capacity[i];
            if (total <=0) return capacity.length-i;
        }
        return -1;
    }
}