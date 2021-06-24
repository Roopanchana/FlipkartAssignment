package com.flipcart.qa.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.flipcart.qa.pages.HomePage;
import com.flipcart.qa.pages.LoginPage;
import com.flipcart.qa.pages.ProductPage;
import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.util.ExcelUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ProductPage productPage;
	FileInputStream fileInput1;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeTest
	public void setUp()
	{
		initialization();
		productPage = new ProductPage();
		homePage= new HomePage();
		loginPage= new LoginPage();
		loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyPageTitleTest()
	{
		Assert.assertFalse(homePage.verefypageTitle());
		log.debug("Page Title Verification");
	}
	
	@Test(priority=2)
	public void veifyUserNameTest()
	{
		Assert.assertTrue(homePage.verefyCorrectUserName());
		log.debug("User Name Verification");
	}
	

	@Test(priority=3)
	public void searchElement() throws IOException 
	{
		
//		Map<String, String> testData = ExcelUtil.getMap();
//		productPage = homePage.searchElement(testData.get("product name"));	
		
		productPage = homePage.searchElement("APPLE iPhone 11");
	
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTb.get(1));
        log.debug("Select product");
		
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
