package com.gfforce.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features={"src/test/resources/com/gfforce/barclays/VolunteeringGrants.feature"},
		glue={"com.gfforce.steps"},
		monochrome=true,
		plugin={"pretty",
				"html:target/cucumber-htmlreport",
				"json:target/json-report/cucumber-reportVolunteeringGrant.json"
		}
		//,tags = {"@create"}

		
		)
public class RunVolunteeringGrantsTest {

}
