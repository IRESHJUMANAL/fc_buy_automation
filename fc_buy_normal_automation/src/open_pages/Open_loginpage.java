package open_pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Open_loginpage {

	public static void main(String[] args) throws InterruptedException
	{
		// open chrome browser. 
		WebDriver driver = new ChromeDriver();
		
		//go to the website. 
		driver.get("http://localhost:5173/login");
		
		String actual_title = driver.getTitle();
		System.out.println(actual_title);
		
		String expected_title = "FcBuy - Login";
		
		if(actual_title .equals(expected_title))
		{
			System.out.println("Test case passed");
		}
		else
		{
			System.out.println("Test case failed");
		}
		
		Thread.sleep(3000);
		driver.quit();
		

	}
}