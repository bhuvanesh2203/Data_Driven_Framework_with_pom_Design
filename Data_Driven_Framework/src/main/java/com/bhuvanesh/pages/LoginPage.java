package com.bhuvanesh.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bhuvanesh.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(name="email")
	WebElement email;

	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[text()='Login']")
	WebElement Login;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateTitle() {
		return driver.getTitle();
		
	}
	public HomePage login(String userName,String Password) {
		try {
		Login.click();	
		Thread.sleep(4000);
		email.sendKeys(userName);
		password.sendKeys(Password);
		Login.click();
		
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}
		return new HomePage();
	}
}
