package vaveTuts.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vaveTuts.AbstractComponents.AbstractComponents;

public class OrderSubmitted extends AbstractComponents{
	
	WebDriver driver;
	

	public OrderSubmitted(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(css=".hero-primary") WebElement ordSubmitText;
	
	public Boolean getconfirmationMessage(String msg) {
		
		Boolean flag=ordSubmitText.getText().equalsIgnoreCase(msg);
		
		return flag;
	}
	
	
   

}
