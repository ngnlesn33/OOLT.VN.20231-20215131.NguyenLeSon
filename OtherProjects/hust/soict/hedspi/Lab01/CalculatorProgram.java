package OtherProjects.hust.soict.hedspi.Lab01;

import java.util.Scanner;

public class CalculatorProgram {
    public static void main(String[] args) {
        //  Create a scanner object that reads from console
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the first number: ");
        double a = scanner.nextDouble();
        System.out.println("Please input the second number: ");
        double b = scanner.nextDouble();

        double sum = a + b;
        double difference = a - b;
        double product = a * b;
        double quotient;

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        if (b != 0) {
            quotient = a / b;
            System.out.println("Quotient: " + quotient);
        } else System.out.println("Error: Division by zero is not allowed.");

        System.exit(0);
    }
}
