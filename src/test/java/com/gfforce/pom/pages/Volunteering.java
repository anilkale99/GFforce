package com.gfforce.pom.pages;

import com.gfforce.pom.common.ContextSteps;
import com.gfforce.pom.locators.CommonLocators;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Volunteering {
    WebDriver driver;

    public Volunteering(ContextSteps contextSteps){
        driver = contextSteps.getDriver();
    }

    public void clickVolunteering(){
        driver.findElement(CommonLocators.VOLUNTEERING_LINK).click();
    }

    public void validateSubmenu(String subMenu, List<String> items){
        int i=0;
        List<WebElement> subMenuItemsOnPage = driver.findElements(CommonLocators.SUBMENU_PATH);
        for (WebElement subMenuItem : subMenuItemsOnPage) {
            System.out.println("Asserting " + subMenuItem.getText() + " and " + items.get(i));
            Assert.assertEquals(subMenuItem.getText(), items.get(i++));
        }
    }

    public void clickOnSubMenu(String menuName){
        driver.findElement((CommonLocators.getSubMenuLocator(menuName))).click();
    }

    public void enterValue(String value, String fieldName){
        System.out.println("Entering value: " + value + " in field: " + fieldName);
        WebElement field = driver.findElement(CommonLocators.getLocatorForField(fieldName));
        field.clear();
        field.sendKeys(value);
    }

    public void selectValue(String value, String dropdownName){
        System.out.println("Selecting value: " + value + " from dropdown: " + dropdownName);
        Select dd = new Select(driver.findElement(CommonLocators.getLocatorForField(dropdownName)));
        dd.selectByVisibleText(value);
    }

    public void clickButton(String fieldName){
        driver.findElement(CommonLocators.getLocatorForField(fieldName)).click();
    }
}
