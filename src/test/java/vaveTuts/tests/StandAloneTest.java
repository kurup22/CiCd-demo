package vaveTuts.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import vaveTuts.AbstractComponents.AbstractComponents;
import vaveTuts.TestComponents.BaseTest;
import vaveTuts.pageobject.*;

public class StandAloneTest extends BaseTest {

	@Test(dataProvider = "getData", groups = { "multiRunCheck" })
	public void submitOrder(HashMap<String, String> input) {

		ProductCatalouge productCatalog = landingpage.LoginApplication(input.get("email"), input.get("password"));

		//productCatalog.getProductList();
		//productCatalog.getProductByName(input.get("productName"));

		cartPageValidations cartPage = productCatalog.addToCart(input.get("productName"));
		cartPage.goToCartPage();

		CheckoutPage checkout = cartPage.cartPageValidate(input.get("productName"));

//	Actions a= new Actions(driver);
//	a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();

		OrderSubmitted ordsubmit = checkout.selectCountry("Ind");
		Assert.assertTrue(ordsubmit.getconfirmationMessage("Thankyou for the order."));

	}

	@Test(dependsOnMethods = { "submitOrder" }, dataProvider = "getData", groups = { "multiRunCheck" })
	public void orderHistoryProductNameValidationsTest(HashMap<String, String> input) {

		ProductCatalouge productCatalog = landingpage.LoginApplication(input.get("email"), input.get("password"));
		OrderHistory ordHistory = productCatalog.goToOrderHistory();
		Boolean flag = ordHistory.confirmOrderProductName(input.get("productName"));
		Assert.assertTrue(flag);

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "\\src\\test\\java\\vaveTuts\\Data\\data.json");

		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}

//public Object[][] getData() {
//	return new Object[][] { {"vavetuts@tits.com","tits@Tuts22","ADIDAS ORIGINAL"},{"shetty@gmail.com","Iamking@000","ZARA COAT 3"}};
//	
}
