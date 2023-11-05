package com.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/feature/salesforceLoginFeature.feature"},
		glue= {"com.test.cucumber.stepDefinition"},
		monochrome = true,
		dryRun = false,
		plugin = {"pretty","html:target/cucumber-pom-selenium.html"}
		//tags = "@cal and @sub"
		
		)
public class SalesForceRunner extends AbstractTestNGCucumberTests{
	
	

}