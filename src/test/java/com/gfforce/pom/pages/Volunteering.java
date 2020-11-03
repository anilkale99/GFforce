package com.gfforce.pom.pages;

import com.gfforce.pom.common.ContextSteps;
import com.gfforce.pom.locators.CommonLocators;
import com.gfforce.utilities.DateSelector;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Volunteering {
    WebDriver driver;
    
    String xpath ="";
    

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

    

    public void selectValue(String value, String dropdownName){
        System.out.println("Selecting value: " + value + " from dropdown: " + dropdownName);
        Select dd = new Select(driver.findElement(CommonLocators.getLocatorForField(dropdownName)));
        dd.selectByVisibleText(value);
    }

   
    public void validateSubMenuOptions(String subMenuName, List<String> subMenuOptions){
        for (String optionName: subMenuOptions) {
            List<WebElement> list = driver.findElements(By.xpath("//*[text()='" + optionName + "']"));
            Assert.assertTrue("Not found option: "+optionName+" under "+subMenuName, list.size() == 1);
        }
    }


    public void validateSubMenuOptions(List<String> subMenuOptions){
        for (String optionName: subMenuOptions) {
            List<WebElement> list = driver.findElements(By.xpath("//*[text()='" + optionName + "']"));
            Assert.assertTrue("Not found option: "+ optionName, list.size() == 1);
        }
    }

    public void clickCreateOpportunity(String opportunityType){
        String link = driver.findElement(CommonLocators.getLocatorForField(opportunityType)).getAttribute("href");
        driver.navigate().to(link);
    }

    public void selectValueWithIndex(String index, String value){
        driver.findElement(CommonLocators.getLocatorForField(value, index)).click();
    }

    public void selectDateFromDatePicker(String date, String datePicker){
        DateSelector.selectDate(driver, date, datePicker);
    }

    public void selectValueFromList(String inputValue, String listName){
        By locator = null;
        if (listName.equals("time")){
            locator = By.xpath("//ul[@class='ui-timepicker-list']/li");
        } else if(listName.equals("tags")){
            locator = By.xpath("//ul[@class='chzn-results']/li");
        }
        List<WebElement> allTimes = driver.findElements(locator);
        for (WebElement ele: allTimes) {
            if(ele.getText().equals(inputValue)){
                ele.click();
            }
        }
    }


//    public void closeAllBrowsers(){
//        ContextSteps.initialized = false;
//        driver.close();
//    }

}
