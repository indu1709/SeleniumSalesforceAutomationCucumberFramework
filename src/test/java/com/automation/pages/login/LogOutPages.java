package com.automation.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.test.automation.tests.base.BaseTest;

public class LogOutPages  extends BaseTest {

	@FindBy(xpath="//a[contains(text(),'Return to Login')]") WebElement logout;

	public LogOutPages(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
