class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int val = grid[i][j];
                int r = (val - 1) / n;
                int c = (val - 1) % n;

                if (grid[r][c] != val) {
                    int temp = grid[r][c];
                    grid[r][c] = val;
                    grid[i][j] = temp;
                    j--; 
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int expected = i * n + j + 1;
                if (grid[i][j] != expected) {
                    res.add(grid[i][j]); 
                    res.add(expected);
                }
            }
        }

        int[] resArray = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArray[i] = res.get(i);
        }
        return resArray;
    }
}