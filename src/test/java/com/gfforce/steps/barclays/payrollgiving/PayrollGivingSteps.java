package com.gfforce.steps.barclays.payrollgiving;

import com.gfforce.pom.locators.CommonLocators;
import com.gfforce.utilities.TableUtilites;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.gfforce.pom.common.ContextSteps;
import com.gfforce.pom.pages.PayrollGiving;

import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PayrollGivingSteps extends PayrollGiving{
	
	public PayrollGivingSteps(ContextSteps contextSteps) {
        super(contextSteps);
    }
	
	
	
	
	@When("User enters other amount value {string} in {string} field")
    public void enterOtherAmountValueInfield(String value, String fieldName){
		System.out.println("Entering value: " + value + " in field: " + fieldName);
		WebElement field = driver.findElement(this.getLocatorForField(fieldName));
		field.clear();
		field.sendKeys(value);
    }

	@When("User close {string} having {string} as title")
    public void closeDialogTitlebar(String value, String fieldName){
		driver.findElement(this.getLocatorForField(fieldName)).click();
	}

	@When("User enters email value {string} in {string} field")
	public void enterEmailValueInfield(String value, String fieldName){
		System.out.println("Entering value: " + value + " in field: " + fieldName);
		WebElement field = driver.findElement(this.getLocatorForField(fieldName));
		field.clear();
		field.sendKeys(value);
	}

	@When("User enters search value {string} in {string} search donation")
	public void enterSearchValueInfield(String value, String fieldName){
		System.out.println("Entering value: " + value + " in field: " + fieldName);
		WebElement field = driver.findElement(this.getLocatorForField(fieldName));
		field.clear();
		field.sendKeys(value);
	}

	@When("User select Amount value {string} from {string} dropdown")
	public void enterSelectAmountValueIndropdown(String value, String fieldName){
		System.out.println("Entering value: " + value + " in field: " + fieldName);
		System.out.println("Selecting value: " + value + " from dropdown: " + fieldName);
		Select dd = new Select(driver.findElement(this.getLocatorForField(fieldName)));
		dd.selectByVisibleText(value);
	}
	@When("User select Include value {string} from {string} dropdown")
	public void enterSelectIncludeValueIndropdown(String value, String fieldName){
		System.out.println("Entering value: " + value + " in field: " + fieldName);
		System.out.println("Selecting value: " + value + " from dropdown: " + fieldName);
		Select dd = new Select(driver.findElement(this.getLocatorForField(fieldName)));
		dd.selectByVisibleText(value);
	}

	@When("User on PG validate your instructions list")
	public void user_on_PG_validate_your_instructions_list(List<String> applicationList){
		TableUtilites table = new TableUtilites(1);
		List<String> actValues = table.getTableColumnValuesByIndex(driver, 4);
		for (String expVal : applicationList) {
			for(int i = 0; i<actValues.size();i++){
				if(actValues.get(i).contains(expVal)){
					System.out.println("Value "+ expVal +" Present in Matched list");
					break;
				}else{
					if(i==(actValues.size()-1)){
						Assert.assertTrue(false);
					}
				}

			}
		}
	}


	@And("User on PG clicks on {string}")
	public void userOnPGClicksOn(String fieldName) {
		if(fieldName.equals("Continue")) {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(this.getLocatorForField("modify the existing instruction"))).click();
			} catch (Exception e) {
			}
		}
		driver.findElement(CommonLocators.getLocatorForField(fieldName)).click();
	}

	@And("User on PG clicks on element {string}")
	public void userOnPGClicksOnElement(String fieldName) throws InterruptedException {
		if(fieldName.equals("Continue")) {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(this.getLocatorForField("modify the existing instruction"))).click();
			} catch (Exception e) {
			}
		}
		driver.findElement(this.getLocatorForField(fieldName)).click();
	}
}
