package handler;

import utils.ScannerManager;
import validation.InputValidation;

public class UserInputHandler {

    // Initialization: Scanner Object Declaration
    private static final ScannerManager scannerManager = ScannerManager.getScannerInstance();

    // Method: Process user input in loops
    public static String operateUserInput (String prompt, String regex, String errorMessage) {

        // Initialization: Variable Declaration
        String input;

        // Process (do-while loop): Perform loops until name input is not empty and valid
        do {
            System.out.print(prompt);
            input = scannerManager.getScanner().nextLine();
        }
        while (!InputValidation.validateStringInput(input, regex, errorMessage));
        return input;
    }
}
