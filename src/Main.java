import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[][] matrix  = {
                {"o","a","a","n"},
                {"e","t","a","e"},
                {"i","h","k","r"},
                {"i","f","l","v"}};
        String[] words = {"oath","pea","eat","rain"};
        ArrayList<String> matchWords = getAllMatches(matrix,words);
        System.out.println("Hello world!");
    }

    private static ArrayList<String> getAllMatches(String[][] matrix,String[] words) {
        int row = matrix.length;
        int col = matrix[0].length;

        ArrayList<String> matchWords = new ArrayList<>();
        for (String word : words) {
            boolean[][] visited = new boolean[row][col];
            for (int i =0;i < row;i++) {
                for (int j = 0;j < col;j++) {
                    findWord(matrix,word,0,i,j,visited,matchWords);
                }
            }
        }
        return matchWords;

    }

    private static void findWord(String[][] matrix,String word,int index,int row,int col, boolean[][] visited, ArrayList<String> matchWords) {
        int maxRow = matrix.length;
        int maxCol = matrix[0].length;
        if(row < 0 || col < 0 || row >= maxRow || col >= maxCol) {
            return;
        }
        if (visited[col][row] == true) {
            return;
        }

        if( index== word.length() - 1 && matrix[row][col].charAt(0) == word.charAt(index)) {
            matchWords.add(word);
            return;
        }
        if (matrix[row][col].charAt(0) != word.charAt(index)) {
            return;
        }

        visited[row][col] = true;

        findWord(matrix,word,index+1,row,col+1,visited,matchWords);
        findWord(matrix,word,index+1,row,col-1,visited,matchWords);
        findWord(matrix,word,index+1,row-1,col,visited,matchWords);
        findWord(matrix,word,index+1,row+1,col,visited,matchWords);
    }
}