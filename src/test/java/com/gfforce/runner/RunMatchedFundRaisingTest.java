package com.gfforce.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features={"src/test/resources/com/gfforce/barclays/MatchedFundRaising.feature"},
		glue={"com.gfforce.steps"},
		monochrome=true,
		plugin={"pretty",
				"html:target/cucumber-htmlreport",
				"json:target/json-report/cucumber-reportMatchedFundRaising.json"
		}

		
		)
public class RunMatchedFundRaisingTest {

}
