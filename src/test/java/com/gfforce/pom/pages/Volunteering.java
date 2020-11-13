package com.gfforce.pom.pages;

import com.gfforce.pom.common.BaseAction;
import com.gfforce.pom.common.ContextSteps;
import com.gfforce.pom.locators.CommonLocators;
import com.gfforce.utilities.DateSelector;
import com.gfforce.utilities.PropertiesOperation;
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

    public void clickOnOpportunity() throws InterruptedException {
        //clickByLinkText(ContextSteps.getContextValues().get("volunteeringTitle"));
        clickByLinkText(PropertiesOperation.getRadicalValueBykey("volunteeringOpportunityName"));
    }

    public void opportunityDetailsAreDisplayed(){
        //verifyDetailsAreDisplayed(ContextSteps.getContextValues().get("volunteeringTitle"));
        verifyDetailsAreDisplayed(PropertiesOperation.getRadicalValueBykey("volunteeringOpportunityName"));
    }

    public void selectStartDate(String datePickerName) throws Exception {
        String date = PropertiesOperation.getRadicalValueBykey("volunteeringDate");
        System.out.println("Volunteering date: " + date + " for datepicker: " + datePickerName);
        selectDateFromDatePicker(date, datePickerName);
    }

    public void selectVGStartDate(String datePickerName) throws Exception {
        String date = PropertiesOperation.getRadicalValueBykey("vgDate");
        System.out.println("VG date: " + date + " for datepicker: " + datePickerName);
        selectDateFromDatePicker(date, datePickerName);
    }

    public void clickOnLink(String menuName) throws InterruptedException {
        clickByLinkText(menuName);
    }

    public void clickCreateOpportunity(String opportunityType){
        String link = driver.findElement(getLocatorForField(opportunityType)).getAttribute("href");
        driver.navigate().to(link);
    }

    public void selectValueWithIndex(String index, String value){
        driver.findElement(getLocatorForField(value, index)).click();
    }

    public void enterValueInEachField(Map<String, String> fieldValueMap){
        for (String key: fieldValueMap.keySet()) {
            System.out.println("Entering value: " + key + " in field: " + fieldValueMap.get(key));
            enterValue(key, getLocatorForField(fieldValueMap.get(key)));
            if(fieldValueMap.get(key).equals("title")){
                ContextSteps.contextValuesMap.put("volunteeringTitle", key);
            }
        }
    }

    public void clickAndSelectValue(String field, String value) throws InterruptedException {
        clickElement(getLocatorForField(field));
        selectValueFromList(value, field);
    }

    public void uploadADocument(String field, String filename){
        File f = new File("src/test/resources/documents/"+filename);
        String absolutePath = f.getAbsolutePath();
        System.out.println("Absolute  path: "  + absolutePath);
        driver.findElement(getLocatorForField(field)).sendKeys(absolutePath);
    }

    public void waitForOperationToComplete(String action){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='deleteFile_1']")));
    }

    public void clickAndSelectValuesFromMap(Map<String, String> fieldValueMap) throws InterruptedException {
        for (String key: fieldValueMap.keySet()   ) {
            clickAndSelectValue(key, fieldValueMap.get(key));
        }
    }

    public void verifyOpportunitiesAreDisplayed(){
        List<WebElement> allRows = driver.findElements(By.xpath("//*[@id=\"loc\"]/div[2]/table/tbody/tr"));
        Assert.assertTrue(allRows.size() > 0);
    }

    public void clickOnOpportunity(String opportunityName){
        driver.findElement(getLocatorForField("opportunity", opportunityName)).click();
    }

    public void acceptAllTermsAndConditions(String forAction) throws InterruptedException {
        if (forAction.equals("volunteering")){
            scrollToElement(By.xpath("//input[@id='checklist1']"), "click");
            scrollToElement(By.xpath("//input[@id='checklist2']"), "click");
            scrollToElement(By.xpath("//input[@id='checklist25']"), "click");
            scrollToElement(By.xpath("//input[@id='checklist26']"), "click");
            scrollToElement(By.xpath("//input[@id='checklist33']"), "click");
            } else if(forAction.equals("grants")){
            scrollToElement(By.xpath("//input[@id='checklist27']"), "click");
            scrollToElement(By.xpath("//input[@id='checklist28']"), "click");
            scrollToElement(By.xpath("//input[@id='checklist29']"), "click");
            scrollToElement(By.xpath("//input[@id='checklist34']"), "click");
        }

    }

    public void selectPreference(Map<String, String> userPreference){
        for (String key: userPreference.keySet()) {
            driver.findElement(By.xpath("//*[@id='"+userPreference.get(key)+"']")).click();
        }
    }

    public void editOpportunityByName(String action, String opportunityName){
        driver.findElement(getLocatorForField("Edit opportunity",opportunityName)).click();
    }
    public void editOpportunity(){
        //String opportunityName = ContextSteps.getContextValues().get("volunteeringTitle");
        String opportunityName = PropertiesOperation.getRadicalValueBykey("volunteeringOpportunityName");
        driver.findElement(getLocatorForField("Edit opportunity",opportunityName)).click();
    }

    public void clickApplyForGrant(){
        String opportunityName = ContextSteps.getContextValue("volunteeringTitle");
        driver.findElement(getLocatorForField("Apply for a grant",opportunityName)).click();
    }

    public void userSelects(String text){
        driver.findElement(By.xpath("//*[contains(text(), '"+ text +"')]//preceding-sibling::input")).click();
    }

    public void clickOnAButton(String buttonName) throws InterruptedException {
        clickElement(getLocatorForField(buttonName));
    }

    public void selectValueFromDropdown(String value, String dropdownName){
        selectValue(getLocatorForField(dropdownName), value);
    }

    public void enterValueInFieldWithName(String value, String fieldName){
        enterValue(value, getLocatorForField(fieldName));
    }

    public void enterTitle(){
        enterValue(PropertiesOperation.getRadicalValueBykey("volunteeringOpportunityName"),
                getLocatorForField("title"));
    }

    public void enterVGTitle(String fieldName){
        enterValue(PropertiesOperation.getRadicalValueBykey("VGTitle"),
                getLocatorForField("title"));
    }

    public void scrollToElementOnPage(String element, String action) throws InterruptedException {
        scrollToElement(getLocatorForField(element), action);
    }

    public void clickOnPopupButton(String buttonName) throws InterruptedException {
        Thread.sleep(2000);
        clickElement(By.id("continue-button"));
    }

    public void verifySearchResult(){
        verifyDetailsAreDisplayed("found");
    }

    public void verifyOptions(List<String> options) throws InterruptedException {
        for (String option: options) {
            clickByLinkText(option);
        }
    }

    public void verifyNavOptions(List<String> options) throws InterruptedException {
        for (String option: options) {
            clickByPartialLinkText(option);
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

    public static By getLocatorForField(String fieldName){
        By LOCATOR_VALUE = null;
        switch(fieldName) {
            case "Open opportunity":
            case "Individual":
            case "Reserved opportunity":
                LOCATOR_VALUE = By.xpath("//*[text()='" + fieldName + "']//following::a"); break;
            case "title":
            case "postcode":
            case "street":
            case "town":
            case "locality":
            case "county":
            case "contact_name":
            case "contact_tel":
            case "contact_email":
                LOCATOR_VALUE = By.xpath("//input[@id='" + fieldName +"']"); break;
            case "organisation": LOCATOR_VALUE = By.xpath("//input[@id='charity_name']"); break;
            case "Search": LOCATOR_VALUE = By.xpath("//input[@name='go']"); break;
            case "start_time":
            case "end_time":
            case "file":
            case "Confirm":
                LOCATOR_VALUE = By.xpath("//input[@name='"+fieldName+"']"); break;
            case "Physical location": LOCATOR_VALUE = By.xpath("//input[@id='physical_location1']"); break;
            case "manualAddressEntry": LOCATOR_VALUE = By.xpath("//a[@id='"+fieldName+"']"); break;
            case "country": LOCATOR_VALUE = By.xpath("//select[@id='"+fieldName+"']"); break;
            case "tags": LOCATOR_VALUE = By.xpath("//*[@id='oppTag_chzn']/ul/li/input"); break;
            case "theme": LOCATOR_VALUE = By.xpath("//*[@id='coding_1_chzn']/ul/li/input"); break;
            case "programme": LOCATOR_VALUE = By.xpath("//*[@id='coding_2_chzn']/ul/li/input"); break;
            case "colleagues": LOCATOR_VALUE = By.xpath("//*[@id='coding_3_chzn']/ul/li/input"); break;
            case "support": LOCATOR_VALUE = By.xpath("//*[@id='coding_5_chzn']/ul/li/input"); break;
            case "admin_note": LOCATOR_VALUE = By.xpath("//*[@id='"+ fieldName +"']"); break;
            case "accept guidelines": LOCATOR_VALUE = By.xpath("//*[@id='checklist30']"); break;
            case "accept covid guidelines": LOCATOR_VALUE = By.xpath("//*[@id='checklist32'] | //*[@id='QUE_33']"); break;
            case "accept policy": LOCATOR_VALUE = By.xpath("//*[@id='checklist31']"); break;
            case "Next": LOCATOR_VALUE = By.xpath("//*[@name='continue']"); break;
            case "Submit and Finish": LOCATOR_VALUE = By.xpath("//*[@value='Submit and Finish ']"); break;
            case "hashtag": LOCATOR_VALUE = By.xpath("//select[@id='cat']"); break;
            case "from_date": LOCATOR_VALUE = By.xpath("//input[@id='from_dt']"); break;
            case "to_date": LOCATOR_VALUE = By.xpath("//input[@id='to_dt']"); break;
            case "go": LOCATOR_VALUE = By.xpath("//input[@name='Go']"); break;
            case "Apply Now": LOCATOR_VALUE = By.xpath("//input[@name='apply']"); break;
            case "Update": LOCATOR_VALUE = By.xpath("//input[@value='"+fieldName+"']"); break;
            case "description": LOCATOR_VALUE = By.xpath("//*[@id='"+fieldName+"']"); break;
            case "Submit":  LOCATOR_VALUE = By.xpath("//input[@value='"+fieldName+"']"); break;
            case "Continue": LOCATOR_VALUE = By.xpath("//*[@id='continue-button'] | //*[@name='continue' and @type='button'] | //*[@name='continue' and @id='continue_button'] | //*[@name='continue' and @type='submit' and @value='Continue >']"); break;
            case "Breakdown": LOCATOR_VALUE = By.xpath("//textarea[@name='details']"); break;
            case "grants required": LOCATOR_VALUE = By.xpath("//input[@name='amount_raised_local']"); break;
            case "submenus": LOCATOR_VALUE = By.xpath("//*[@class='tabs col-sm-11']/ul/li");
            default:
                System.out.println("Invalid case value: " + fieldName);
        }
        return LOCATOR_VALUE;
        }

    public static By getLocatorForField(String fieldName, String valueForXpath){
        By LOCATOR_VALUE = null;
        switch(fieldName){
            case "results": LOCATOR_VALUE = By.xpath("//*[@id='getCharity']/div[" + valueForXpath + "]/a"); break;
            case "opportunity": LOCATOR_VALUE = By.linkText(valueForXpath); break;
            case "Edit opportunity":
            case "Apply for a grant":
                LOCATOR_VALUE = By.xpath("//*[contains(text(), '" + valueForXpath + "')]//following::a"); break;
            default:
                System.out.println("Invalid case value: " + fieldName);
        }
        return LOCATOR_VALUE;
    }



}
