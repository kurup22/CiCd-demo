package vaveTuts.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vaveTuts.AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents{
	
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		
	   super(driver);
	   this.driver=driver;
	   PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="[placeholder='Select Country']") WebElement countryDropdown;
	By countryResults=By.cssSelector(".ta-results");
	By autoCountryResults=By.cssSelector(".ta-item");
	@FindBy(css=".actions a") WebElement placeOrder;
	String userCountry="India";
	
	public OrderSubmitted selectCountry(String country) {
		
	      countryDropdown.sendKeys(country);
	      waitForElementToAppear(countryResults);
	      List<WebElement> auto=driver.findElements(autoCountryResults);
	      auto.stream().filter(s->
	  	  s.findElement(By.cssSelector("span")).getText().equalsIgnoreCase(userCountry)).findFirst().orElse(null).click();
	      placeOrder.click();
	      return new OrderSubmitted(driver);
	}

	
}
