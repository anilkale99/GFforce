package com.gfforce.steps.barclays.matchedfundraising;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.gfforce.pom.common.ContextSteps;
import com.gfforce.pom.locators.CommonLocators;
import com.gfforce.pom.pages.MatchedFundRaising;

import io.cucumber.java.en.When;

public class MatchedFundRaisingSteps extends MatchedFundRaising{
	
	public MatchedFundRaisingSteps(ContextSteps contextSteps) {
        super(contextSteps);
    }
	
	public static By getLocatorForField(String fieldName){
        By LOCATOR_VALUE = null;
        switch(fieldName){
            case "event_name": LOCATOR_VALUE = By.xpath("//input[@id='event_name']"); break;
            case "coding_value": LOCATOR_VALUE = By.xpath("//input[@value='Select coding to add']"); break;
            default:
                System.out.println("Invalid case value: " + fieldName);
        }
        return LOCATOR_VALUE;
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
	
	public void selectValueFromList(String inputValue, String listName){
        By locator = null;
        if (listName.contains("time")){
            locator = By.xpath("//ul[@class='ui-timepicker-list']/li");
        } else {
            switch (listName) {
                case "coding list":
                    locator = By.xpath("//*[@id=\"coding_4_chzn\"]/div/ul/li");
                    break;
                default:
                    System.out.println("Invalid locator or value provided: " + listName);
            }
        }
        List<WebElement> allTimes = driver.findElements(locator);
        for (WebElement ele: allTimes) {
            if(ele.getText().equals(inputValue)){
                ele.click();
            }
        }
    }
	

}
