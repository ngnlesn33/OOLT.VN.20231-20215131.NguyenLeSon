package Lab01;

import java.util.Scanner;

public class TriangleStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for the height of the triangle
        System.out.print("Enter the height of the triangle: ");
        int n = scanner.nextInt();

        // Loop through each row
        for (int i = 1; i <= n; i++) {
            // Print spaces before the stars
            for (int j = n - i; j > 0; j--) {
                System.out.print(" ");
            }

            // Print stars for this row
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }

            // Move to the next line for the next row
            System.out.println();
        }

        // Close the scanner
        scanner.close();
        System.exit(0);
    }
}
