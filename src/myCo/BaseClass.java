package myCo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	private static WebDriver driver = null;
	private static WebDriverWait wait;

	public static void initialization() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.drive", "C:\\Users\\LBalgude\\eclipse-workspace\\testNGAuto\\chromedriver.exe");
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(TestDataCo.URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 20);
		}
	}

	public static WebElement getElement(String locator) {
		WebElement element = null;
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}

	public static List<WebElement> getElements(String locator) throws InterruptedException {
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		Thread.sleep(2000);
		return elements;

	}

	public static void getTextOfElements(String locator, String text) throws InterruptedException {
		List<WebElement> elements = getElements(locator);
		List<String> list=new ArrayList<String>();

		for (WebElement element : elements) {
			list.add(element.getText());
			
			if (element.getText().equalsIgnoreCase(text)) {
				clickOnElement(element);
				Thread.sleep(3000);
				break;
			}
		}
	}

	private static void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public static void clickOnElement(WebElement element) {
		if (!element.isDisplayed())
			scrollToElement(element);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();

	}

	public static void sendText(WebElement element, String keysToSend) {
		element.sendKeys(keysToSend);
	}

	public static boolean getLogo(WebElement logo) {
		boolean checklogo = logo.isDisplayed();
		return checklogo;
	}

	public static WebDriver returnDriver() {
		return driver;
	}

	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static String getURL() {
		String URL = driver.getCurrentUrl();
		return URL;
	}

	public static void quit() {
		driver.quit();
		driver = null;
	}
}
