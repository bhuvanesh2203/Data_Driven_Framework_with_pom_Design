package com.bhuvanesh.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bhuvanesh.base.TestBase;
import com.bhuvanesh.pages.HomePage;
import com.bhuvanesh.pages.LoginPage;

import org.junit.Assert;

public class LoginPageTest extends TestBase{
	LoginPage loginPage; 
	HomePage homePage;
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
    public void setup() {
		initialization();
		loginPage=new LoginPage();
	}
	
	@Test
	public void validatePageTitle() {
		String title=loginPage.validateTitle();
		Assert.assertEquals(title, "Free CRM software for any business with sales, support and customer relationship management");
	}
	@Test
	public void login() throws InterruptedException {
	homePage=loginPage.login(prop.getProperty("userName"),prop.getProperty("Password"));
	Thread.sleep(3000);
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
