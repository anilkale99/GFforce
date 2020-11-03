package com.gfforce.pom.locators;

import org.openqa.selenium.By;

public class CommonLocators {

    public static final By VOLUNTEERING_LINK = By.linkText("Volunteering");
    public static final By SUBMENU_PATH = By.xpath("//*[@class='tabs col-sm-11']/ul/li");

    public static By getSubMenuLocator(String subMenuName) {
        return By.linkText(subMenuName);
    }

    public static By getLocatorForField(String fieldName){
        By LOCATOR_VALUE = null;
        switch(fieldName){
            case "username": LOCATOR_VALUE = By.xpath("//input[@id='username']"); break;
            case "password": LOCATOR_VALUE = By.xpath("//input[@id='password']"); break;
            case "sign-in": LOCATOR_VALUE = By.xpath("//input[@value='Sign in']"); break;
            case "postcode":
            case "street":
            case "town":
            case "locality":
            case "county":
                            LOCATOR_VALUE = By.xpath("//input[@id='"+fieldName+"']"); break;
            case "hashtag": LOCATOR_VALUE = By.xpath("//select[@id='cat']"); break;
            case "from_date": LOCATOR_VALUE = By.xpath("//input[@id='from_dt']"); break;
            case "to_date": LOCATOR_VALUE = By.xpath("//input[@id='to_dt']"); break;
            case "go": LOCATOR_VALUE = By.xpath("//input[@name='Go']"); break;
            case "sign-out": LOCATOR_VALUE = By.linkText("Sign out"); break;
            case "Open opportunity":
            case "Reserved opportunity":
            case "Individual":
                LOCATOR_VALUE = By.xpath("//*[text()='" + fieldName + "']//following::a"); break;
            case "title": LOCATOR_VALUE = By.xpath("//input[@id='title']"); break;
            case "organisation": LOCATOR_VALUE = By.xpath("//input[@id='charity_name']"); break;
            case "Search": LOCATOR_VALUE = By.xpath("//input[@name='go']"); break;
            case "start_time":
            case "end_time":
                LOCATOR_VALUE = By.xpath("//input[@name='"+fieldName+"']"); break;
            case "Physical location": LOCATOR_VALUE = By.xpath("//input[@id='physical_location1']"); break;
            case "Virtual volunteering": LOCATOR_VALUE = By.xpath("//input[@id='physical_location2']"); break;
            case "tags": LOCATOR_VALUE = By.xpath("//*[@id='oppTag_chzn']/ul/li/input"); break;
            case "manualAddressEntry": LOCATOR_VALUE = By.xpath("//a[@id='"+fieldName+"']"); break;
            case "country": LOCATOR_VALUE = By.xpath("//select[@id='"+fieldName+"']"); break;
            default:
                System.out.println("Invalid case value: " + fieldName);
        }
        return LOCATOR_VALUE;
    }

    public static By getLocatorForField(String fieldName, String valueForXpath){
        By LOCATOR_VALUE = null;
        switch(fieldName){
            case "results": LOCATOR_VALUE = By.xpath("//*[@id='getCharity']/div[" + valueForXpath + "]/a"); break;
            default:
                System.out.println("Invalid case value: " + fieldName);
        }
        return LOCATOR_VALUE;
    }
}
