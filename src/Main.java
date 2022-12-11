public class Main {
    public static void main(String[] args) {
        String[][] matrix = {
                {"1","1","1","1","0"},
                {"1","1","0","1","0"},
                {"1","1","0","0","0"},
                {"0","0","0","0","0"}
        };
        System.out.println(findIslandNumber(matrix));
        System.out.println("Hello world!");
    }

    public static int findIslandNumber(String[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;

        for (int i = 0;i < rows;i++) {
            for (int j = 0; j < cols;j++) {
                if (matrix[i][j] == "1" && visited[i][j] == false) {
                    count++;
                    backTrack(matrix,visited,i,j,count);
                }
            }
        }
        return count;


    }

    public static void backTrack(String[][] matrix,boolean[][] visited, int i,int j,int count) {
        int maxRows = matrix.length;
        int maxCols = matrix[0].length;
        if (i <= 0 || i >= maxRows || j <= 0 || j >= maxCols || visited[i][j] == true||matrix[i][j].equals("0")) {
            return;
        }
        if (matrix[i][j].equals("1") ) {
            visited[i][j] = true;
            backTrack(matrix,visited,i+1,j,count);
            backTrack(matrix,visited,i-1,j,count);
            backTrack(matrix,visited,i,j+1,count);
            backTrack(matrix,visited,i,j-1,count);

        }
    }
}