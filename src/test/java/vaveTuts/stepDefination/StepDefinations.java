package vaveTuts.stepDefination;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import vaveTuts.TestComponents.BaseTest;
import vaveTuts.pageobject.CheckoutPage;
import vaveTuts.pageobject.LandingPage;
import vaveTuts.pageobject.OrderSubmitted;
import vaveTuts.pageobject.ProductCatalouge;
import vaveTuts.pageobject.cartPageValidations;

public class StepDefinations extends BaseTest {
	
 public LandingPage landingPage;
 public ProductCatalouge prodCatalouge ;
 public cartPageValidations cartPageObject;
 public CheckoutPage checkout ;
 public OrderSubmitted ordsubmit;
	
	@Given("I landed on Ecommerce page")
	public void I_Landed_on_Ecommerce_Page () throws IOException {
		
		landingPage=launchApplication();
		
	}

	@Given("^Logged in with username (.+) and password (.+)$")
	
	 public void logged_in_username_and_password(String username, String password) {
		
		 prodCatalouge=landingPage.LoginApplication(username, password);
		
		
	}
	
	@When("^I add product (.+) to cart$")
	 public void I_Add_Product_to_Cart(String productName) {
		
		
		cartPageObject=prodCatalouge.addToCart(productName);
				
			
	}
	
	
	@And("^checkout (.+) and submit the order$")
	
public void checkout_product_and_submit_order(String productName) {
		cartPageObject.goToCartPage();
		checkout=cartPageObject.cartPageValidate(productName);
		ordsubmit=checkout.selectCountry("Ind");
		
			}
	
	
	@Then("{string} message is displyaed on ConfirmationPage")
	public void verify_confirmation_message(String message)
	{
		Boolean flag=ordsubmit.getconfirmationMessage( message);
		Assert.assertTrue(flag);
		driver.quit();
	}
	
	@Then("Verify {string} message is displayed")
	public void verifyErrorMessageIsDisplayed(String expectedMessage) {
		
		Boolean flag=landingPage.errorLogin(expectedMessage);
		Assert.assertTrue(flag);
		driver.quit();
	}
	
}
