package com.mystore.objRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystoe.base.baseClass;
import com.mystore.actionDriver.driverActions;

public class loginPage extends baseClass {
	
	@FindBy(xpath="//input[@id='email']")
	WebElement signInEmail;
	@FindBy(name="passwd")
	WebElement signInPassword;
	@FindBy(xpath=" //a[@title=\"Recover your forgotten password\"]")
	WebElement forgotPaswdLink;
	@FindBy(id="SubmitLogin")
	WebElement signInBtn;
	@FindBy(id="email_create")
	WebElement newAccountEmail;
	@FindBy(id="SubmitCreate")
	WebElement createAccountBtn;
	
	public loginPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public homePage signIntoAcctount(String uname, String pswd) throws Exception
	
	{
		System.out.println("In Sign In method");
		System.out.println("In SignIn to Account method"+signInEmail);
		Thread.sleep(2000);
		driverActions.type(signInEmail, uname);
		Thread.sleep(2000);
		System.out.println(signInPassword);
		driverActions.type(signInPassword, pswd);
		Thread.sleep(2000);
		driverActions.newClick(getDriver(),signInBtn);
		Thread.sleep(2000);
	    return new homePage();
	}
	public accountCreationPage createNewAccount(String email) throws Exception
	{
		driverActions.type(newAccountEmail, email);
		driverActions.newClick(getDriver(), createAccountBtn);
		Thread.sleep(7000);
		return new accountCreationPage();
	}
	public forgotPasswordPage clickOnForgotPasswordLink() throws Exception
	
	{
		driverActions.newClick(getDriver(),forgotPaswdLink);
		return new forgotPasswordPage();
	}
	}
