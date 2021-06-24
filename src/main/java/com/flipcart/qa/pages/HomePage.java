package com.flipcart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//title[contains(text(),'Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!')]")
	WebElement pageTitle;
	
	@FindBy(xpath="//*[contains(text(),'Roopanchana')]")
	WebElement userName;
	
	@FindBy(xpath="//*[@type='text']")
	WebElement searchField;
	
	@FindBy(xpath="//*[@class='L0Z3Pu']")
	WebElement submitSearch;
	
	@FindBy(xpath="//*[contains(text(), 'APPLE iPhone 11 (Black, 64 GB)')]")
	WebElement selectProduct;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verefypageTitle()
	{
		return pageTitle.isDisplayed();
		
	}
	
	public boolean verefyCorrectUserName()
	{
		return userName.isDisplayed();
		
	}
	
	public ProductPage searchElement(String sr)
	{
	searchField.click();
	searchField.sendKeys(sr);
	submitSearch.click();
	selectProduct.click();
	return new ProductPage();

	}

}
