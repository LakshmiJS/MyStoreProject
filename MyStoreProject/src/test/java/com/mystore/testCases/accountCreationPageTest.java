package com.mystore.testCases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.dataprovider.dataProviders;
import com.mystore.objRepo.*;
import com.mystore.utility.Log;
import com.mystoe.base.baseClass;

public class accountCreationPageTest extends baseClass
{
indexPage indexPage;
loginPage loginPage;
homePage homePage;
accountCreationPage accountCreationPage;
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		launchApp();
	}
	@AfterMethod
	public void tearDown()
	{
		getDriver().quit();
	}
	//(dataProvider="NewAccount",dataProviderClass=dataProviders.class)

	public void verifyAccountCreation() throws Exception
	{
		Log.startTestCase("Verify Account Creation Page test");
		indexPage=new indexPage();
		loginPage=new loginPage();
		accountCreationPage=new accountCreationPage();
		Log.info("User is going to click on SignIn link");
		indexPage.clickOnSingIn();
		Log.info("User is going to enter email Id");
		loginPage.createNewAccountPage(prop.getProperty("newUserName"));
		//loginPage.createNewAccount(newEmail);
		Thread.sleep(1000);
		String accountCreationPageURL="http://automationpractice.pl/index.php?controller=authentication&back=my-account#account-creation";
		String actualURL=accountCreationPage.getAccountCreationPageURL();
		Assert.assertEquals(actualURL,accountCreationPageURL);
		Log.endTestCase("Verify Account Creation Test");;
	}
	@Test(groups = "Regression",dataProvider = "newAcountDetailsData",dataProviderClass = dataProviders.class)
	public void createNewAccount(HashMap<String,String> hashMapValue)throws Exception
	
	{
		Log.startTestCase("New Account Creation test");
		indexPage=new indexPage();
		loginPage=new loginPage();
		accountCreationPage=new accountCreationPage();
		Log.info("User is going to click on SignIn link");
		indexPage.clickOnSingIn();
		Log.info("User is going to enter email Id");
		accountCreationPage=loginPage.createNewAccountPage(hashMapValue.get("Email"));
		accountCreationPage.createAccount(hashMapValue.get("Gender"),
				hashMapValue.get("FirstName"),
				hashMapValue.get("LastName"),
				hashMapValue.get("SetPassword"),
				hashMapValue.get("Day"),
				hashMapValue.get("Month"),
				hashMapValue.get("Year"),
				hashMapValue.get("Newsletter"),
				hashMapValue.get("OptinOffer"));
		homePage=accountCreationPage.validateRegistration();
		Thread.sleep(5000);
		Assert.assertEquals("http://automationpractice.pl/index.php?controller=my-account", homePage.currentUrl());
		Log.endTestCase("New Account Creation Test");
	}
}

