package validation;

import utils.ScannerManager;
import java.util.Set;
import java.util.function.Predicate;

public class InputValidation {

    // Initialization: Object Declaration
    private static final ScannerManager scannerManager = ScannerManager.getScannerInstance();

    /* ----- Data type Validation ----- */

    // Method: User Input - String data type input validation
    public static boolean validateStringInput (String name, String regex, String errorMessage) {

        // Process: validate if user inputs are not empty and correct
        if (name == null || name.isEmpty()) {
            System.out.println("Input must not be empty!");
            return false;
        }
        else if (!name.matches(regex)) {
            System.out.println(errorMessage);
            return false;
        }
        return true;
    }

    // Method: User Input - Double data type input validation
    public static double validateDoubleInput (String prompt, Predicate<Double> validator, String errorMessage) {

        // Initialization: Variable Declaration
        String input;
        double doubleInput;

        // Process: Perform loop until user inputs correct and valid input
        while (true) {
            System.out.print(prompt);
            input = scannerManager.getScanner().nextLine().trim();

            // Process: Validate if user inputs empty field
            if (input.isEmpty()) {
                System.out.println("Input required!");
                continue;
            }

            // Process (try-catch): Handle exceptions properly when validating user input
            try {

                // Process: Converts String input into Double input
                doubleInput = Double.parseDouble(input);

                // Process: Handles validation in Predicate form
                if (validator.test(doubleInput)) {
                    break;
                }
                else {
                    System.out.printf("Invalid Input: %s! Please try again.\n", errorMessage);
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input: Please enter a valid number.");
            }
        }
        return doubleInput;
    }

    // Method: User input - Integer data type input validation
    public static int validateIntegerInput (String prompt, Predicate<Integer> validator, String errorMessage) {

        // Initialization: Variable Declaration
        String input;
        int integerInput;

        // Process: Perform loop until user input is not empty and valid
        while (true) {
            System.out.print(prompt);
            input = scannerManager.getScanner().nextLine().trim();

            // Process (validation): Check if user inputs empty
            if (input.isEmpty()) {
                System.out.println("Input must not be empty!");
                continue;
            }

            // Process (try-catch): Handle exceptions properly when validating user input
            try {
                // Process: Converts string input into integer input
                integerInput = Integer.parseInt(input);

                // Process (Validation): Validate user input using the condition defined by the Predicate parameter
                if (validator.test(integerInput)) {
                    break;
                }
                else {
                    System.out.printf("Invalid Input: %s\n Please try again.\n", errorMessage);
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input: Please enter a valid whole number.");
            }
        }
        return integerInput;
    }

    /* ----- Other validations ----- */

    // Method: User input - Gender validation
    public static String validateGenderInput () {

        // Initialization: Variable and Set Declaration
        Set<String> genderOptions = Set.of("MALE", "FEMALE", "OTHER", "OTHERS", "M", "F", "O");
        String genderInput;

        // Process: Perform loop until user input is not empty and valid
        while (true) {
            System.out.print("Enter your gender (M or Male, F or Female, O or Other/s): ");
            genderInput = scannerManager.getScanner().nextLine().trim().toUpperCase();

            // Process (validation): Check if user inputs empty
            if (genderInput.isEmpty()) {
                System.out.println("Input must not be empty! Please try again.");
            }
            else if (!genderOptions.contains(genderInput)) {
                System.out.println("Invalid input: Please enter a valid gender (M/Male, F/Female, O/Other(s))!");
            } else {
                break;
            }
        }
        return genderInput;
    }
}
