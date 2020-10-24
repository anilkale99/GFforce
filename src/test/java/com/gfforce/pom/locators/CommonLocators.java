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
            case "postcode": LOCATOR_VALUE = By.xpath("//input[@id='postcode']"); break;
            case "hashtag": LOCATOR_VALUE = By.xpath("//select[@id='cat']"); break;
            case "from_date": LOCATOR_VALUE = By.xpath("//input[@id='from_dt']"); break;
            case "to_date": LOCATOR_VALUE = By.xpath("//input[@id='to_dt']"); break;
            case "go": LOCATOR_VALUE = By.xpath("//input[@name='Go']"); break;
            default:
                System.out.println("Invalid case value: " + fieldName);
        }
        return LOCATOR_VALUE;
    }
}
