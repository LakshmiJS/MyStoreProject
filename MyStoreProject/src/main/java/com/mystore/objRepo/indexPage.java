package com.mystore.objRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystoe.base.baseClass;
import com.mystore.actionDriver.driverActions;
import com.mystore.actionInterface.ActionInterface;

public class indexPage extends baseClass
{
@FindBy(xpath="//a[@class='login']")
WebElement signInBtn;
@FindBy(id="search_query_top")
WebElement searchBox;
@FindBy(xpath="//img[@class='logo img-responsive']")
WebElement logo;
@FindBy(xpath="//a[@title='Contact us']")
WebElement contactUs;
@FindBy(name="submit_search")
WebElement searchIcon;
public indexPage()
{
	PageFactory.initElements(getDriver(), this);
}
public loginPage clickOnSingIn() throws Exception
{
	//driverActions driverActions = new driverActions();
	//driverActions.click(driver,signInBtn);
	driverActions.newClick(getDriver(),signInBtn);
	return new loginPage();
}

public boolean validateLogo()
{
return driverActions.isDisplayed(getDriver(),logo);
}
public String getmyStoreTile()
{
String myStoreTitle =getDriver().getTitle();
System.out.println("Page title is "+myStoreTitle);
return myStoreTitle;
}
public searchResultsPage searchProduct(String productName) throws InterruptedException
{
	driverActions.type(searchBox,productName);

	return new searchResultsPage();
}
}


