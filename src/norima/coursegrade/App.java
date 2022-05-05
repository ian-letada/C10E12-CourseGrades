package norima.coursegrade;

import java.util.Scanner;

public class App {
    public static class UserInput {
        private static Scanner input = new Scanner(System.in);

        public static int askForNumber(int lowerLimit, int upperLimit, String question) {
            int userSelection;

            while (true) {
                System.out.print(question + ": ");
                try {
                    userSelection = Integer.parseInt(input.nextLine());
                    if (userSelection > upperLimit || userSelection < lowerLimit) {
                        System.out.println("Your input is invalid. Please try again.");
                        continue;
                    }
                } catch (Exception e) {
                    System.out.println("Your choice is invalid. Please try again.");
                    continue;
                }
                return userSelection;
            }
        }

        public static int askForNumber(String question) {
            while (true) {
                System.out.print(question + ": ");
                try {
                    int userSelection = Integer.parseInt(input.nextLine());
                    if (userSelection >= 1) {
                        return userSelection;
                    } else {
                        System.out.println("Please enter a positive number. Try again.");
                    }

                } catch (Exception e) {
                    System.out.println("Your input is invalid. Please try again.");
                }
            }
        }

        public static Boolean askForConfirmation(String question) {
            String userSelection;
            while (true) {
                System.out.print(question + ": ");
                userSelection = input.nextLine();
                if (userSelection.equalsIgnoreCase("y")) {
                    return true;
                } else if (userSelection.equalsIgnoreCase("n")) {
                    return false;
                } else {
                    System.out.println("Invalid answer. Please try again.");
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        GradeBook gradeBook = new GradeBook();

        System.out.println("Welcome to the Grade Book!");

        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("[1] Input the grades for all the tests per student");
            System.out.println("[2] Show saved grades");
            System.out.println("[3] Get a student's average");
            System.out.println("[4] Get a test's average");
            System.out.println("[0] Quit");

            int choice = UserInput.askForNumber(0, 4, "Your choice");

            switch (choice) {
                case 0: {
                    System.exit(0);
                }
                case 1: {
                    gradeBook.getGrades();
                    break;
                }
                case 2: {
                    gradeBook.showGrades();
                    break;
                }
                case 3: {
                    int studentNumber = UserInput.askForNumber("Student number");
                    gradeBook.studentAvg(studentNumber);
                    break;
                }
                case 4: {
                    int testNumber = UserInput.askForNumber("Test number");
                    gradeBook.testAvg(testNumber);
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }
}
