package com.automation.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.test.automation.tests.base.BaseTest;

public class ReturnToLoginPage extends BaseTest{
	@FindBy(xpath="//a[contains(text(),'Return to Login')]") WebElement ret;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/p[1]") WebElement message;

	public ReturnToLoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void returnToLogin()
	{
		waitExplicit(ret);
		clickElement(ret,"return to Login page");
	}

	public String readMsg()
	{
		waitExplicit(message);
		return(message.getText());
	}

}
