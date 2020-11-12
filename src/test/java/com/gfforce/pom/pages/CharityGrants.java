package com.gfforce.pom.pages;

import com.gfforce.pom.common.BaseAction;
import com.gfforce.pom.common.ContextSteps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class CharityGrants extends BaseAction {
    WebDriver driver;

    public CharityGrants(ContextSteps contextSteps){
        super(contextSteps);
        driver = contextSteps.getDriver();
    }

    public void selectValuesFor(String optionsFor, Map<String, String> optionsToSelect) throws InterruptedException {
        for (String key: optionsToSelect.keySet()) {
            By locator = getLocatorFromInputValue("id", key);
            scrollToElement(locator, "click");
        }
    }

    public void clickToNavigate(String element){
        driver.findElement(getLocatorForField(element)).click();
    }

    public void selectOption(String option, String from) throws InterruptedException {
        By locator = getLocatorForField(from, option);
        scrollToElement(locator, "click");
    }

    public void entersValueInField(String value, String field){
        By locator = getLocatorForField(field);
        enterValue(locator,value,field);
    }

    public void selectValueFromDropdown(String value, String dropdownName){
        By locator = getLocatorForField(dropdownName);
        selectValue(locator, value);
    }

    public By getLocatorFromInputValue(String locator, String value) {
        By LOCATOR = null;
        if (locator.equals("id")) {
            LOCATOR = By.id(value);
        }
        return LOCATOR;
    }

    public void enterValuesForCostBreakdown(Map<String, List<String>> mapOfValues) throws InterruptedException {
        int i = 0;
        int j = 2;
        for (String key: mapOfValues.keySet() ) {
            System.out.println(mapOfValues.get(key));
            i++;
            driver.findElement(By.xpath("//div[@class='evidence-table ']/div/div[" + j + "]/div[1]/div/div/input")).sendKeys(key);
            driver.findElement(By.xpath("//div[@class='evidence-table ']/div/div[" + j + "]/div[2]/div/div/textarea")).sendKeys(mapOfValues.get(key).get(0));
            driver.findElement(By.xpath("//div[@class='evidence-table ']/div/div[" + j + "]/div[3]/div/div/input")).sendKeys(mapOfValues.get(key).get(1));
            if (!mapOfValues.get(key).get(2).equals("null")) {
                //driver.findElement(By.xpath("//div[@class='evidence-table ']/div/div[" + j + "]/div[4]/div/a/input")).sendKeys(mapOfValues.get(key).get(2));
                uploadADocument(By.xpath("//div[@class='evidence-table ']/div/div[" + j + "]/div[4]/div/a/input"), mapOfValues.get(key).get(2));
            }
            if(mapOfValues.keySet().size() > i){
                System.out.println("Adding another row");
                //driver.findElement(By.xpath("//*[text()='Add row']")).click();
                scrollToElement(By.xpath("//*[text()='Add row']"), "click");
            }
            j++;
        }
    }

    public void scrollToButtonToClick(String element, String action) throws InterruptedException {
        By locator = getLocatorForField(element);
        scrollToElement(locator, "click");
    }

    public void storeNominationID(){
        ContextSteps.contextValuesMap.put("nominationID", driver.findElement(By.partialLinkText("CGN-")).getText());
    }

    public void checkNominationDetailsAreDisplayed(){
        System.out.println("Verifying Nomination ID: " + ContextSteps.getContextValue("nominationID"));
        verifyDetailsAreDisplayed(ContextSteps.getContextValue("nominationID"));
    }

    public void clickReferenceNumber() throws InterruptedException {
        //clickElement(By.partialLinkText(partialText));
        String textToClick = ContextSteps.getContextValue("nominationID");
        scrollToElement(By.linkText(textToClick), "click");
    }

    public void verifyNominationDetails(Map<String, String> nominationDetails){
        for (String key: nominationDetails.keySet()) {
            String textOnPage = driver.findElement(getLocatorForField(key)).getText();
            Assert.assertEquals(nominationDetails.get(key), textOnPage);
        }
    }

    public void verifyNominationDetailsOfReferenceNumber(String referenceNumber, Map<String, String> details) {
        System.out.println("Verifying details of reference number: " + referenceNumber);
        List<WebElement> allDetails = driver.findElements(By.xpath("//*[@id='root']/div[3]/div[1]/ul/li"));

        for(int i=0; i<allDetails.size();i++){
            String refNumberOnPage = allDetails.get(i).findElement(By.xpath("./span[2]/a")).getText();
            if(referenceNumber.equals(refNumberOnPage)){
                String date = allDetails.get(i).findElement(By.xpath("./span")).getText();
                Assert.assertEquals(details.get("Date"), date);

                String charityName = allDetails.get(i).findElement(By.xpath("./span[3]/a")).getText();
                Assert.assertEquals(details.get("Charity Name"), charityName);

                String status = allDetails.get(i).findElement(By.xpath("./span[4]")).getText();
                Assert.assertEquals(details.get("Status"), status);
                break;
            }

        }
    }

    public void applyForFunding(String action, String name){
        driver.findElement(getLocatorForField(action,name)).click();
    }

    public void enterValueInFieldWithName(String value, String fieldName){
        enterValue(value, getLocatorForField(fieldName));
    }

    public void referenceNumberIsSaved(){

    }

    public By getLocatorForField(String fieldName) {
        By LOCATOR_VALUE = null;
        switch(fieldName) {
            case "Continue":
            case "Search":
            case "Submit":
                        LOCATOR_VALUE = By.xpath("//*[text()='" + fieldName +"']"); break;
            case "contact_name":
            case "contact_email":
            case "contact_tel":
            case "charity-search":
                LOCATOR_VALUE = By.xpath("//input[@id='" + fieldName +"']"); break;
            case "focus": LOCATOR_VALUE = By.xpath("//select[@id='q_id_2103']"); break;
            case "group": LOCATOR_VALUE = By.xpath("//select[@id='q_id_2104']"); break;
            case "Project title": LOCATOR_VALUE = By.xpath("//input[@id='q_id_2100']"); break;
            case "Project description": LOCATOR_VALUE = By.xpath("//textarea[@id='q_id_2102']"); break;
            case "Name": LOCATOR_VALUE = By.xpath("//*[@id='Your details']"); break;
            case "Employee Reference":
            case "Country group":
                LOCATOR_VALUE = By.xpath("//*[@id='"+ fieldName +"']"); break;
            case "Email": LOCATOR_VALUE = By.xpath("//*[@id='root']/div[3]/div[1]/form/div[1]/div/div[1]/div[2]/div/span"); break;
            case "List Employees": LOCATOR_VALUE = By.xpath("//textarea[@id='q_id_2001']"); break;
            default:
                System.out.println("Invalid case value: " + fieldName);
        }

        return LOCATOR_VALUE;
        }

    public static By getLocatorForField(String from, String option){
        By LOCATOR_VALUE = null;
        switch(from){
            case "results": LOCATOR_VALUE = By.xpath("//div[@class='get-charity-container']/div/div/ul/li[" + option +"]/a"); break;
            case "Start application":
            case "View application(s)":
                LOCATOR_VALUE = By.xpath("//*[text()='" + option + "']//following::a"); break;
            default:
                System.out.println("Invalid case value: " + from);
        }
        return LOCATOR_VALUE;
    }
    }
