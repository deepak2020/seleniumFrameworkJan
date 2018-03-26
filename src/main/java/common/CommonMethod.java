package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommonMethod {

	public static WebDriver driver;

	public static void openBrowser(String BrowserName) throws MalformedURLException {

		if (BrowserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Selenium_Driver\\chromedriver.exe");
//			driver = new ChromeDriver();
//                       this is demo change
			
	 		String Node = " http://172.21.65.54:4444/wd/hub";
	 		String sauceLab = "http://pyneema:dd01d1a4-ffc5-4db3-ab46-e591492aedbf@ondemand.saucelabs.com:80/wd/hub";
	 		DesiredCapabilities cap = DesiredCapabilities.edge();
	 		cap.setPlatform(Platform.WIN10);
	 		cap.setCapability("name", "Web Driver demo Test");
//	 		cap.setVersion("65");
	 		driver = new RemoteWebDriver(new java.net.URL(sauceLab), cap);		
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
	}

	public static void closeBrowser() {
		driver.close();
	
	}

	public static void openURL(String URL) {
		driver.navigate().to(URL);
	}

	public static String getProperties(String Key) throws IOException {
		// Define file path
		File file = new File(
				"C:\\Users\\deepak.kumar\\New_Workspace\\Selenium_Framework_Jan\\config.properties");
		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		return prop.getProperty(Key);

	}
	
	
	public static void assertion(String expectedValue, String actualValue){
		Assert.assertEquals(actualValue, expectedValue);
		
		
	}
	
	public static String getPageSource(){
		String s = driver.getPageSource();
		return s;
	}
	
	public static void click (String locator){
		driver.findElement(By.xpath(locator)).click();
		
	}
	
	public static WebElement findElementByXpath(String locator){
		return driver.findElement(By.xpath(locator));
	}
	
	public static void checkElementIsSelected (String locator){
		WebElement element = findElementByXpath(locator);
		
		if (element.isSelected()==false){
			element.click();
		}
	}
	
	public static void explicitlyWaitForElement(String locator, long time){
		WebDriverWait wait = new WebDriverWait(driver, time);
		
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		
	}
	
	public static void acceptAlert(String action){
		if (action.equalsIgnoreCase("accept")){
		driver.switchTo().alert().accept();
		} else {
			driver.switchTo().alert().dismiss();
		}
		
	}

}
