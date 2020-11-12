package com.gfforce.pom.locators;

import org.openqa.selenium.By;

public class CommonLocators {

    public static By getLocatorForField(String fieldName){
        By LOCATOR_VALUE = null;
        switch(fieldName){
            case "username":
            case "password":
            case "uploadDocs":
                LOCATOR_VALUE = By.xpath("//input[@id='"+fieldName+"']"); break;
            case "sign-in": LOCATOR_VALUE = By.xpath("//input[@value='Sign in']"); break;
            case "Continue": LOCATOR_VALUE = By.xpath("//*[@name='continue' and @type='button'] | //*[@name='continue' and @id='continue_button'] | //*[@name='continue' and @type='submit' and @value='Continue >']"); break;
            case "sign-out": LOCATOR_VALUE = By.linkText("Sign out"); break;
            case "Virtual volunteering": LOCATOR_VALUE = By.xpath("//input[@id='physical_location2']"); break;
            case "Back to your homepage": LOCATOR_VALUE = By.xpath("//a[text()='Back to your homepage']"); break;
            case "Reserved opportunity": LOCATOR_VALUE = By.xpath("//input[@id='physical_location2']"); break;
            default:
                System.out.println("Invalid case value: " + fieldName);
        }
        return LOCATOR_VALUE;
    }

}
