package vaveTuts.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vaveTuts.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		
	   super(driver);
	   this.driver=driver;
	   PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="#userEmail") WebElement username;
	@FindBy(css="#userPassword") WebElement userpassword;
	@FindBy(css="#login") WebElement loginButton;
	
	@FindBy(css="[class*='flyInOut']") WebElement errorAlert;
	
	public ProductCatalouge LoginApplication(String email, String password) {
		
		username.sendKeys(email);
		userpassword.sendKeys(password);
		loginButton.click();
		return new ProductCatalouge(driver);
	}

	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public Boolean errorLogin(String errormsg) {
		
		waitForWebElementToAppear(errorAlert);
		System.out.println(errorAlert.getText());
		Boolean msgFlag=errorAlert.getText().equalsIgnoreCase(errormsg);
		
		return msgFlag;
	}
}
