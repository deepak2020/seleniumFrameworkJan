package pageMethods;

import java.io.IOException;

import common.CommonMethod;

public class HomePage {

	public static void verifyHomePage(String title) throws IOException{
		String actualValue = CommonMethod.driver.getTitle();
		String expectedValue = CommonMethod.getProperties(title);
		CommonMethod.assertion(actualValue,expectedValue );
	}
	
	
	public static void userClicksOnRegistrationLink() throws IOException{
		CommonMethod.click(CommonMethod.getProperties("RegistrationLink"));
	}
	
	public static void userClicksOnGenderWomen() throws IOException{
		CommonMethod.checkElementIsSelected(CommonMethod.getProperties("womenRadioButton"));
	}
	
	public static void userClicksOnGenderMen() throws IOException{
		CommonMethod.checkElementIsSelected(CommonMethod.getProperties("menRadioButton"));
	}

}
