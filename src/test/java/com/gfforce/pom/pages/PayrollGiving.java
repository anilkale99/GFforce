package com.gfforce.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.gfforce.pom.common.BaseAction;
import com.gfforce.pom.common.ContextSteps;

public class PayrollGiving extends BaseAction {
	
	public WebDriver driver;

    public PayrollGiving(ContextSteps contextSteps){
        super(contextSteps);
        driver = contextSteps.getDriver();
    }
    
    public static By getLocatorForField(String fieldName){
        By LOCATOR_VALUE = null;
        switch(fieldName){
            case "other_amount": LOCATOR_VALUE = By.xpath("//input[@id='"+fieldName+"']"); break;
            case "What is a My Giving Account?": LOCATOR_VALUE = By.xpath("//span[contains(text(),'"+fieldName+"')]/../button"); break;
            case "personal_email": LOCATOR_VALUE = By.xpath("//input[@id='"+fieldName+"']"); break;
            case "Search": LOCATOR_VALUE = By.xpath("//input[@value='"+fieldName+"'] "); break;
            case "search": LOCATOR_VALUE = By.xpath("//input[@id='"+fieldName+"'] "); break;
            case "Go": LOCATOR_VALUE = By.xpath("//input[@name='"+fieldName+"'] "); break;
            case "within": LOCATOR_VALUE = By.xpath("//select[@id='"+fieldName+"']"); break;
            case "include": LOCATOR_VALUE = By.xpath("//select[@id='"+fieldName+"']"); break;
            case "modify the existing instruction": LOCATOR_VALUE = By.xpath("//a[contains(text(),'"+fieldName+"')]"); break;
            case "Sign up": LOCATOR_VALUE = By.xpath("//a[contains(text(),'"+fieldName+"')]"); break;
            case "is_participate": LOCATOR_VALUE = By.xpath("//input[@id='"+fieldName+"']"); break;
            case "pref_contact_by_text": LOCATOR_VALUE = By.xpath("//input[@id='"+fieldName+"']"); break;
            case "Cancel instruction": LOCATOR_VALUE = By.xpath("//a[@title='"+fieldName+"']"); break;
            case "Modify instruction": LOCATOR_VALUE = By.xpath("//a[@title='"+fieldName+"']"); break;
            case "Continue": LOCATOR_VALUE = By.xpath("//*[@name='continue' and @type='button'] | //*[@name='continue' and @id='continue_button'] | //*[@name='continue' and @type='submit' and @value='Continue >'] | //*[@type='submit' and @value='Continue']"); break;
            case "Submit your instruction": LOCATOR_VALUE = By.xpath("//input[@value='"+fieldName+"'] "); break;
            case "Confirm": LOCATOR_VALUE = By.xpath("//input[@name='"+fieldName+"'] "); break;

            default:
                System.out.println("Invalid case value: " + fieldName);
        }
        return LOCATOR_VALUE;
    }



}
