package com.bhuvanesh.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bhuvanesh.base.TestBase;
import com.bhuvanesh.pages.ContactsPage;
import com.bhuvanesh.pages.HomePage;
import com.bhuvanesh.pages.LoginPage;

public class HomePageTest extends TestBase {
    public HomePageTest homePageTest;
    public HomePage homePage;
    public ContactsPage contactspage;
    LoginPage loginPage; 
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
    public void setup() {
		initialization();
		homePage=new HomePage();
		loginPage=new LoginPage();
		loginPage.login(prop.getProperty("userName"),prop.getProperty("Password"));
	}
	
	@Test
	public void verifyUserName() {
		Assert.assertTrue(homePage.verifyUserName());
	}
	
	@Test
	public void clickContacts() throws InterruptedException {
		contactspage=homePage.clickContacts();
		Thread.sleep(7000);
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
