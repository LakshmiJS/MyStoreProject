package com.mystore.testCases;
import com.mystore.dataprovider.dataProviders;
import com.mystore.objRepo.*;
import com.mystore.utility.Log;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystoe.base.baseClass;

public class indexPageTest extends baseClass{
	indexPage indexPage;
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws InterruptedException
	{
		launchApp(browser);
	}
@AfterMethod(groups = {"Smoke","Sanity","Regression"})
public void tearDown()
{
	getDriver().quit();
}
@Test(groups= {"Sanity","Smoke"})
public void verifyLogo()

{Log.startTestCase("Verifying Logo");
	indexPage=new indexPage();
	boolean result=indexPage.validateLogo();
	Assert.assertTrue(result);
	Log.info("Logo is verified");
	Log.endTestCase("Verifying Logo Test");

}
@Test(groups= "Smoke")
public void verifyTitle()

{Log.startTestCase("Verify Title");
	String title=indexPage.getmyStoreTile();
	Assert.assertEquals(title, "My Store");
	Log.info("Title is verified");
	Log.endTestCase("Verify Title");

	}
}

