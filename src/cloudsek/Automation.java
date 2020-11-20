package cloudsek;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Automation {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AP\\Downloads\\chromedriver_win32\\chromedriver.exe");
		// This line is to open a new instance of chrome driver
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		//opening webpage
		driver.get("https://www.amazon.in/");
		Thread.sleep(2000);
		
		//selecting books from categories
		driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]/option[11]")).click();
		
		//Entering the book details and searching for it
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Digital fortress by dan brown");
		driver.findElement(By.xpath("//*[@id=\"nav-search-submit-text\"]/input")).click();
		Thread.sleep(1000);
		
		//Sorting by Average Customer Reviews
		driver.findElement(By.xpath("//span[contains(@class, 'a-dropdown-label') and text()='Sort by:']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"s-result-sort-select_3\"]")).click();
		Thread.sleep(2000);
		
		//Selecting the book at top
		driver.findElement(By.linkText("The Da Vinci Code: (Robert Langdon Book 2)")).click();
		Thread.sleep(2000);
		
		//Giving control to new tab
		ArrayList<String> windowHandles = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(1));
		
		//Selecting two quantities of book in cart
		driver.findElement(By.xpath("//*[@id=\"quantity\"]/option[2]")).click();
		Thread.sleep(2000);
		
		//Adding to cart
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
		Thread.sleep(1000);
		
		//Proceeding to buy
		driver.findElement(By.id("hlb-ptc-btn-native")).click();
		
	}

}
