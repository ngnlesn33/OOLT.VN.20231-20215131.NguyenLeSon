package OtherProjects.hust.soict.hedspi.Lab01;

import java.util.Scanner;

public class EquationSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose the type of equation to solve:");
        System.out.println("1. First-degree equation with one variable");
        System.out.println("2. First-degree equations with two variables");
        System.out.println("3. The second degree equation with one variable");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                solveFirstDegreeEquation(scanner);
                break;
            case 2:
                solveSystemOfEquations(scanner);
                break;
            case 3:
                solveSecondDegreeEquation(scanner);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void solveFirstDegreeEquation(Scanner scanner) {
        System.out.println("Given an equation as 'ax + b = 0'");
        System.out.println("Enter coefficient a: ");
        double a = scanner.nextDouble();
        System.out.println("Enter coefficient b: ");
        double b = scanner.nextDouble();

        if (a == 0) {
            if (b == 0) {
                System.out.println("The equation has infinitely many solutions.");
            } else {
                System.out.println("The equation has no solutions.");
            }
        } else {
            double x = -b / a;
            System.out.printf("The solution is: x = %.2f\n", x);
        }
    }

    private static void solveSystemOfEquations(Scanner scanner) {
        System.out.println("Given a system of two equations as 'a1x + b1y = c1' and 'a2x + b2y = c2', please enter the values of a1, b1, c1, a2, b2, and c2:");

        System.out.print("a1: ");
        double a1 = scanner.nextDouble();

        System.out.print("b1: ");
        double b1 = scanner.nextDouble();

        System.out.print("c1: ");
        double c1 = scanner.nextDouble();

        System.out.print("a2: ");
        double a2 = scanner.nextDouble();

        System.out.print("b2: ");
        double b2 = scanner.nextDouble();

        System.out.print("c2: ");
        double c2 = scanner.nextDouble();

        double[][] mat = {{a1, b1, c1}, {a2, b2, c2}};
        double det = mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0];
        if (det != 0) {
            double Dx = mat[0][2] * mat[1][1] - mat[1][2] * mat[0][1];
            double x = Dx / det;
            double Dy = mat[0][0] * mat[1][2] - mat[1][0] * mat[0][2];
            double y = Dy / det;

            System.out.println("The solution is: x = " + x + " y= " + y);
        } else {
            // No unique solution
            System.out.println("The system has no unique solution.");
        }
    }

    private static void solveSecondDegreeEquation(Scanner scanner) {
        System.out.println("Given a second degree equation as 'ax^2 + bx = c' please enter the values of a, b and c:");

        System.out.print("a: ");
        double a = scanner.nextDouble();

        System.out.print("b: ");
        double b = scanner.nextDouble();

        System.out.print("c: ");
        double c = scanner.nextDouble();

        if (a != 0) {
            // Calculate the discriminant
            double dis = b * b - 4 * a * c;
            if (dis > 0) {
                double x1 = (-b + Math.sqrt(dis)) / (2 * a);
                double x2 = (-b - Math.sqrt(dis)) / (2 * a);
                System.out.printf("The solution is: x1 = %.2f, x2 = %.2f\n", x1, x2);
            } else if (dis == 0) {
                double x = -b / (2 * a);
                System.out.printf("The solution is: x = %.2f\n", x);
            } else {
                System.out.println("The equation has no solution.");
            }
        }
    }
}

