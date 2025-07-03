package vaveTuts.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import vaveTuts.AbstractComponents.AbstractComponents;
import vaveTuts.TestComponents.BaseTest;
import vaveTuts.pageobject.*;

public class ErrorValidationsTests extends BaseTest {

	@Test
	public void wrongPasswordScenario() throws IOException {

	

		landingpage.LoginApplication("vavetuts@tits.com", "tits@Tuts2");
		Assert.assertTrue(landingpage.errorLogin("Incorrect email or password."));		
	}
	
	@Test
	public void wrongUsernameScenario() throws IOException {

	

		landingpage.LoginApplication("vavetuts@.com", "tits@Tuts22");
		Assert.assertTrue(landingpage.errorLogin("Incorrect email or password."));		
	}


}
