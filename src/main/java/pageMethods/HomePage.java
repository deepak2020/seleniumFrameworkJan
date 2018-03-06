package pageMethods;

import java.io.IOException;

import common.CommonMethod;

public class HomePage {

	public static void verifyHomePage(String title) throws IOException{
		String actualValue = CommonMethod.driver.getTitle();
		String expectedValue = CommonMethod.getProperties(title);
		CommonMethod.assertion(actualValue,expectedValue );
	}

}
