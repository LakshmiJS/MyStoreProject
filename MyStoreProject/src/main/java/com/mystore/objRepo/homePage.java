package com.mystore.objRepo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystoe.base.baseClass;
import com.mystore.actionDriver.driverActions;


public class homePage extends baseClass {

	@FindBy (xpath="//span[text()='Add my first address']")
	WebElement addMyfirstAddress;
	@FindBy (xpath="//span[text()='Order history and details']")
	WebElement orderHistoryandDetails;
	@FindBy (xpath="//span[text()='My credit slips']")
	WebElement myCreditSlips;
	@FindBy (xpath="//span[text()='My addresses']")
	WebElement myAddresses;
	@FindBy (xpath="//span[text()='My personal information']")
	WebElement myPersonalInformation;
	
	
	public  homePage()
	{
		PageFactory.initElements(getDriver(),this);
	}
	
	public boolean validateAddmyFirstAddressOption()
	{
	
	return driverActions.isDisplayed(getDriver(), addMyfirstAddress);
	
	}
	public boolean validateOrderHistoryandDetails()
	{
	
	return driverActions.isDisplayed(getDriver(),orderHistoryandDetails);
	
	}
	public boolean validateMyAddresses()
	{
	
	return driverActions.isDisplayed(getDriver(), myAddresses);
	
	}
	public boolean validateMyPersonalInformation()
	{
	
	return driverActions.isDisplayed(getDriver(), myPersonalInformation);
	
	}
	public String currentUrl()
	{ 
		String homePageUrl=getDriver().getCurrentUrl();
		return homePageUrl;
	}
	}
	

