package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC03_LoginTest extends BaseClass {
	
	@Test
	public void verify_login_with_invalid_credentials() {

		logger.info("** Test Started TC03_LoginTest **");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account Link in Top Navigation");
			hp.clickLogin();
			logger.info("Clicked on Login Link");

			LoginPage lp = new LoginPage(driver);
			lp.setEmail(properties.getProperty("invalidEmail"));
			logger.info("Entered Email");
			lp.setPassword(properties.getProperty("invalidPassword"));
			logger.info("Clicked on Login");
			lp.clickLogin();
			String actualErrorMsg = lp.verifyInvalidErrorMsg();
			if (actualErrorMsg.equals("Warning: No match for E-Mail Address and/or Password.")) {
				Assert.assertTrue(true);
			} else {
				logger.error("Test Failed");
				logger.debug("Debug Logs");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("** Test Finished TC03_LoginTest **");

	}


}
