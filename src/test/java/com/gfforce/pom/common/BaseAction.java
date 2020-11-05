package com.gfforce.pom.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gfforce.pom.locators.CommonLocators;

public class BaseAction {
	
	WebDriver driver;

	public BaseAction(ContextSteps contextSteps) {
		driver = contextSteps.getDriver();

	}

	public void clickElement(String fieldName) {
		driver.findElement(CommonLocators.getLocatorForField(fieldName)).click();
	}

	public void enterValue(String value, String fieldName) {
		System.out.println("Entering value: " + value + " in field: " + fieldName);
		WebElement field = driver.findElement(CommonLocators.getLocatorForField(fieldName));
		field.clear();
		field.sendKeys(value);
	}

}
