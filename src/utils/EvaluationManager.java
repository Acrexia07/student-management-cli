package utils;

import model.Student;
import operations.StudentManager;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class EvaluationManager {

    // Initialization: Variable, Object and ArrayList Declaration
    private static final ScannerManager scannerManager = ScannerManager.getScannerInstance();
    private static final ArrayList<Student> listOfStudents = new ArrayList<>();
    static Student newStudent;

    // Method: User choice - Student Menu
    public static void evaluateChoiceStudentMenu (char userChoice) {

        // Process (Switch case evaluation): Checks if user inputs valid options
        switch (userChoice) {
            case 'A' -> {

                // Initialization: Display Header
                System.out.println("----- Menu: Add Student -----");

                // Process: Add Student
                newStudent = StudentManager.addStudent();

                // Process (Exception): Ensures inputs are handled well
                try {

                    // Process: Add the newStudent to the ArrayList
                    listOfStudents.add(newStudent);
                    System.out.println("New Student information acquired!");

                } catch (NullPointerException e) {
                    System.out.println("New student's information is null!");
                }

                // Process: Return value to the loop: TRUE
                evaluateChoiceProgramContinuation();
            }
            case 'B' -> {

                // Initialization: Display Header
                System.out.println("*-----* Menu: View Searched Student *-----*");

                // Process: Search Student Name and display his/her information
                StudentManager.searchStudentName(listOfStudents);

                // Process: Return value to the loop: TRUE
                evaluateChoiceProgramContinuation();
            }
            case 'C' -> {

                // Initialization: Display Header
                System.out.println(" *-----* Menu: View all Student *-----*");

                // Output: Display all student information - Formatted by toString abstract method
                String formatted = listOfStudents.stream()
                                                 .map(Student::toString)
                                                 .collect(Collectors.joining("\n"));
                System.out.println(formatted);

                // Process: Return value to the loop: TRUE
                evaluateChoiceProgramContinuation();
            }
            case 'D' -> {

                // Initialization: Display Header
                System.out.println("*-----* Menu: Sort Student by average grade *-----*");

                // Process: Sort List of students by average Grade
                StudentManager.sortStudentByAverage(listOfStudents);

                // Process: Return value to the loop: TRUE
                evaluateChoiceProgramContinuation();
            }
            case 'E' -> {
                System.out.println("Exiting program...");
                System.exit(0);
            } // Output: Display Exit Message
            default -> System.out.println("Invalid input: Enter correct options! Please try again.");
        }
    }

    // Method: User choice - Program Continuation
    public static void evaluateChoiceProgramContinuation () {

        // Initialization: Variable Declaration
        String userResponse;

        // Process (Loop): Perform loop until user inputs correct and valid option
        while (true) {

            // Input (User input): Enter choice input automatically in uppercases
            System.out.print("\nDo you wish to continue? (Yes or No): ");
            userResponse = scannerManager.getScanner().nextLine().trim().toUpperCase();

            // Process (Validation): Ensures user input is not empty
            switch (userResponse) {
                case "" -> System.out.println("Input must not be empty!");
                case "YES" -> {
                    // Output: Add spaces for better readability
                    System.out.println();
                    return;
                }
                case "NO" -> {
                    // Output: Prints Exit message
                    System.out.println("Exiting program...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid input: Enter correct option (Yes or No)! Please try again.");
            }
        }
    }
}

