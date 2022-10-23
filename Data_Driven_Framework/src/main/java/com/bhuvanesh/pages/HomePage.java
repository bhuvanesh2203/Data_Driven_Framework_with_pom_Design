package com.bhuvanesh.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bhuvanesh.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//*[text()='Bhuvanesh M']")
	WebElement homepageName;
	
	@FindBy(xpath="//a[contains(@href,'contacts')]")
	WebElement contactsLink;

	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public ContactsPage clickContacts() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public Boolean verifyUserName() {
			return homepageName.isDisplayed();	
	}
	
}
