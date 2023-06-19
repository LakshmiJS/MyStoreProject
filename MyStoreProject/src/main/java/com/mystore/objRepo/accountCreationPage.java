package com.mystore.objRepo;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mystoe.base.baseClass;
import com.mystore.actionDriver.driverActions;

public class accountCreationPage  extends baseClass{
	@FindBy (id="id_gender1")
	WebElement mrRadiobtn;
	@FindBy (id="id_gender2")
	WebElement mrsRadioBtn;
	@FindBy (id="customer_firstname")
	WebElement firstName;
	@FindBy (id="customer_lastname")
	WebElement lastName;
	@FindBy (id="email")
	WebElement eMail;
	@FindBy (id="passwd")
	WebElement password;
	@FindBy (id="days")
	WebElement dobDay;
	@FindBy (id="months")
	WebElement dobMonth;
	@FindBy (id="years")
	WebElement dobYear;
	@FindBy (xpath="//label[normalize-space()='Receive special offers from our partners!']")
	WebElement splOffersChkbx;
	@FindBy (id="submitAccount")
	WebElement registerBtn;
	@FindBy (xpath="//label[normalize-space()='Sign up for our newsletter!']")
	WebElement newsLetterChkbx;
	
	
	
	
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
	public void createAccount(
			String gender,
			String fName, 
			String lName,
			String pswd,
			String day,
			String month,
			String year,
			String newsletter,
			String optinOffer ) throws Exception
	{
		if(gender.equalsIgnoreCase("male"))
		{
		driverActions.newClick(getDriver(),mrRadiobtn);
		}
		else if(gender.equalsIgnoreCase("female"))
		{
				driverActions.newClick(getDriver(),mrsRadioBtn);
		}
				else
				{
					System.out.println("Invalid input data");
				}
		
		driverActions.type(firstName,fName);
		driverActions.type(lastName, lName);
		//driverActions.type(eMail, email);
		driverActions.type(password, pswd);
		driverActions.selectByValue(dobDay, day);
		driverActions.selectByValue(dobMonth, month);
		driverActions.selectByValue(dobYear, year);
		
		if(newsletter.equalsIgnoreCase("yes"))
		{
			
			System.out.println("Newsletter="+newsletter);
			driverActions.newClick(getDriver(), newsLetterChkbx);
		}
		
		
		/**if(optinOffer.equalsIgnoreCase("yes"))
		{
			driverActions.newClick(getDriver(),splOffersChkbx );
			System.out.println("Optin Option="+optinOffer);
		}**/
	}
	public homePage validateRegistration() throws Exception {
		driverActions.newClick(getDriver(),registerBtn);
		return new homePage();
	}
}


