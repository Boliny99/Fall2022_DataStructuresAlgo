public class WordSearch {
    boolean res;
    public boolean exist(char[][] board, String word) {

        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        StringBuilder path = new StringBuilder();
        for (int i = 0; i < h; i++){
            for (int j = 0; j < w; j++){
                if (board[i][j] == word.charAt(0)){
                    check(board,visited,i,j,path,word);
                }
            }
        }
        return res;
    }





    public void check(char[][] board, boolean[][] visited,int i, int j, StringBuilder path, String s){

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] == true) return;
        if (!s.startsWith(path.toString())) return;

        path.append(board[i][j]);

        visited[i][j] = true;
        if (path.toString().equals(s)){
            res = true;
            return;
        }
        check(board,visited,i+1,j,path,s);
        check(board,visited,i-1,j,path,s);
        check(board,visited,i,j+1,path,s);
        check(board,visited,i,j-1,path,s);

        visited[i][j] = false;
        path.deleteCharAt(path.length() - 1);
    }
}