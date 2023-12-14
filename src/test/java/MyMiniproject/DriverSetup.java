package MyMiniproject;
 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
 
public class DriverSetup {
    private static WebDriver driver;
 
    //Method is used to take browser Type according to the User requirement
    
    public static WebDriver getDriver(String browserType) {
    	
        if (browserType.equalsIgnoreCase("chrome")) {    // Checking for Chrome Browser 
          
            driver = new ChromeDriver();
        } 
        
        else if (browserType.equalsIgnoreCase("edge")) {     // Checking for Edge browser 
           
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser type: " + browserType); // if no browser match then throw exception 
        }
 
        driver.get("https://change2naturalfoods.com/");  // Actual URL of the website 
        
        driver.manage().window().maximize();            // Used to maximize the window 
        return driver;
    }
    public static void browserClose() // Method is use to close the Running browser
    {
    	driver.quit();                // we call quit method to close the running browser
    }
}