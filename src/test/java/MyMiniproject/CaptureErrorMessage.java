package MyMiniproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class CaptureErrorMessage {

    // Verify error message is displayed for an unregistered user
    public static void getErrorMessage(WebDriver driver) {
        try {
            // Finding the Error message
            WebElement error_message = driver.findElement(By.xpath("//div[@role='alert']"));

            String error = error_message.getText(); // Get an error message for an unregistered email id

            System.out.println("Error message: " + error); // Printing the error message in the console

            // Capture screenshot if error message is present
            if (!error.isEmpty()) {
                captureScreenshot(driver);
            }
        } catch (Exception e) {
            System.out.println("Error: Unable to find the error message element.");
            e.printStackTrace();
        }
    }

    // Capture screenshot and save it to the specified location
    private static void captureScreenshot(WebDriver driver) {
        try {
            // Convert WebDriver object to TakeScreenshot
            TakesScreenshot screenshot = (TakesScreenshot) driver;

            // Capture screenshot as File
            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

            // Specify the location to save the screenshot
            String screenshotPath = "C:\\Users\\Pushkar Mishra\\eclipse-workspace\\SeleniumMiniproject\\Screenshot\\errorScreenshot.png";

            // Copy the screenshot to the specified location
            FileUtils.copyFile(sourceFile, new File(screenshotPath));

            System.out.println("Screenshot captured and saved ");
        } catch (IOException e) {
            System.out.println("Error: Unable to capture screenshot.");
            e.printStackTrace();
        }
    }
}
