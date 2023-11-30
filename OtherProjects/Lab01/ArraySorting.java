package OtherProjects.Lab01;

import java.util.Arrays;
import java.util.Scanner;

public class ArraySorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for the array
        System.out.print("Enter the length of the array: ");
        int length = scanner.nextInt();

        // Create an array with the specified length
        int[] arr = new int[length];

        System.out.println("Enter the elements of the array:");

        for (int i = 0; i < length; i++) {
            arr[i] = scanner.nextInt();
        }

        // Sort the array
        Arrays.sort(arr);

        // Calculate sum and average
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        double average = (double) sum / length;

        // Display sorted array, sum, and average
        System.out.println("Sorted Array: " + Arrays.toString(arr));
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);

        scanner.close();
        System.exit(0);
    }
}
