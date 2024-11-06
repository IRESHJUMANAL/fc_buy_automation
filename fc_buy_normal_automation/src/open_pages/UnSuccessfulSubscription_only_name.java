package open_pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class UnSuccessfulSubscription_only_name {

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		
		String rootfolder = System.getProperty("user.dir");
        System.out.println("the root project folder is \n" + rootfolder);
        String screeshot_folder = rootfolder+"\\"+"failed_screeshots";
        
        System.out.println(screeshot_folder);
        
		// open chrome browser. 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		//go to the website. 
		driver.get("http://localhost:5173/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				String actual_title = driver.getTitle();
				System.out.println(actual_title);
				
				String expected_title = "FcBuy - Homepage";
				
				if(!actual_title .equals(expected_title))
				{
					System.out.println("Test case failed, homepage not loading");
				}
				else
				{
					// enter the email. in subscription field.
					System.out.println("homepage successfully displayed");
					
					JavascriptExecutor js = (JavascriptExecutor) driver;   //  class type casting. 
//					js.executeScript("window.scrollBy(0, 1500)");
//					js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
					WebElement subscription_field_location = 	driver.findElement(By.xpath("//input[@id='email-address']"));
					
					js.executeScript("arguments[0].scrollIntoView(true);" , subscription_field_location);
					
					Thread.sleep(3000);
					
					// xpath for subscrition field. 
				WebElement subscription_field = 	driver.findElement(By.xpath("//input[@id='email-address']"));
				subscription_field.sendKeys("raju");
				Thread.sleep(500);
				
				// click on the subscribe button 
				WebElement subscription_button = 	driver.findElement(By.xpath("//button[@type='submit']"));
				subscription_button.click(); 
					
				// find the success message 
				String expected_result_text = "@ is required message should display";
				TakesScreenshot ts = (TakesScreenshot)driver;
				File ramlocation = ts.getScreenshotAs(OutputType.FILE);
				Date d = new Date();
				System.out.println(d);
			     String d1 = d.toString();
			     String date = d1.replaceAll(":", "_");
				File hdlocation = new File(screeshot_folder+"_"+date+".jpg");
				Files.copy(ramlocation, hdlocation);

				}				
				Thread.sleep(3000);
				driver.quit();
	}
}