package com.gfforce.steps.common;

import org.openqa.selenium.WebDriver;

import com.gfforce.pom.common.ContextSteps;

import io.cucumber.java.en.When;

public class FirstLevelNavSteps {
	
	private ContextSteps contextSteps;
	WebDriver driver;
	
	// PicoContainer injects class ContextSteps
   public FirstLevelNavSteps (ContextSteps contextSteps) {
      this.contextSteps = contextSteps;
   }
   
   
   @When("^User do navigation$")
   public void User_do_navigation(){
	   
   }

}
