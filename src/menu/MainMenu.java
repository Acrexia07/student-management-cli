package menu;

import utils.MenuOptionsManager;
import utils.ScannerManager;

public class MainMenu {
    public static void main(String[] args) {

        // Initialization: Scanner Declaration
        ScannerManager scannerManager = ScannerManager.getScannerInstance();

        // Initialization: Display Welcome Menu
        MenuOptionsManager.displayMenu();

        // Exit: Close Scanner Object
        scannerManager.closeScanner();
    }
}
