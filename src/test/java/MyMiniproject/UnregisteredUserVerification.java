package MyMiniproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
public class UnregisteredUserVerification {
 
    static WebDriver driver;
	public static String browserType;
 
	// Method is used to create Driver  by calling DriverSetup class 
    public static WebDriver createDriver(String browserType) {
        driver = DriverSetup.getDriver(browserType);
        return driver;
    }
 
    public static void getLocator(WebDriver driver)
    {
    	//This method is used to Locate  the Login/Register Button 
    	
        WebElement login_Button = driver.findElement(By.xpath("//a[@class='nav-link -before']"));
        login_Button.click();
    }
}
