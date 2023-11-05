package com.automation.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.test.automation.tests.base.BaseTest;

public class LoginPage extends BaseTest {
	@FindBy(id = "username")
	WebElement userNameElement;
	@FindBy(id = "password")
	WebElement passwordElement;
	@FindBy(id = "Login")
	WebElement loginButtonElement;
	@FindBy(xpath = "//input[@id='rememberUn']")
	WebElement rememberUserName;
	@FindBy(xpath="//a[@id='forgot_password_link']")  WebElement forgotPwd;
	@FindBy(xpath="//input[@id='continue']") WebElement cont;



	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void enterUserName(String data) {
		// userNameElement.sendKeys(data);
		System.out.println(data + "data");
		System.out.println(userNameElement + "userName");
		enterText(userNameElement, data, "Username textbox");
	}

	public void enterPassword(String data) {
		enterText(passwordElement, data, "password field");
	}

	public void clearUserNameElement() {
		clearElement(userNameElement, "Username field");
	}

	public void clearPasswordNameElement() {
		clearElement(passwordElement, "password field");
	}

	public void clickLoginButton() {
		clickElement(loginButtonElement, "login button");

	}

	public String getTitleOfThePAge() {
		// waitUntilPageLoads();
		return getPageTitle();
	}

	public void selectRememberMeChkbox() {
		// TODO Auto-generated method stub
		checkBoxElement(rememberUserName, "select remember me check box");
	}

	public boolean chkIfUnameEmpty() {

		String userName = getTextFromElement(userNameElement, "username");
		if (userName != null)

			return false;
		else
			return true;
	}

	public boolean chkIfRememberUnameSelected() {
		if(isCheckBoxSelected(rememberUserName))
			return true;
			else
				return false;
	}

	public void forgotPwdLink()
		{
			waitExplicit(forgotPwd);
			clickElement(forgotPwd,"forgot password");
		}

	public void clickOnContinue() {
		waitExplicit(cont);
		clickElement(cont,"continue button");
	
	}


}