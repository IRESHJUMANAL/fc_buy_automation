package testing_all_links_in_homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenCartPageWithClick {

	public static void main(String[] args) throws InterruptedException {
		// open chrome browser. 
				WebDriver driver = new ChromeDriver();
				
				//go to the website. 
				driver.get("http://localhost:5173/login");
				
				String actual_title = driver.getTitle();
				System.out.println(actual_title);
				
				// login code.
				
				
// first find the cart icon / link to click . 
				WebElement cart_icon = driver.findElement(By.xpath("//a[@class='relative']"));
				
				cart_icon.click();
				
				String cart_page_title = driver.getTitle();
				System.out.println(cart_page_title);
				
				Thread.sleep(3000);
				driver.quit();

	}

}
