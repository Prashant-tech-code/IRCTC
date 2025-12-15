package Selenium_day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class hoverday6 {
	
	public static WebElement wait(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static void hover(WebDriver driver, WebElement element) {
		Actions action= new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		By Locator= By.xpath("//span[@class='nav-line-2 ']");
		WebElement hover = wait(driver, Locator);
		hover(driver, hover);
		driver.quit();
	}

}
