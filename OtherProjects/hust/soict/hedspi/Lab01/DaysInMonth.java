package OtherProjects.hust.soict.hedspi.Lab01;

import java.util.Scanner;

public class DaysInMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days;
        String month, year;

        do {
            System.out.print("Enter the month (full name, abbreviation, 3 letters, or number): ");
            month = scanner.nextLine().toLowerCase();
        } while (!isValidMonth(month));

        do {
            System.out.print("Enter the year (non-negative, all digits): ");
            year = scanner.nextLine();
        } while (!isValidYear(year));

        int monthNumber = getMonthNumber(month);
        days = getDaysInMonth(monthNumber, Integer.parseInt(year));

        System.out.println("Number of days in " + month + " " + year + " is: " + days);

        scanner.close();
    }

    // Check if the input is a valid month
    public static boolean isValidMonth(String month) {
        String[] validMonths = {"january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december",
                "jan.", "feb.", "mar.", "apr.", "may.", "jun.", "jul.", "aug.", "sep.", "oct.", "nov.", "dec.",
                "jan", "feb", "mar", "apr", "jun", "jul", "aug", "sep", "oct", "nov", "dec",
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};

        for (String validMonth : validMonths) {
            if (validMonth.equals(month)) {
                return true;
            }
        }

        System.out.println("Invalid month. Please enter a valid month.");
        return false;
    }

    // Check if the input is a valid year
    public static boolean isValidYear(String year) {
        try {
            int yearInt = Integer.parseInt(year);
            if (yearInt >= 0 && year.length() == 4) {
                return true;
            }
        } catch (NumberFormatException e) {
            // Ignored, will be caught in the next block
        }
        System.out.println("Invalid year. Please enter a non-negative number with 4 digits.");
        return false;
    }

    // Get the numerical representation of a month
    public static int getMonthNumber(String month) {
        return switch (month) {
            case "january", "jan.", "jan" -> 1;
            case "february", "feb.", "feb" -> 2;
            case "march", "mar." -> 3;
            case "april", "apr." -> 4;
            case "may", "may." -> 5;
            case "june", "jun." -> 6;
            case "july", "jul." -> 7;
            case "august", "aug." -> 8;
            case "september", "sep." -> 9;
            case "october", "oct." -> 10;
            case "november", "nov." -> 11;
            case "december", "dec." -> 12;
            default -> Integer.parseInt(month);
        };
    }

    // Get the number of days in a month
    public static int getDaysInMonth(int month, int year) {
        return switch (month) {
            case 4, 6, 9, 11 -> 30;
            case 2 -> isLeapYear(year) ? 29 : 28;
            default -> 31;
        };
    }

    // Check if a year is a leap year
    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else return year % 400 == 0;
    }
}
