package Selenium_day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.swing.Action;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IRCTC {

	public static void main(String[] args) throws InterruptedException, Exception {
		// Disable browser notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		WebElement select;
		List<WebElement> list;
		driver.get("https://www.irctc.co.in/nget/train-search");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// ---Click on search & enter value into from---//
		WebElement okbtn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
		okbtn.click();
		WebElement srcbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//input[@aria-label='Enter From station. Input is Mandatory.']")));
		srcbtn.click();
		srcbtn.sendKeys("Bandra");
		list = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']//li")));
		select = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(.,'BANDRA TERMINUS - BDTS')]")));
		select.click();
		// ---Click on search & enter value into TO---//
		WebElement tobtn = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@aria-label='Enter To station. Input is Mandatory.']")));
		tobtn.click();
		tobtn.sendKeys("jaipu");
		list = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']//li")));
		select = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(.,'JAIPUR JN - JP')]")));
		select.click();
		// ----------- Select Dropdown --------------//
		WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector(".ng-tns-c76-11.ui-dropdown.ui-widget.ui-state-default.ui-corner-all")));
		dropdown.click();
		list = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']//li")));
		select = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(.,'PREMIUM TATKAL')]")));
		select.click();
		// -----------Click on Search Button--------------//
		WebElement Search = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
		Search.click();
		// ------List Train detailed-------//
		list = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.cssSelector(".col-sm-5.col-xs-11.train-heading")));
		for (WebElement a : list) {
			System.out.println(a.getText());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File srs = ts.getScreenshotAs(OutputType.FILE);
			File dst = new File("ScreenShot/IRCTC.png");
			FileUtils.copyFile(srs, dst);
		}
		driver.quit();

	}
}
