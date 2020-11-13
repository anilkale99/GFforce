package com.gfforce.pom.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gfforce.pom.common.BaseAction;
import com.gfforce.pom.common.ContextSteps;

public class MatchedFundRaising extends BaseAction{
	public WebDriver driver;
	
	String eventNameLoc= "";
    
    public MatchedFundRaising(ContextSteps contextSteps){
        super(contextSteps);
        driver = contextSteps.getDriver();
    }
    
    public static By getLocatorForField(String fieldName){
        By LOCATOR_VALUE = null;
        switch(fieldName){
            case "event_name": LOCATOR_VALUE = By.xpath("//input[@id='event_name']"); break;
            case "coding_value": LOCATOR_VALUE = By.xpath("//input[@value='Select coding to add']"); break;
            case "details": LOCATOR_VALUE = By.xpath("//textarea[@id='details']"); break;
            case "Confirm": LOCATOR_VALUE = By.xpath("//input[@name='Confirm']"); break;
            default:
                System.out.println("Invalid case value: " + fieldName);
        }
        return LOCATOR_VALUE;
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
