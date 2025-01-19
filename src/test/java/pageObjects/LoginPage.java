package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="input-email")
	WebElement txtEmailAddress;
	
	@FindBy(id="input-password")
	WebElement txtPassword;
	
	@FindBy(xpath="//*[@id='content']/div/div[2]/div/form/input")
	WebElement btnLogin;
	
	@FindBy(xpath="//*[@id='account-login']/div[1]")
	WebElement invalidErrorMsg;
	
	public void setEmail(String email) {
		txtEmailAddress.sendKeys(email);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public String verifyInvalidErrorMsg() {
		String errorText = invalidErrorMsg.getText();
		System.out.println("Invalid Error Message: " + errorText);
		return errorText;
	}

}
