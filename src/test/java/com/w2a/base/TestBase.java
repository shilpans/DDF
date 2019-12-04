package com.w2a.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.w2a.utilities.ExcelReader;


public class TestBase {
	
/* Initializing WebDriver -done
 * properties -done
 * logs - log4j jar, .log, log4j.properties, logger class
 * ExtentReports
 * DB
 * Excel
 * Mail
 * ReportNG
 * ExtentReports
 * Jenkins
 */
	
	public static WebDriver driver;
	public static Properties config=new Properties();
	public static Properties OR=new Properties();
	public static FileInputStream fis;
	public static Logger log=Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	
	@BeforeSuite
	public void setUp() throws IOException
	{
		if(driver==null)
		{
			fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
			config.load(fis);
			log.debug("config file loaded !!!!");
			
			fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
			OR.load(fis);
			log.debug("OR file loaded !!!!");
		}
		
		if(config.getProperty("browser").equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\geckodriver.exe");
			driver=new FirefoxDriver();
			log.debug("Firefox launched!!!!");
		}
		else if(config.getProperty("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
			driver=new ChromeDriver();
//			log.debug("Chrome launched!!!!");
		}
		else if(config.getProperty("browser").equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
//			log.debug("IE launched!!!!");
		}
		
		driver.get(config.getProperty("testsiteurl"));
		log.debug("Naviagted to ---> "+config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
		
		wait=new WebDriverWait(driver,5);
		
	}
	
	public boolean isElementPresent(By by)
	{
		try{
			
			driver.findElement(by);
			return true;
			
		}catch(NoSuchElementException e){
			
			return false;
			
			
		}
	}
	
	@AfterSuite
	public void tearDown()
	{
//		if(driver!=null){
//		driver.quit();
//		
//		}
//		log.debug("Test Execution completed");
	}
}
