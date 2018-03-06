package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CommonMethod {

	public static WebDriver driver;

	public static void openBrowser(String BrowserName) {

		if (BrowserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Selenium_Driver\\chromedriver.exe");
			driver = new ChromeDriver();
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

}
