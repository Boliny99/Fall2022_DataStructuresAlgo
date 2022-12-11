import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,0,16,20},{23,30,34,60}};
        int target = 16;
        System.out.println(search2DMatrix(matrix,target));
        setZeros(matrix);
        System.out.println(minimumPathSum(matrix));
        System.out.println("Hello world!");
    }

    public static boolean search2DMatrix(int[][] matrix,int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int currentRow = rows - 1;
        int currentCol = 0;
        while (currentRow >= 0 && currentCol <= cols-1) {
            if (matrix[currentRow][currentCol] == target) {
                return true;
            } else if (matrix[currentRow][currentCol] < target) {
                currentCol++;
            } else {
                currentRow--;
            }
        }
         return false;
    }

    public static void setZeros(int[][] matrix) {
        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> colSet = new HashSet<>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i =0;i < rows;i++) {
            for (int j = 0;j < cols;j++) {
                if (matrix[i][j] == 0) {
                    if (!rowSet.contains(i)) {
                        rowSet.add(i);
                    }
                    if (!colSet.contains(j)) {
                        colSet.add(j);
                    }
                }
            }
        }
        for (int i =0;i < rows;i++) {
            for (int j = 0;j < cols;j++) {
                if (rowSet.contains(i) || colSet.contains(j) ) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    private static int minimumPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] res = new int[rows][cols];
        res[0][0] = matrix[0][0];

        for (int i = 0;i < rows;i++) {
            res[i][0] = matrix[i][0] + res[i-1][0];
        }

        for (int j = 0;j < cols;j++) {
            res[0][j] = matrix[0][j] + res[0][j-1];
        }

        for (int i = 1;i < rows;i++) {
            for (int j = 1; j < cols;j++) {
                res[i][j] = Math.min(res[i-1][j], res[i][j-1]) + matrix[i][j];
            }
        }

        return res[rows-1][cols-1];
    }

    private static int waysObastacle(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] res = new int[rows][cols];
        matrix[0][0] = 1;

        for (int i = 1;i < rows;i++) {
            matrix[i][0] = matrix[i-1][0] == Integer.MIN_VALUE ? Integer.MIN_VALUE : 1;
        }

        for (int j = 1;j < cols;j++) {
            matrix[0][j] = matrix[0][j-1] == Integer.MIN_VALUE ? Integer.MIN_VALUE : 1;
        }

        for (int i = 1;i < rows;i++) {
            for (int j = 1; j < cols;j++) {
               if (matrix[i-1][j] == Integer.MIN_VALUE ) {
                   matrix[i][j] = matrix[i][j-1];
               } else if (matrix[i][j-1] == Integer.MIN_VALUE) {
                   matrix[i][j] = matrix[i-1][j];
               } else {
                   matrix[i][j] = matrix[i][j-1] + matrix[i-1][j];
               }
            }
        }
        return matrix[rows-1][cols-1];




    }
}