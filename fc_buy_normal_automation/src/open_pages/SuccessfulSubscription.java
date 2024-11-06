package open_pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SuccessfulSubscription {

	public static void main(String[] args) throws InterruptedException 
	{
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
				subscription_field.sendKeys("raju@gmail.com");
				Thread.sleep(500);
				
				// click on the subscribe button 
				WebElement subscription_button = 	driver.findElement(By.xpath("//button[@type='submit']"));
				subscription_button.click(); 
					
				// find the success message 
				String expected_result_text = "Subscription successful!";
				
				//p[@class='mt-4 text-sm text-green-500']
				
				WebElement actual_result_text = 	driver.findElement(By.xpath("//p[@class='mt-4 text-sm text-green-500']"));
				String actual_text = actual_result_text.getText();
				System.out.println(actual_text);
				
				if(expected_result_text.equals(actual_text))
				{
					System.out.println("Test case passed");
				}
				else
				{
					System.out.println("Test case failed");
				}
				}
				
				Thread.sleep(3000);
				driver.quit();

	}

}
