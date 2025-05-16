package operations;

import handler.UserInputHandler;
import model.Student;
import utils.ScannerManager;
import validation.InputValidation;

import java.util.*;

public class StudentManager {

    // Initialization: Scanner Object Initialization
    private static final ScannerManager scannerManager = ScannerManager.getScannerInstance();

    //Method: Add Student
    public static Student addStudent () {

        // Initialization: Variable Declaration
        String studentName;
        String studentGender;
        double studentGrade;
        double averageGrade;
        int studentAge;
        int numberOfGrades;

        // Process: User input - Student Name
        studentName = UserInputHandler.operateUserInput(
                               "Enter Student Name: ",
                                "^[A-Z][a-z]+(?: [A-Z][a-z]+)*$",
                          "Invalid Format: Name input must be correct format (e.g. Firstname LastName)");

        // Process: User input - Student Age
        studentAge = InputValidation.validateIntegerInput(
                              "Enter Student Age: ",
                              validateAge -> validateAge >= 5 && validateAge <= 100,
                         "Enter valid Student Age (5 to 100)!");

        // Process: User input - Student Gender
        studentGender = InputValidation.validateGenderInput();

        // Process: User input - Number of Grades
        numberOfGrades = InputValidation.validateIntegerInput(
                                  "Enter how many grades: ",
                                  gradeQuantity -> gradeQuantity > 0,
                             "Enter positive numbers only!");

        // Initialization: list of grades
        List<Double> listOfGrades = new ArrayList<>();

        // Process (Loop): Performs loop of storing grades based on user input (numberOfGrades)
        for (int i = 1; i <= numberOfGrades; i++ ) {

            // Initialization: Generate String prompt
            String promptGradeInput = String.format("Enter Grade#%d: ", i);

            // Process (Validation): Ensures student grade input is valid and correct
            studentGrade = InputValidation.validateDoubleInput(
                                           promptGradeInput,
                                    inputGrade -> inputGrade >= 75 && inputGrade <= 100,
                               "Invalid input: Only grades from 75% to 100% are accepted for K–12.");

            // Process: Pass all the values inside ArrayList (listOfGrades)
            listOfGrades.add(studentGrade);
        }

        // Process: Add all grades stored in listOfGrades via JavaStream
        double sumOfGrades = listOfGrades.stream()
                                         .mapToDouble(Double::doubleValue)
                                         .sum();

        // Process: Get the Average Grade
        averageGrade = sumOfGrades / listOfGrades.size();

        // Process: Return values to student class
        return new Student(studentName, studentAge, studentGender, listOfGrades, averageGrade);
    }

    // Method: Search Student Name
    public static void searchStudentName (ArrayList<Student> listOfStudents) {

        // Initialization: Variable Declaration
        String studentName;

        // Process (Loop): Perform looping until user inputs are valid and correct
        while (true) {
            System.out.print("Search Student Name: ");
            studentName = scannerManager.getScanner().nextLine();

            // Process (Validation): Ensure user input is not empty
            if (studentName.isEmpty()) {
                System.out.println("Input must not be empty! Please try again.");
                continue;
            }

            // Initialization: Stream Variable Declaration
            String searchName = studentName;

            // Process: Search name and display searched name information with validations via Java Streams
            listOfStudents.stream()
                          .filter(student -> student.getName().equalsIgnoreCase(searchName))
                          .findFirst()
                          .ifPresentOrElse(Student::displayPersonalInformation,
                                          () -> System.out.println("Student not found!"));
            break;
        }
    }

    // Method: Sort Student by Average Grade
    public static void sortStudentByAverage (ArrayList<Student> listOfStudents) {

        // Initialization: Variable Declaration
        String userResponse;

        // Process (Loop): Perform loop until user inputs are valid and correct
        while (true) {
            System.out.print("Sort - (A/Ascending or D/Descending): ");
            userResponse = scannerManager.getScanner().nextLine().toLowerCase();

            if (userResponse.isEmpty()){
                System.out.println("Input must not be empty!");
            }

            // Process (Validation): Check if user inputs are correct
            if (userResponse.equals("ascending") || userResponse.equals("a")) {

                // Process (Sort): Sort ArrayList elements in Ascending Order
                sortArrayList("\n****** Students List (Sort: Ascending Order) ******",
                             listOfStudents,
                             "Sorting in Ascending order...",
                             Comparator.comparing(Student::getAverageGrade));
                break;
            }
            else if (userResponse.equals("descending") || userResponse.equals("d")){

                // Process (Sort): Sort ArrayList elements in Descending Order
                sortArrayList("\n****** Students List (Sort: Descending Order) ******",
                             listOfStudents,
                             "Sorting in Descending order...",
                              Comparator.comparing(Student::getAverageGrade).reversed());
                break;
            }
            else {
                System.out.println("Invalid input: Enter correct options! Please try again.");
            }
        }
    }

    // Method: ArrayList - Sort
    protected static void sortArrayList(String headerSort,
                                        ArrayList<Student> listOfStudents,
                                        String message,
                                        Comparator<Student> comparator) {

        // Process: Display process message
        System.out.println("\n" + message);

        // Output: If the array list is empty, print an output
        if (listOfStudents.isEmpty()) {
            System.out.println("[No Student/s listed]");
        }
        else {
            // Output: Display Sorted Student name with his/her average grade
            System.out.println(headerSort);
            listOfStudents.sort(comparator);

            // Output (loop): Print all elements stored in ArrayList (listOfStudents)
            for (Student student : listOfStudents) {
                System.out.printf("Name: %s | Average Grade: %.2f%%\n", student.getName(), student.getAverageGrade());
            }
        }
    }
}
