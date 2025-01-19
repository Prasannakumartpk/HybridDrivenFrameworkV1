package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class SC01_AccountRegistrationTest extends BaseClass {

	@Test
	public void TC01_verify_account_registration() {
		
		logger.info("** TC01_verify_account_registration Test Started **");
		
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Account Link in Top Navigation");
		hp.clickRegister();
		logger.info("Clicked on Registration Link ");
		
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		regPage.setFirstName(randomAlphabetics().toUpperCase());
		logger.info("Entered First Name");
		regPage.setLastName(randomAlphabetics().toUpperCase());
		logger.info("Entered Last Name");
		regPage.setEmail(randomAlphabetics()+"@gmail.com");
		logger.info("Entered Email");
		regPage.setTelephone(randomNumber());
		logger.info("Entered Telephone Number");
		String password = randomAlphaNumeric();
		regPage.setPassword(password);
		logger.info("Entered Password");
		regPage.setConfirmPassword(password);
		logger.info("Entered Confirm Password");
		regPage.setPrivacyPolicy();
		logger.info("Checked Policy Check Box");
		regPage.clickContinue();
		logger.info("Clicked on Continue");
		String confirmationMsg = regPage.getConfirmationMsg();
		if(confirmationMsg.equals("Your Account Has Been Created!")) 
		{
			Assert.assertTrue(true);
		}
		else 
		{
			logger.error("Test Failed");
			logger.debug("Debug Logs");
			Assert.assertTrue(false);
		}	
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("** TC01_verify_account_registration Test Finished **");	
	}
}
