package testng;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpsconsoleTestng {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;

	@BeforeMethod
	public void setup() {
		Map<String, Object> chromePrefs = new HashMap<>();
		chromePrefs.put("credentials_enable_service", false);
		chromePrefs.put("profile.password_manager_enabled", false);
		chromePrefs.put("profile.password_manager_leak_detection", false);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("");
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(webDriver -> js.executeScript("return document.readyState").equals("complete"));
	}

	@Test
	public void test() throws Exception {
		WebElement username = driver.findElement(By.xpath("(//input[@id='signInFormUsername'])[2]"));
		js.executeScript("arguments[0].click();", username);
		username.sendKeys("");
		WebElement password = driver.findElement(By.xpath("(//input[@id='signInFormPassword'])[2]"));
		js.executeScript("arguments[0].click();", password);
		password.sendKeys("");
		WebElement click = driver.findElement(By.xpath("(//input[@name='signInSubmitButton'])[2]"));
		js.executeScript("arguments[0].click();", click);
		wait.until(webDriver -> js.executeScript("return document.readyState").equals("complete"));
		WebElement serachbtn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='button is-primary']")));
		System.out.println("Search button status is: " + serachbtn.isEnabled());
		WebElement policyno = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#policy-no")));
		policyno.sendKeys("");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(
	            By.cssSelector("div.loading-background")));
		   
		serachbtn.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(
	            By.cssSelector("div.loading-background")));
		
		WebElement lb = wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector(".mdi.mdi-account-circle.mdi-36px")));
		lb.click();
		WebElement logout = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='profile-dropdown']")));
		logout.click();
	}
	@AfterMethod
	public void close() {
		driver.quit();
	}
}
