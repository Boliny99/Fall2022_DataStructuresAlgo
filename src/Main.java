public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    //Time complexity : O(n^2)
    //Space complexity: 0

    public static int findRoute(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;


        for (int i = 0;i < rows;i++) {
           matrix[i][0] = matrix[i-1][0] == Integer.MIN_VALUE ? Integer.MIN_VALUE : 1;
        }

        for (int j = 0; j < cols;j++) {
            matrix[0][j] = matrix[0][j-1] == Integer.MIN_VALUE ? Integer.MIN_VALUE : 1;
        }

        for (int i = 0;i < rows;i++) {
            for (int j = 0; j < cols;j++) {
                if (matrix[i-1][j] == Integer.MIN_VALUE) {
                    matrix[i][j] = matrix[i][j-1];
                } else if (matrix[i][j-1] == Integer.MIN_VALUE){
                    matrix[i][j] = matrix[i-1][j];
                } else {
                    matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
                }
            }
        }
        return matrix[rows-1][cols-1];

    }
}