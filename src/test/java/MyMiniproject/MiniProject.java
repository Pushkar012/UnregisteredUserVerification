package MyMiniproject;

import java.util.Scanner;

public class MiniProject {
 
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
 
        System.out.println("Enter browser type (chrome or edge): "); //Enter the Browser Type 
        
        String browserType = scanner.nextLine().toLowerCase();
 
        // Validate the input if needed
 
        UnregisteredUserVerification.driver = UnregisteredUserVerification.createDriver(browserType);
        
        UnregisteredUserVerification.getLocator(UnregisteredUserVerification.driver); // Locator method called to locate Login/register button
        
        LoginCredentials.LoginData(UnregisteredUserVerification.driver); // calling Login Methods and take input from Excel file as userID and password 
        
        CaptureErrorMessage.getErrorMessage(UnregisteredUserVerification.driver); // calling capture error method
        
        DriverSetup.browserClose();			// Calling the browser close method
 
        scanner.close();
    }
}