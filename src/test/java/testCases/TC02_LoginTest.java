package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC02_LoginTest extends BaseClass {

	@Test
	public void verify_login_with_valid_credentials() {

		logger.info("** Test Started TC02_LoginTest **");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account Link in Top Navigation");
			hp.clickLogin();
			logger.info("Clicked on Login Link");

			LoginPage lp = new LoginPage(driver);
			lp.setEmail(properties.getProperty("validEmail"));
			logger.info("Entered Email");
			lp.setPassword(properties.getProperty("validPassword"));
			logger.info("Clicked on Login");
			lp.clickLogin();

			MyAccountPage map = new MyAccountPage(driver);
			String actualTitle = map.myAccountPageTitle();
			if (actualTitle.equals("My Account")) {
				Assert.assertTrue(true);
			} else {
				logger.error("Test Failed");
				logger.debug("Debug Logs");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("** Test Finished TC02_LoginTest **");

	}
	
	
}
