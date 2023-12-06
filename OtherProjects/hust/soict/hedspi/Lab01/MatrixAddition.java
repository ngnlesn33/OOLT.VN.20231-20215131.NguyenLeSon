package OtherProjects.hust.soict.hedspi.Lab01;

import java.util.Scanner;


public class MatrixAddition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the dimensions of the matrices
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();

        // Initialize the matrices
        int[][] matrix1 = new int[rows][columns];
        int[][] matrix2 = new int[rows][columns];

        // Get the elements of the first matrix
        System.out.println("Enter elements for the first matrix:");
        getMatrixElements(scanner, matrix1);

        // Get the elements of the second matrix
        System.out.println("Enter elements for the second matrix:");
        getMatrixElements(scanner, matrix2);

        // Check if the matrices have the same dimensions
        if (matrix1[0].length != matrix2[0].length) {
            System.out.println("Matrices must have the same dimensions for addition.");
            return;
        }

        // Add the matrices
        int[][] resultMatrix = addMatrices(matrix1, matrix2);

        // Print the result matrix
        System.out.println("Resultant Matrix:");
        printMatrix(resultMatrix);

        scanner.close();
    }

    // Helper method to get elements of a matrix from user
    public static void getMatrixElements(Scanner scanner, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("Enter element [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    // Helper method to add two matrices
    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int columns = matrix1[0].length;

        int[][] resultMatrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return resultMatrix;
    }

    // Helper method to print a matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
