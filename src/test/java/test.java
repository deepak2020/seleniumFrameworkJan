import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageMethods.HomePage;

import common.CommonMethod;

public class test {
	
	@BeforeMethod
	public void OpenBrowser() throws IOException {
		String browser = CommonMethod.getProperties("Browser");
		CommonMethod.openBrowser(browser);
	}

	@Test
	public void verifyUserIsOnHomePage() throws IOException {
		CommonMethod.openURL(CommonMethod.getProperties("URL"));
		HomePage.verifyHomePage("FaceBookPageTitle");
		
	}
	
	
	@Test
	public void verifyUserIsOnGooglePage() throws IOException {
		CommonMethod.openURL(CommonMethod.getProperties("GoogleURL"));
		HomePage.verifyHomePage("GooglePageTitle");
		
	}
	
	@AfterMethod
	public void closeBrowser(){
		CommonMethod.closeBrowser();
	}

}
