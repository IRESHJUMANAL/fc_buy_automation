package open_pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenRegisterPage {

	public static void main(String[] args) throws InterruptedException {
		// open chrome browser. 
				WebDriver driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				//go to the website. 
				driver.get("http://localhost:5173/register");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				String actual_title = driver.getTitle();
				System.out.println(actual_title);
				
				String expected_title = "FcBuy - Register";
				
				if(actual_title.equals(expected_title))
				{
					System.out.println("Test case passed");
				}
				else
				{
					System.out.println("test case failed");
				}
				
				Thread.sleep(3000);
				
				driver.quit();

	}

}
