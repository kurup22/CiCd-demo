package vaveTuts.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vaveTuts.AbstractComponents.AbstractComponents;

public class ProductCatalouge extends AbstractComponents{
	
	WebDriver driver;

	public ProductCatalouge(WebDriver driver) {
		
	   super(driver);
	   this.driver=driver;
	   PageFactory.initElements(driver,this);
	}
	
	
	
	@FindBy(css=".card-body") List<WebElement> products;
	
	By productsBy=By.cssSelector(".card-body");
	By productAddMessage=By.cssSelector("#toast-container div");
	By loadingSpinner=By.className("ngx-animating");
	
	public  List<WebElement> getProductList() {
		 
		waitForElementToAppear(productsBy);
		 return products;
	}
	
	public WebElement getProductByName(String productName) {
		
		WebElement desiredProduct=getProductList().stream().filter(s->
		s.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		
		//.card-body button:last-of-type
		return desiredProduct;
		
	}
	 public cartPageValidations addToCart(String productName) {
		 
		 WebElement addToCartButton=getProductByName(productName).findElement(By.cssSelector(".card-body button:last-of-type"));
		 addToCartButton.click();
		 waitForElementToAppear(productAddMessage);
		 waitForElementToDisappear(loadingSpinner);
		 return new cartPageValidations(driver);
		 	 
		 
	 }
}
