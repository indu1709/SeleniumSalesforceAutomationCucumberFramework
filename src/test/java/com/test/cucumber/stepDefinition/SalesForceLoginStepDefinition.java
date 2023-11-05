package com.test.cucumber.stepDefinition;

import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import com.automation.pages.Home.HomePage;
import com.automation.pages.login.ForgotPasswordPage;
import com.automation.pages.login.InvalidUsernamePwdPage;
import com.automation.pages.login.LoginPage;
import com.automation.pages.login.PwdErrorMsgLoginPage;
import com.automation.pages.login.ReturnToLoginPage;
import com.test.automation.cucumber.utility.Log4JUtility;
import com.test.automation.cucumber.utility.PropertiesUtility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@Listeners(com.test.automation.cucumber.utility.TestEventListenersUtility.class)

public class SalesForceLoginStepDefinition {
	// protected static Logger log;
	public static WebDriver driver;
	protected static Log4JUtility logObject = Log4JUtility.getInstance();
	protected static Logger mylog;
	PwdErrorMsgLoginPage pwdErrorMsgLogin;

	LoginPage loginPage;
	HomePage home;
	ReturnToLoginPage returntoLogin;
	ForgotPasswordPage forgotpwdPage;
	InvalidUsernamePwdPage invalidUserPAge;
	String userName;
	String password;
	String expected;

	public void launchBrowser(String browserName) {
		switch (browserName) {
		case "firefox":

			driver = new FirefoxDriver();
			driver.manage().window().maximize();

			break;
		case "chrome":
			driver = new ChromeDriver();
			driver.manage().window().maximize();

			break;
		}
		System.out.println(browserName + " browser opened");
	}

	public void goToUrl(String url) {
		driver.get(url);
		mylog.info(url + "is entered");
	}

	public void closeBrowser() {
		driver.close();
		mylog.info("current browser closed");
	}

	@BeforeAll
	public static void setUpBeforeAllScenarios() {
		mylog = logObject.getLogger();
	}

	@Before
	public void setUpEachScenario() {

		launchBrowser("chrome");

	}

	@After
	public void tearDown() {
		closeBrowser();
	}

	@Given("launch sdfc application with given url {string}")
	public void launch_sdfc_application_with_given_url(String string) throws InterruptedException {
		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = new Properties();
		propUtility.loadFile("applicationDataProperties", prop);
		userName = propUtility.getPropertyValue("login.valid.userid", prop);
		password = propUtility.getPropertyValue("login.valid.password", prop);
		expected = propUtility.getPropertyValue("Home.page.title", prop);
		String url = propUtility.getPropertyValue("url", prop);
		System.out.println(url + "url");
		goToUrl(url);
		System.out.println(userName + "userName");
		System.out.println("driver in baseTest=" + driver.toString());
	}

	@When("user on {string}")
	public void user_on_loginpage(String pagename) {
		System.out.println(pagename);
		switch (pagename)

		{

		case "Loginpage":
		 {
			System.out.println("inside switch case login page");
			loginPage = new LoginPage(driver);
			System.out.println("new login");
			break;
		}
		case "HomePage": {
			home = new HomePage(driver);
			break;
		}
		
		 case "ForgotPasswordPage": { forgotpwdPage = new ForgotPasswordPage(driver); break; }
		  case "InvalidUsernamePwdPage": { 
			  invalidUserPAge=new InvalidUsernamePwdPage(driver);
		  break; }
		  case "PwdErrorMsgLoginPage": {
			pwdErrorMsgLogin = new PwdErrorMsgLoginPage(driver);
			break;
		}
		
		  case "ReturnToLoginPage": { returntoLogin = new ReturnToLoginPage(driver);
		  break; }
		 
		}
	}

	@When("enter the username from propertyfile")
	public void enter_the_username_from_propertyfile() {
		loginPage.enterUserName(userName);

	}

	@When("enter the password from propertyfile")
	public void enter_the_password_from_propertyfile() {

		loginPage.enterPassword(password);
	}

	@When("clear the password  from inputfeild")
	public void clear_the_password_from_inputfeild() {

		loginPage.clearPasswordNameElement();
	}

	@When("user click on the login button")
	public void user_click_on_the_login_button() {
		loginPage.clickLoginButton();
	}

	@Then("verify page title should be {string}")
	public void verify_page_title_should_be(String expected) throws InterruptedException {
		String actual = HomePage.getTextFromHomePage();
		Assert.assertEquals(actual, expected);

	}

	@Then("verify error message {string} is  dispalyed")
	public void verify_error_message_is_dispalyed(String errMsg) {
		boolean actualMsg = pwdErrorMsgLogin.foundErrorMessage();
		Assert.assertTrue(actualMsg);
	}
	
	@When("user clicks on Remember me checkbox")
	public void user_clicks_on_remember_me_checkbox() {
	    loginPage.selectRememberMeChkbox();
	}
	@When("user click on user menu button and  click on logout button")
	public void user_click_on_user_menu_button() throws InterruptedException {
	    home.selectUserMenu();
	    Thread.sleep(3000);
	}
	
	@When("user click on logout button")
	public void user_click_on_logout_button() {
		home.logout();
	}
	@Then("verify username is displayed and remember me checkbox is selected")
	public void verify_username_is_displayed_and_remember_me_checkbox_is_selected() {
	    boolean unameIsEmpty = loginPage.chkIfUnameEmpty();
	    boolean rememberMeSelected = loginPage.chkIfRememberUnameSelected();
	    Assert.assertFalse(unameIsEmpty);
	    Assert.assertTrue(rememberMeSelected);
	}

	@When("clicks on forgot password link")
	public void clicks_on_forgot_password_link() {
	   loginPage.forgotPwdLink();
	}

	@When("user enters {string} in username field")
	public void user_enters_in_username_field(String username) {
		forgotpwdPage.enterUname(username);
	}
	@When("clicks on continue button")
	public void clicks_on_continue_button() {
		loginPage.clickOnContinue();
	}
	@Then("verify {string} message is displayed")
	public void verify_message_is_displayed(String expectedMsg) {
	    String actual = returntoLogin.readMsg();
	    Assert.assertEquals(actual,expectedMsg);

	   	}
	
	@When("user enters {string} for username field")
	public void user_enters_for_username_field(String uname) {
		loginPage.enterUserName(uname);
	}
	
	@When("user enters {string} for password field")
	public void user_enters_for_password_field(String password) {
		loginPage.enterPassword(password);
	}
	
	@Then("verify error message is present")
	public void verify_error_message_is_present() {
	    Assert.assertTrue(invalidUserPAge.foundErrorMessage());
	}





}
