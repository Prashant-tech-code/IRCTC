package Daywisetarget.Automation;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Spicejet {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement From = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Select Destination']")));
		From.click();
		List<WebElement> selectcity = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//div[contains(@class,'css-76zvg2') and contains(text(),'Jaipur')]")));
		for (WebElement a : selectcity) {
			if (a.getText().contains("Jaipur")) {
				a.click();
				break;
			}
		}
		WebElement date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				".css-1dbjc4n.r-1awozwy.r-19m6qjp.r-156aje7.r-y47klf.r-1phboty.r-1d6rzhh.r-1pi2tsx.r-1777fci.r-13qz1uu")));
		date.click();
		WebElement adult = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep'])[5]")));
		adult.click();
		WebElement clickadult = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")));
		int i = 1;
		while (i < 4) {
			clickadult.click();
			i++;
		}
		adult.click();
		WebElement radiobutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"(//div[@class='css-76zvg2 r-cqee49 r-1enofrn r-1ozqkpa'][normalize-space()='Senior Citizen'])")));
		radiobutton.click();
		WebElement clicksearch = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-testid='home-page-flight-cta']")));
		clicksearch.click();
		WebElement popupclick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"(//div[@class='css-1dbjc4n r-1awozwy r-z2wwpe r-1tazni7 r-18u37iz r-1777fci r-d9fdf6 r-1w50u8q r-ah5dr5'])[1]")));
		popupclick.isEnabled();
		WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[name()='rect'])[2]")));
		checkbox.click();
		if (popupclick.isDisplayed()) {
			popupclick.click();
		}
		driver.quit();
	}

}
