package com.gfforce.pom.pages;

import com.gfforce.pom.common.BaseAction;
import com.gfforce.pom.common.ContextSteps;
import com.gfforce.pom.locators.CommonLocators;
import com.gfforce.utilities.DateSelector;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Volunteering extends BaseAction {
    WebDriver driver;
    
    String xpath ="";

    public Volunteering(ContextSteps contextSteps){
        super(contextSteps);
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

    public void enterValueInEachField(Map<String, String> fieldValueMap){
        for (String key: fieldValueMap.keySet()) {
            enterValue(key, fieldValueMap.get(key));
        }
    }

    public void clickAndSelectValue(String field, String value){
        clickElement(field);
        selectValueFromList(value, field);
    }

    public void uploadADocument(String field, String filename){
        File f = new File("src/test/resources/documents/"+filename);
        String absolutePath = f.getAbsolutePath();
        System.out.println("Absolute  path: "  + absolutePath);
        driver.findElement(CommonLocators.getLocatorForField(field)).sendKeys(absolutePath);
    }

    public void waitForOperationToComplete(String action){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='deleteFile_1']")));
    }

    public void clickAndSelectValuesFromMap(Map<String, String> fieldValueMap){
        for (String key: fieldValueMap.keySet()   ) {
            clickAndSelectValue(key, fieldValueMap.get(key));
        }
    }

    public void verifyOpportunitiesAreDisplayed(){
        List<WebElement> allRows = driver.findElements(By.xpath("//*[@id=\"loc\"]/div[2]/table/tbody/tr"));
        Assert.assertTrue(allRows.size() > 0);
    }

    public void verifyDetailsAreDisplayed(String textOnPage){
        //WebElement ele = driver.findElement(By.xpath("//*[contains(text(), '"+opportunityName+"')]"));
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), '"+textOnPage+"')]")));
    }

    public void clickOnOpportunity(String opportunityName){
        driver.findElement(CommonLocators.getLocatorForField("opportunity", opportunityName)).click();
    }

    public void scrollPageDown(int numberOfPages) throws InterruptedException {
        int page = 400;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + page*numberOfPages +")");
        Thread.sleep(3000);
    }

    public void acceptAllTermsAndConditions(){
        driver.findElement(By.xpath("//input[@id='checklist1']")).click();
        driver.findElement(By.xpath("//input[@id='checklist2']")).click();
        driver.findElement(By.xpath("//input[@id='checklist25']")).click();
        driver.findElement(By.xpath("//input[@id='checklist26']")).click();
    }

    public void selectPreference(Map<String, String> userPreference){
        for (String key: userPreference.keySet()) {
            driver.findElement(By.xpath("//*[@id='"+userPreference.get(key)+"']")).click();
        }

    }

    public void selectValueFromList(String inputValue, String listName){
        By locator = null;
        if (listName.contains("time")){
            locator = By.xpath("//ul[@class='ui-timepicker-list']/li");
        } else {
            switch (listName) {
                case "tags":
                    locator = By.xpath("//ul[@class='chzn-results']/li");
                    break;
                case "theme":
                    locator = By.xpath("//*[@id=\"coding_1_chzn\"]/div/ul/li");
                    break;
                case "programme":
                    locator = By.xpath("//*[@id=\"coding_2_chzn\"]/div/ul/li");
                    break;
                case "colleagues":
                    locator = By.xpath("//*[@id=\"coding_3_chzn\"]/div/ul/li");
                    break;
                case "support":
                    locator = By.xpath("//*[@id=\"coding_5_chzn\"]/div/ul/li");
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


//    public void closeAllBrowsers(){
//        ContextSteps.initialized = false;
//        driver.close();
//    }

}
