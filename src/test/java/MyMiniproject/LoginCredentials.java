package MyMiniproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
public class LoginCredentials {
	public static void LoginData(WebDriver driver) throws IOException
	{

            // Specify the path to your Excel file
            String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\MyMiniproject\\UserData.xlsx";
 
            // Create a FileInputStream to read the Excel file
            FileInputStream fis = new FileInputStream(new File(filePath));
 
            // Create a Workbook instance for .xlsx file
            Workbook workbook = new XSSFWorkbook(fis);
 
            // Get the first sheet
            Sheet sheet = workbook.getSheetAt(0);
 
            // Get the row containing user id and password (assuming they are in the first row)
            Row row = sheet.getRow(1);
 
            // Get user id and password from the cells (assuming they are in the first and second columns)
            String userId = row.getCell(0).getStringCellValue();
            String password = row.getCell(1).getStringCellValue();
            
 
            // Close the workbook and file stream
            workbook.close();
            fis.close();
 
            // Now you have userId and password, you can use them in your Selenium code or any other logic
        
        // Method is used to find the email element 
		WebElement mail=driver.findElement(By.name("email"));
		
		mail.sendKeys(userId);     // Taking unregister email id from Excel Sheet 
		
		System.out.println("Entered Email ID is : jobspar2@gmail.com"); // printing the Entered email id
		
		// Method is used to find the password 
		WebElement pass= driver.findElement(By.name("password"));
		
		pass.sendKeys(password);    // Taking password from excel sheet 
		
		System.out.println("Entered Password : abc258"); 
		
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click(); //login button after submit all the details 	
		
	}
 
}
