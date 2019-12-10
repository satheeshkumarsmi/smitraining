package UI;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SMI_CourseTrackingAdd {
 
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/home/sys-user/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		String url = "https://smi-training-2020.herokuapp.com/dashboard";

		driver.get(url);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("coursetracking")).click();

		driver.findElement(By.id("courseadd")).click();

	}
}

