package com.gfforce.steps.barclays.matchedfundraising;

import java.util.List;

import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.gfforce.pom.common.ContextSteps;
import com.gfforce.pom.locators.CommonLocators;
import com.gfforce.pom.pages.MatchedFundRaising;
import com.gfforce.utilities.TableUtilites;
import com.google.common.collect.Table;

import io.cucumber.java.en.When;

public class MatchedFundRaisingSteps extends MatchedFundRaising{
	
	public MatchedFundRaisingSteps(ContextSteps contextSteps) {
        super(contextSteps);
    }
	
	public By getEventLoc(String eventName){
		return By.xpath("//a[contains(text(),'"+eventName+"')]");
	}
	
	@When("User enters MF event Name value {string} in {string} field")
    public void enterValueInfield(String value, String fieldName){
		System.out.println("Entering value: " + value + " in field: " + fieldName);
		WebElement field = driver.findElement(this.getLocatorForField(fieldName));
		field.clear();
		field.sendKeys(value);
    }
	
	@When("User clicks on Select Coding list to select value")
    public void enterValueInfield(List<String> subMenuOptions){
		driver.findElement(this.getLocatorForField("coding_value")).click();;
        selectValueFromList("Yes", "coding list");
	}
	
	@When("User clicks {string} application from Your Applications list")
    public void enterValueInfield(String applicationName){
		driver.findElement(this.getEventLoc(applicationName)).click();;
    }
    
    
	
	
	
	@When("User validate matched fund raising application list")
    public void user_validate_matched_fund_raising_application_list(List<String> applicationList){
		TableUtilites table = new TableUtilites(1);
		List<String> actValues = table.getTableColumnValuesByIndex(driver, 2);
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


	@And("User on MF enters value {string} in {string} field")
	public void userOnMFEntersValueInField(String value, String fieldName) {
		enterValue(value, this.getLocatorForField(fieldName));
	}

	@And("User on MF click element {string}")
	public void userOnMFClickElement(String fieldName) throws InterruptedException {
		clickElement(this.getLocatorForField(fieldName));

	}
}
