package utils;

@SuppressWarnings("ALL")
public class MenuOptionsManager {

    // Initialization: Array and Object Declaration
    private static final ScannerManager scannerManager = ScannerManager.getScannerInstance();
    public static String[] menuOptions = {"A. Add Student",
                                          "B. View Searched student",
                                          "C. View all Students",
                                          "D. Sort Students by average grade",
                                          "E. Exit"};

    // Method: Display Welcome Message
    public static void displayMenu () {

        // Operation: Display and User input - Menu Choice
        evaluateUserChoiceMenu();
    }

    // Method: Display Menu Options
    protected static void loopMenuOptions (String ... menuOptions) {

        // Process: Loop all menuOption elements
        for (String choice: menuOptions) {
            System.out.println(choice);
        }
    }

    // Method: Evaluate User choice - Student Menu
    protected static void evaluateUserChoiceMenu () {

        // Initialization: Variable Declaration
        String input;
        char userChoice;

        // Process (Loop): Ensure user input is correct.
        while (true) {

            // Initialization: Welcome Message
            System.out.println("*----* Menu Options *----*");

            // Initialization: Display Menu
            loopMenuOptions(menuOptions);

            // Input: User input - Choice
            System.out.print("Enter your options (A, B, C, D, or E): ");
            input = scannerManager.getScanner().nextLine().trim().toUpperCase();
            System.out.println();

            // Process (Validation): Ensures user input is not empty
            if (input.isEmpty()) {
                System.out.println("Input must not be empty!");
                continue;
            }
            else if (input.length() > 1 ) {
                System.out.println("Input length must be one character only!\n");
                continue;
            }

            // Method: Converts String input into char input
            userChoice = input.charAt(0);

            // Process: Update loop control based on return value
            EvaluationManager.evaluateChoiceStudentMenu(userChoice);
        }
    }
}
