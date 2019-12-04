package com.w2a.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class BankManagerLoginTest extends TestBase {
	@Test
	public void loginAsBankManager() throws InterruptedException
	{
		log.debug("Inside Login Test");
		driver.findElement(By.xpath(OR.getProperty("bmlBtn"))).click();
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("addCustBtn","Login not Successfull"))));
		log.debug("Login Succefully executed");
		
	}

}
