package com.gfforce.steps.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.gfforce.pom.common.BasePage;
import com.gfforce.pom.common.ContextSteps;
import com.gfforce.pom.common.TestingBase;
import io.cucumber.java.en.Given;

public class LoginPageSteps {

	private ContextSteps contextSteps;
	WebDriver driver;

	// PicoContainer injects class ContextSteps
	public LoginPageSteps(ContextSteps contextSteps) throws Exception {
		contextSteps.setUp();
		driver = contextSteps.getDriver();
	}

	@Given("Launch gfforce application")
	public void launch_gfforce_application() {
		System.out.println("browser launched.");
	}

	public void enterBRID() {

	}

	@Given("^User enter username$")
	public void user_enter_username() {

	}

}
