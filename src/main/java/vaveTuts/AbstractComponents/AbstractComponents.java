package vaveTuts.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import vaveTuts.pageobject.OrderHistory;
import vaveTuts.pageobject.cartPageValidations;

public class AbstractComponents {
	
	   WebDriver driver;
	   
	public AbstractComponents(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
	}

	public void waitForElementToAppear(By findBy) {
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
	
public void waitForWebElementToAppear(WebElement webelement) {
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(webelement));
		
	}
	
public void waitForElementToDisappear(By findBy) {
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
		}
		
public void waitForElementToClickable(By findBy) {
	
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(findBy));
	
}

public void waitForWebElementToClickable(WebElement webelement) {
	
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(webelement));
	
}

//------------------go to cart page button---------------------------------------------
By cartButton = By.cssSelector("[routerlink*='cart']");
public cartPageValidations goToCartPage() {
	
	waitForElementToClickable(cartButton);
	driver.findElement(cartButton).click();
	return new cartPageValidations(driver);
	
	}

//----------------go to order history page------------

@FindBy(css="[routerlink*='myorders']") WebElement orderHistory;

 public OrderHistory goToOrderHistory ()
 {
	  waitForWebElementToClickable(orderHistory);
	  orderHistory.click();
	  return new OrderHistory(driver);
	  
 }
	}
	
	


