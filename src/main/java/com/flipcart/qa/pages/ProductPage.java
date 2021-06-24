package com.flipcart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.base.TestBase;

public class ProductPage extends TestBase {
	
	@FindBy(xpath="//*[contains(text(),'Roopanchana')]")
	WebElement userName;
	
	@FindBy(xpath="//*[contains(text(), 'APPLE iPhone 11 (Black, 64 GB)')]")
	WebElement selectProductName;
	
//	@FindBy(xpath="//*[contains(@class, '_30jeq3 _16Jk6d')]")
//	WebElement selectProductPrice;
	
	@FindBy(xpath="//button[@type='button']")
	WebElement buyNow;
	
	public ProductPage()
	{
		PageFactory.initElements(driver, this);
	}
	

	public boolean verefyCorrectUserName()
	{
		return userName.isDisplayed();
		
	}
	
	public boolean verefyProductName()
	{
		return selectProductName.isDisplayed();
		
	}
	
//	public boolean verefyProductPrice()
//	{
//		return selectProductPrice.isDisplayed();
//		
//	}
	
	public PaymentPage productBuyNow() throws InterruptedException
	{
		Thread.sleep(5000);
		buyNow.click();
		
		return new PaymentPage();
		
	}


	
	
}
