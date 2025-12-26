class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] closed = new int[n];
        if (customers.charAt(n - 1) == 'Y') {
            closed[n - 1] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (customers.charAt(i) == 'Y') {
                closed[i] = closed[i + 1] + 1;
            } else {
                closed[i] = closed[i + 1];
            }
        }
        int min = closed[0];
        int curr = 0;
        int res = 0;
        for (int i = 0; i < n-1; i++) {
            if (curr + closed[i+1] < min) {
                min = curr + closed[i+1];
                res = i + 1;
            }
            if (customers.charAt(i) == 'N') {
                curr++;
            }
        }
        if (n-closed[0] < min) {
            return  n;
        }
        return res;
    }
}