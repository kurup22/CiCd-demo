package vaveTuts.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import vaveTuts.AbstractComponents.AbstractComponents;

public class cartPageValidations extends AbstractComponents{
	
	WebDriver driver;

	public cartPageValidations(WebDriver driver) {
		
	   super(driver);
	   this.driver=driver;
	   PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(css=".totalRow button") WebElement checkout;
	By cartElementsBy=By.cssSelector(".cartSection h3");
	
	
	
	
	public CheckoutPage cartPageValidate(String productName) {
		
		List<WebElement> cartElements=driver.findElements(cartElementsBy);
		
		Boolean check=cartElements.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(check);
		checkout.click();
		return new CheckoutPage(driver);
		
	}
}
