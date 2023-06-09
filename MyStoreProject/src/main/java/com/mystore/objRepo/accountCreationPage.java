package com.mystore.objRepo;

import org.openqa.selenium.support.PageFactory;

import com.mystoe.base.baseClass;

public class accountCreationPage  extends baseClass{
	
	public accountCreationPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public String getAccountCreationPageURL()
	{
		String accountCreationPageURL=getDriver().getCurrentUrl();
		System.out.println(accountCreationPageURL);
		return accountCreationPageURL;
	}

}
