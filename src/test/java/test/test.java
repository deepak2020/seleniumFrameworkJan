package test;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageMethods.HomePage;

import common.CommonMethod;

public class test {

	@BeforeTest (groups = { "Always" })
	public void OpenBrowser() throws IOException {
		String browser = CommonMethod.getProperties("Browser");
		CommonMethod.openBrowser(browser);
	}

	@Test(groups = { "Google", "Sanity", "Regression" }, enabled = false)
	public void verifyUserIsOnGooglePage() throws IOException {
		CommonMethod.openURL(CommonMethod.getProperties("GoogleURL"));
		HomePage.verifyHomePage("GooglePageTitle");

	}

	@Test(groups = { "Facebook", "Regression" }, enabled = false)
	public void verifyUserIsOnHomePage() throws IOException {
		CommonMethod.openURL(CommonMethod.getProperties("URL"));
		HomePage.verifyHomePage("FaceBookPageTitle");

	}

	@Test 
	public void OpenUrl() throws IOException {
		CommonMethod.openURL(CommonMethod.getProperties("alertUrl"));
		
	}
	
	@Test (dependsOnMethods="OpenUrl")
	public void handleAlerts() throws IOException{
		CommonMethod.click(CommonMethod.getProperties("alertLocator"));
		CommonMethod.acceptAlert("reject");
	}
	
	@Test (dependsOnMethods="OpenUrl", enabled=false)
	public void userClicksOnGenderWomen() throws IOException, InterruptedException{
		
		HomePage.userClicksOnGenderWomen();
	
	}
	
	@Test (dependsOnMethods="userClicksOnGenderWomen", enabled=false)
	public void userClicksOnGenderMen() throws IOException, InterruptedException{
		
		HomePage.userClicksOnGenderMen();
	
	}
	
	@Test (enabled=false)
	public void clickOnRegistrationLink() throws IOException{
		CommonMethod.explicitlyWaitForElement(CommonMethod.getProperties("RegistrationLink"), 30);
		HomePage.userClicksOnRegistrationLink();
	}

	@DataProvider(name = "URLS")
	public static Object[][] URLS() {
		return new Object[][] { {"https://www.google.com"} ,
				{"https://www.facebook.com"}};

	}

	@AfterTest (groups = { "Always" })
	public void closeBrowser() {
//		CommonMethod.closeBrowser();
	}

}
