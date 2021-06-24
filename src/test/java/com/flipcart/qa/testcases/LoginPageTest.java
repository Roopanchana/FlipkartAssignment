package com.flipcart.qa.testcases;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.flipcart.qa.pages.HomePage;
import com.flipcart.qa.pages.LoginPage;
import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.util.ExcelUtil;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest()
	{
		super();
	}
	
	
	@BeforeTest
	public void setUp()
	{
		initialization();
		loginPage= new LoginPage();
		
	}
	
	
	@Test
	public void loginTest() throws IOException
	{
		log.debug("login to flipkart");
		Map<String, String> testData = ExcelUtil.getMap();
		System.out.println(testData);
		homePage = loginPage.login(testData.get("username"), testData.get("password"));
		
		//homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
