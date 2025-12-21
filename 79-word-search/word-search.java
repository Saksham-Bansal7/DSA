class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if (Search(board, word, 0, i, j, visited)) {
                        return true;
                    }
            }
        }
        return false;
    }
    private boolean Search(char[][] board,String word,int curr,int i,int j,boolean[][] visited){
        if(curr==word.length()){
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) {
            return false;
        }

        if (word.charAt(curr) != board[i][j]) {
            return false;
        }
        visited[i][j]=true;


        if (Search(board, word, curr + 1, i + 1, j, visited)) return true;
        if (Search(board, word, curr + 1, i - 1, j, visited)) return true;
        if (Search(board, word, curr + 1, i, j + 1, visited)) return true;
        if (Search(board, word, curr + 1, i, j - 1, visited)) return true;


        visited[i][j]=false;
        return false;

    }
}