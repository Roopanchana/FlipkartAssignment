package com.flipcart.qa.testcases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.flipcart.qa.pages.HomePage;
import com.flipcart.qa.pages.LoginPage;
import com.flipcart.qa.pages.PaymentPage;
import com.flipcart.qa.pages.ProductPage;
import com.flipkart.qa.base.TestBase;

public class PaymentPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ProductPage productPage;
	PaymentPage paymentPage;
	//private char[] invalidMessage;
	
	
	
	public PaymentPageTest()
	{
		super();
	}
	
	@BeforeTest
	public void setUp() throws InterruptedException
	{
		initialization();
		paymentPage = new PaymentPage();
		productPage = new ProductPage();
		homePage= new HomePage();
		loginPage= new LoginPage();
		
		
		loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		Thread.sleep(5000);
		homePage.searchElement("APPLE iPhone 11 ");
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTb.get(1));
        productPage.productBuyNow();
	}
	
	
	
	@Test(priority=1)
	public void payment()
	{
	try {
	Thread.sleep(5000);
	} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}



	try {
	paymentPage.paymentStep("8455269875441478");
	log.debug("Entering Card Number");
	} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	}
	// System.out.println(invalidMessage);

	@Test(priority=2)
	public void invalid()
	{
	String message=paymentPage.invalidCardNumber();
	Assert.assertEquals(message, "Not a valid card number","Valid Number");
	log.debug("Card Validation");
	}


	

	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}


}
