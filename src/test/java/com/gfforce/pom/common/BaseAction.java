package com.gfforce.pom.common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gfforce.pom.locators.CommonLocators;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

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

	public void enterValue(By locator, String value, String fieldName) {
		System.out.println("Entering value: " + value + " in field: " + fieldName);
		WebElement field = driver.findElement(locator);
		field.clear();
		field.sendKeys(value);
	}

	public void clickElement(By locator) {
		driver.findElement(locator).click();
	}

	public void scrollToElement(String element, String action) throws InterruptedException {
		WebElement ele = driver.findElement(CommonLocators.getLocatorForField(element));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		Thread.sleep(2000);
		if (action.equals("click")){
			ele.click();
		}
	}

	public void scrollToElement(By locator, String action) throws InterruptedException {
		Thread.sleep(2000);
		WebElement ele = driver.findElement(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		Thread.sleep(1000);
		if (action.equals("click")){
			ele.click();
		}
	}

	public void selectValue(String value, String dropdownName){
		System.out.println("Selecting value: " + value + " from dropdown: " + dropdownName);
		Select dd = new Select(driver.findElement(CommonLocators.getLocatorForField(dropdownName)));
		dd.selectByVisibleText(value);
	}

	public void selectValue(By locator, String value){
		System.out.println("Selecting value: " + value);
		Select dd = new Select(driver.findElement(locator));
		dd.selectByVisibleText(value);
	}

	public void uploadADocument(By locator, String filename){
		File f = new File("src/test/resources/documents/"+filename);
		String absolutePath = f.getAbsolutePath();
		System.out.println("Absolute  path: "  + absolutePath);
		driver.findElement(locator).sendKeys(absolutePath);
	}

	public void verifyDetailsAreDisplayed(String textOnPage){
		//WebElement ele = driver.findElement(By.xpath("//*[contains(text(), '"+opportunityName+"')]"));
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), '"+textOnPage+"')]")));
	}

}
