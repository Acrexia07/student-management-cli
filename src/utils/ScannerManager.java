package utils;

import java.util.Scanner;

public class ScannerManager {

    // Initialization: Attributes
    private static ScannerManager scannerInstance;
    private final Scanner scanner;

    // Definition: Constructor
    public ScannerManager () {
        this.scanner = new Scanner(System.in);
    }

    // Method: Getter - scannerInstance
    public static ScannerManager getScannerInstance () {
        if (scannerInstance == null) {
            scannerInstance = new ScannerManager();
        }
        return scannerInstance;
    }

    //Method: Getter - scanner
    public Scanner getScanner () {
        return this.scanner;
    }

    // Method: Close scanner
    public void closeScanner(){
        this.scanner.close();
    }
}
