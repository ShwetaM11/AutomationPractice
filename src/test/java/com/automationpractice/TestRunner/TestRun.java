package com.automationpractice.TestRunner;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;


/**
 * this is the main class to run the project.<br>
 * HTML and JSON report file for project feature files are generated from here. <br>
 * By selecting the tags, we can run any one of the scenario
 * @author Shweta
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions
	(	
		features= {".//Features/"},
		glue="com.automationpractice.StepDefination",
		dryRun=false,
		monochrome=true,
		plugin= {"pretty",
				"html:test-output", // this will create html report of cucumber features
				"json:test-output/cucumber.json" // this will create the json report of cucumber features
				}
		
		// To run the specific scenario, we can mentioned here tag like "@Scenario1,@Scenario3"
//		,tags= {"@Scenario2"} 		
	)
public class TestRun {
	
}
