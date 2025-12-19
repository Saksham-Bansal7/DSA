class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(set.contains(grid[i][j])){
                    res.add(grid[i][j]);
                }
                set.add(grid[i][j]);
            }
        }
        for (int i = 0; i < n*m; i++) {
            if(!set.contains(i+1)){
                res.add(i+1);
            }
        }

        int[] resArray = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArray[i] = res.get(i);
        }
        return resArray;
    }
}