package com.mystore.testCases;
import com.mystore.objRepo.*;
import com.mystore.utility.Log;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystoe.base.baseClass;

public class indexPageTest extends baseClass{
	indexPage indexPage;
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
@Test
public void verifyLogo()

{Log.startTestCase("Verifying Logo");
	indexPage=new indexPage();
	boolean result=indexPage.validateLogo();
	Assert.assertTrue(result);
	Log.info("Logo is verified");
	Log.endTestCase("Verifying Logo Test");

}
@Test
public void verifyTitle()

{Log.startTestCase("Verify Title");
	String title=indexPage.getmyStoreTile();
	Assert.assertEquals(title, "My Store");
	Log.info("Title is verified");
	Log.endTestCase("Verify Title");

	}
}

