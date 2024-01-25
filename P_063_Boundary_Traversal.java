import java.util.ArrayList;

public class P_063_Boundary_Traversal {

    // Todo:
    // https://www.geeksforgeeks.org/problems/boundary-traversal-of-matrix-1587115620/1

    // * T.C = O(max(rows,cols)) & S.C = O(1).
    public static ArrayList<Integer> boundaryTraversal(int matrix[][], int rows, int cols) {
        ArrayList<Integer> result = new ArrayList<>();

        // Traverse the top row
        for (int i = 0; i < cols; i++) {
            result.add(matrix[0][i]);
        }

        // Traverse the rightmost column
        for (int i = 1; i < rows; i++) {
            result.add(matrix[i][cols - 1]);
        }

        // Traverse the bottom row, if there is more than one row
        if (rows > 1) {
            for (int i = cols - 2; i >= 0; i--) {
                result.add(matrix[rows - 1][i]);
            }
        }

        // Traverse the leftmost column, if there is more than one column
        if (cols > 1) {
            for (int i = rows - 2; i > 0; i--) {
                result.add(matrix[i][0]);
            }
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

        ArrayList<Integer> boundaryResult = boundaryTraversal(matrix, matrix.length, matrix[0].length);

        // Print the result
        System.out.println("Boundary Traversal: " + boundaryResult);
    }
}