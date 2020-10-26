package com.gfforce.steps.barclays.volunteering;

import org.openqa.selenium.WebDriver;

import com.gfforce.pom.common.ContextSteps;

import io.cucumber.java.en.When;

public class CreateOpportunitySteps {
	
	private ContextSteps contextSteps;
	WebDriver driver;
	
	public CreateOpportunitySteps(ContextSteps contextSteps) throws Exception {
		contextSteps.setUp();
		driver = contextSteps.getDriver();
	}
	
	@When("^Create Oportunity Steps$")
	public void createOpportunity(){
		System.out.println("CreateOpportunitySteps ");
	}


}
