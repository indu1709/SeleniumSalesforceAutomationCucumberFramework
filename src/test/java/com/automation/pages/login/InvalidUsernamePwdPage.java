package com.automation.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.test.automation.tests.base.BaseTest;

public class InvalidUsernamePwdPage extends BaseTest {
	@FindBy(xpath = "//div[@id='error']") WebElement errorMsg;
	public InvalidUsernamePwdPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	public boolean foundErrorMessage()
	{
		waitExplicit(errorMsg);
		return isPresent(errorMsg);
	}

}
