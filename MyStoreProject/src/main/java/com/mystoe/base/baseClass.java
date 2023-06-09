package com.mystoe.base;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;



public class baseClass{
	public static Properties prop;
	//public static WebDriver driver;
	public static ThreadLocal<RemoteWebDriver> driver=new ThreadLocal<RemoteWebDriver>();
	@BeforeSuite
	public void beforeSuite() throws FileNotFoundException, IOException
	{
		String log4jConfigFile = System.getProperty("user.dir") + File.separator + "log4j2.xml";
		ConfigurationSource source = new ConfigurationSource(new FileInputStream(log4jConfigFile));
		Configurator.initialize(null, source);
	}
	
	public static WebDriver getDriver()
	{
		return driver.get();
	}
@BeforeTest
public void loadConfig()
{
	try
	{
		prop= new Properties();
		System.out.println("Super constructor overloaded");
		FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\Config.properties");
		prop.load(ip);
		System.out.println(ip);
		System.out.println("driver:"+ driver);
		
	}
	catch(FileNotFoundException e)
	{
		e.printStackTrace();
		
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
}

public static void launchApp() throws InterruptedException
{
	
	String browserName = prop.getProperty("browser");
	System.out.println(browserName);
	if(browserName.equalsIgnoreCase("Chrome"))
	{
		WebDriverManager.chromedriver().setup();
	driver.set(new ChromeDriver());
	}if(browserName.contains("Firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
	driver.set(new FirefoxDriver());
	}
	if(browserName.contains("IE"))
	{
		WebDriverManager.iedriver().setup();
	driver.set(new InternetExplorerDriver());
	}
	getDriver().get(prop.getProperty("url"));
	getDriver().manage().window().maximize();
    Thread.sleep(2000);
}
}
