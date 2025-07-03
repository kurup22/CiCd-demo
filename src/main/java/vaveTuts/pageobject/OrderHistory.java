package vaveTuts.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vaveTuts.AbstractComponents.AbstractComponents;

public class OrderHistory extends AbstractComponents {
	
	WebDriver driver;

	public OrderHistory(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//tr[@class='ng-star-inserted'][1]/td[2]") WebElement prodName;
	
	public boolean confirmOrderProductName(String actProdName) {
		
		return prodName.getText().equalsIgnoreCase(actProdName);
		
		
	}
        
}
