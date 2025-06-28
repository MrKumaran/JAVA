package Learning;

import java.util.Scanner;

public class DateManipulation {

    /**
     * Check if a year is a leap year
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    /**
     * Get the number of days in a given month and year
     */
    public static int getDaysInMonth(int month, int year) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return daysInMonth[month - 1];
    }

    /**
     * Add N days to a date in DD-MM-YYYY format
     */
    public static String addDaysToDate(String dateStr, int n) {
        // Parse the input date
        String[] parts = dateStr.split("-");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        // Add days
        while (n > 0) {
            int daysInCurrentMonth = getDaysInMonth(month, year);
            int daysRemainingInMonth = daysInCurrentMonth - day;

            if (n <= daysRemainingInMonth) {
                // We can add all remaining days within the current month
                day += n;
                n = 0;
            } else {
                // Move to the next month
                n -= (daysRemainingInMonth + 1);
                day = 1;
                month++;
                if (month > 12) {
                    month = 1;
                    year++;
                }
            }
        }

        // Subtract days
        while (n < 0) {
            if (Math.abs(n) < day) {
                // We can subtract within the current month
                day += n; // n is negative, so this subtracts
                n = 0;
            } else {
                // Move to the previous month
                n += day;
                month--;
                if (month < 1) {
                    month = 12;
                    year--;
                }
                day = getDaysInMonth(month, year);
            }
        }

        // Format the result with leading zeros
        return String.format("%02d-%02d-%04d", day, month, year);
    }

    /**
     * Alternative method using day-of-year calculation for better performance
     */
    public static String addDaysToDateOptimized(String dateStr, int n) {
        String[] parts = dateStr.split("-");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        // Convert date to day number within the year
        int dayOfYear = 0;
        for (int m = 1; m < month; m++) {
            dayOfYear += getDaysInMonth(m, year);
        }
        dayOfYear += day;

        // Add the days
        dayOfYear += n;

        // Adjust for year overflow/underflow
        while (dayOfYear > (isLeapYear(year) ? 366 : 365)) {
            dayOfYear -= (isLeapYear(year) ? 366 : 365);
            year++;
        }

        while (dayOfYear <= 0) {
            year--;
            dayOfYear += (isLeapYear(year) ? 366 : 365);
        }

        // Convert back to day and month
        month = 1;
        while (dayOfYear > getDaysInMonth(month, year)) {
            dayOfYear -= getDaysInMonth(month, year);
            month++;
        }
        day = dayOfYear;

        return String.format("%02d-%02d-%04d", day, month, year);
    }

    
    public static boolean isValidDate(String dateStr) {
        try {
            String[] parts = dateStr.split("-");
            if (parts.length != 3) return false;

            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);

            if (month < 1 || month > 12) return false;
            if (day < 1 || day > getDaysInMonth(month, year)) return false;
            if (year < 1) return false;

            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            String input = scanner.nextLine().trim();
            System.out.print("Enter number of days to add (negative to subtract): ");
            int days = Integer.parseInt(scanner.nextLine().trim());
            String result = addDaysToDate(input, days);
            String resultOptimized = addDaysToDateOptimized(input, days);
            System.out.println("Result (Standard): " + result);
            System.out.println("Result (Optimized): " + resultOptimized);
            System.out.println();


        // Test the example
        System.out.println("\nTesting example:");
        System.out.println("Input: 31-12-2025, N = 3000");
        String exampleResult = addDaysToDate("31-12-2025", 3000);
        System.out.println("Output: " + exampleResult);

        // Additional test cases
        System.out.println("\nAdditional test cases:");
        System.out.println("29-02-2024 + 1 day = " + addDaysToDate("29-02-2024", 1));
        System.out.println("01-03-2024 - 1 day = " + addDaysToDate("01-03-2024", -1));
        System.out.println("31-12-2023 + 1 day = " + addDaysToDate("31-12-2023", 1));
        System.out.println("01-01-2024 - 1 day = " + addDaysToDate("01-01-2024", -1));

        scanner.close();
    }
}