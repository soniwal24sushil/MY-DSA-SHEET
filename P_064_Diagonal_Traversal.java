import java.util.Arrays;

public class P_064_Diagonal_Traversal {

    // Todo: https://leetcode.com/problems/diagonal-traverse/

    // * T.C = O(m*n) & S.C = O(m*n).
    public static int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        int row = 0;
        int col = 0;
        int i = 0;
        boolean up = true; // Flag to indicate the direction of the diagonal

        while (row < m && col < n) {
            // If the diagonal is going up
            if (up) {
                // Traverse upwards
                while (row > 0 && col < n - 1) {
                    result[i++] = mat[row][col];
                    row--;
                    col++;
                }
                // Move to the next element in the diagonal
                result[i++] = mat[row][col];

                // Adjust row and col for the next diagonal element
                if (col == n - 1) {
                    row++;
                } else {
                    col++;
                }
            }
            // If the diagonal is going down
            else {
                // Traverse downwards
                while (col > 0 && row < m - 1) {
                    result[i++] = mat[row][col];
                    row++;
                    col--;
                }
                // Move to the next element in the diagonal
                result[i++] = mat[row][col];

                // Adjust row and col for the next diagonal element
                if (row == m - 1) {
                    col++;
                } else {
                    row++;
                }
            }

            // Toggle the direction for the next diagonal
            up = !up;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };

        System.out.println(Arrays.toString(findDiagonalOrder(matrix)));
    }
}