package pageObjects;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@id='content']/h2[1]")
	WebElement msgHeading;
	
	public boolean isMyAccountPageExists() {
		
		try
		{
		return (msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public String myAccountPageTitle() {
		String myAccountPageTitle = driver.getTitle();
		System.out.println("My Account Page Title : " + myAccountPageTitle);
		return myAccountPageTitle;
	}

}
