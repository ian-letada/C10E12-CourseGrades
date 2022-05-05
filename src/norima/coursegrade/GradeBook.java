package norima.coursegrade;

import java.util.Scanner;

public class GradeBook {
    private final static int NUMBER_OF_STUDENTS = 2;
    private final static int NUMBER_OF_TESTS = 5;
    private static Scanner scan = new Scanner(System.in);
    private int[][] grades = new int[NUMBER_OF_STUDENTS + 1][NUMBER_OF_TESTS + 1];

    public void getGrades() {
        for (int studentCounter = 1; studentCounter < NUMBER_OF_STUDENTS + 1; studentCounter++) {
            for (int testCounter = 1; testCounter < NUMBER_OF_TESTS + 1; testCounter++) {
                System.out.format("[Student %s][Test %s] Grade: ", studentCounter, testCounter);
                grades[studentCounter][testCounter] = scan.nextInt();
            }
        }
    }

    public void showGrades() {
        String leftAlignFormat = "| %-13s | %-8s | %-6s |%n";
        System.out.format("+---------------+----------+--------+%n");
        System.out.format("| Student #     |  Test #  |  Grade |%n");
        System.out.format("+---------------+----------+--------+%n");

        for (int studentCounter = 1; studentCounter < NUMBER_OF_STUDENTS + 1; studentCounter++) {
            for (int testCounter = 1; testCounter < NUMBER_OF_TESTS + 1; testCounter++) {
                System.out.format(leftAlignFormat, studentCounter, testCounter,
                        grades[studentCounter][testCounter]);
            }
            System.out.format("+---------------+----------+--------+%n");
        }

    }

    public void studentAvg(int studentNumber) {
        int average = 0;
        try {
            for (int i = 1; i < grades[studentNumber].length; i++) {
                average += grades[studentNumber][i];
            }
            average = average / NUMBER_OF_TESTS;

            System.out.format("Student #%s has an average of %s across all tests.%n%n", studentNumber, average);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Student not found.");
        }
    }

    public void testAvg(int testNumber) {
        if (testNumber > NUMBER_OF_TESTS) {
            System.out.println("Test not found.");
            return;
        }

        int average = 0;
        for (int studentCounter = 1; studentCounter < NUMBER_OF_STUDENTS + 1; studentCounter++) {
            for (int testCounter = 1; testCounter < NUMBER_OF_TESTS + 1; testCounter++) {
                if (testCounter == testNumber) {
                    average += grades[studentCounter][testCounter];
                }
            }
        }

        average = average / NUMBER_OF_STUDENTS;

        System.out.format("Test #%s has an average of %s across all students.%n%n", testNumber, average);
    }
}
