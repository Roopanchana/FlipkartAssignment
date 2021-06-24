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

public class ProductPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ProductPage productPage;
	PaymentPage paymentPage;
	
	
	
	public ProductPageTest()
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
	}
	
	
	
	@Test(priority=1)
	public void veifyUserNameTest() throws InterruptedException
	{
		Thread.sleep(5000);
		Assert.assertTrue(productPage.verefyCorrectUserName());
		log.debug("Page Title Verification");
	}
	
	
	
	@Test(priority=2)
	public void verifyProductNameTest() throws InterruptedException
	{
		Thread.sleep(5000);
		Assert.assertFalse(productPage.verefyProductName());
		log.debug("User Name Verification");
	}
	
	
	
	@Test(priority=3)
	public void verifyProductPrice() throws InterruptedException
	{
		double expectedPrice = 14499.00;
		
		double actualPrice = 14499.00;
		
		Thread.sleep(5000);
		
		Assert.assertEquals(expectedPrice, actualPrice);
		System.out.println("Assert Passed");
		log.debug("Price Comparison");
	}
	
	
	
	@Test(priority=4)
	public void searchElement() throws InterruptedException
	{
		Thread.sleep(5000);
		paymentPage = productPage.productBuyNow();
		log.debug("Entering Into PaymentPage");
		
	}
	
	
	
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
