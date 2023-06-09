package com.mystore.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystoe.base.baseClass;
import com.mystore.dataprovider.dataProviders;
import com.mystore.objRepo.homePage;
import com.mystore.objRepo.indexPage;
import com.mystore.objRepo.loginPage;
import com.mystore.utility.Log;

public class loginPageTest extends baseClass {
	indexPage indexPage;
	loginPage loginPage;
	homePage homePage;
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

@Test(dataProvider="Credentials",dataProviderClass=dataProviders.class)
public void loginToApplication(String uname, String pwd) throws Exception
{Log.startTestCase("Login test");
	indexPage=new indexPage();
	Log.info("user is going to click on sign in");
	loginPage=indexPage.clickOnSingIn();
	//String userName=prop.getProperty("username");
	//String passWord=prop.getProperty("password");
	//System.out.println(userName + passWord);
	Log.info("Enter username and password");
	//homePage=loginPage.signIntoAcctount(prop.getProperty("username"), prop.getProperty("password"));
	homePage=loginPage.signIntoAcctount(uname, pwd);
	System.out.println();
	Thread.sleep(2000);
	String actualURL=homePage.currentUrl();
	String expectedURL="http://automationpractice.pl/index.php?controller=my-account";
	Log.info("Verifying if user is able to login");
	Assert.assertEquals(actualURL, expectedURL);
	Log.info("Login is success");
	Log.endTestCase("Login test");
}
}

