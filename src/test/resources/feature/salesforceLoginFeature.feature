Feature: implementing the salesforce login automation testcases

Background:
Given launch sdfc application with given url "https://login.salesforce.com/"




Scenario: implementing testcase2 Login To SalesForce with valid credentials

When  user on "Loginpage"
When  enter the username from propertyfile 
And   enter the password from propertyfile
And   user click on the login button
And   user on "HomePage"
Then verify page title should be "Home Page ~ Salesforce - Developer Edition"


Scenario: implementing testcase1 User Login with valid username and empty password

When  user on "Loginpage"
And   enter the username from propertyfile
And   clear the password  from inputfeild
And   user click on the login button
And   user on "PwdErrorMsgLoginPage"
Then  verify error message "please enter your password " is  dispalyed

Scenario: implementing testcase3 User selects remember me checkbox 
 
When   user on "Loginpage"
When  enter the username from propertyfile 
And   enter the password from propertyfile
And   user clicks on Remember me checkbox
And   user click on the login button
And   user on "HomePage"
And   user click on user menu button and  click on logout button
And   user on "Loginpage"
Then verify username is displayed and remember me checkbox is selected

Scenario: implementing testcase4A User forgets password
 
When user on "Loginpage"
And clicks on forgot password link
And user on "ForgotPasswordPage"
And user enters "indujait24@tekarch.com" in username field
And clicks on continue button
And user on "ReturnToLoginPage"
Then verify "We’ve sent you an email with a link to finish resetting your password." message is displayed 

Scenario: implementing testcase4B User enters invalid username and invalid password
 
 When user on "Loginpage"
 And user enters "123" for username field
 And user enters "221331" for password field
 And user click on the login button
 And user on "InvalidUsernamePwdPage"
 Then verify error message is present



