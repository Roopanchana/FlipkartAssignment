package com.flipcart.qa.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.base.TestBase;

public class ProductPage extends TestBase {
	
	@FindBy(xpath="//*[contains(text(),'Roopanchana')]")
	WebElement userName;

	@FindBy(xpath="//span[contains(text(), 'APPLE iPhone 11 (Black, 64 GB)')]")
	WebElement selectProductName;

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
	
	public String verefyProductPrice(String string) 
	{
		// TODO Auto-generated method stub
		return string;
	}




	public PaymentPage productBuyNow() throws InterruptedException
	{
		Thread.sleep(5000);
		buyNow.click();
		return new PaymentPage();

	}






	public String sendKeys(String string) {
		// TODO Auto-generated method stub
		return string;
	}
	
	
}
