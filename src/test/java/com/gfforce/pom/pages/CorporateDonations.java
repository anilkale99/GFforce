package com.gfforce.pom.pages;

import com.gfforce.pom.common.BaseAction;
import com.gfforce.pom.common.ContextSteps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class CorporateDonations extends BaseAction {
    WebDriver driver;
    public CorporateDonations(ContextSteps contextSteps){
        super(contextSteps);
        driver = contextSteps.getDriver();
    }

    public void clickToSelectOption(String optionText){
        try {
            driver.findElement(By.xpath("//*[contains(text(), '" + optionText + "')]//preceding-sibling::input")).click();
        } catch (Exception e){
            driver.findElement(getLocatorFor(optionText)).click();
        }
    }
    public void clickToSelectRadio(String optionText){
        driver.findElement(getLocatorFor(optionText)).click();
    }


    public void enterValueInField(String field, String value) throws InterruptedException {
        Thread.sleep(1500);
        scrollToElement(getLocatorFor(field),"");
        enterValue(value, getLocatorFor(field));
    }

    public void clickOnButton(String buttonName){
        clickElement(getLocatorFor(buttonName));
    }

    public void selectValueFromResult(String selectFrom, String index){
        driver.findElement(getLocatorFor(selectFrom,index)).click();
    }

    public void enterDonationAmount(String value){
        By locator = getLocatorFor("amount_donated_local");
        WebElement ele = driver.findElement(locator);
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(ele));
        enterValue(value, locator);
    }

    public void storeCDReferenceNum(){
        ContextSteps.contextValuesMap.put("cdReference", driver.findElement(By.partialLinkText("CD")).getText());
    }

    public void verifyRequestIsPresent(){
        String referenceID = ContextSteps.getContextValue("cdReference");
        verifyDetailsAreDisplayed(referenceID);
    }

    public void clickOnReferenceID() throws InterruptedException {
        String referenceID = ContextSteps.getContextValue("cdReference");
        clickByPartialLinkText(referenceID);
    }

    public void verifyCDDetails(Map<String, String> cdDetails){
        for (String key: cdDetails.keySet()) {
            String textOnPage = driver.findElement(getLocatorFor(key)).getText();
            Assert.assertEquals(cdDetails.get(key), textOnPage.trim());
        }
    }

    public static By getLocatorFor(String inputVal){
        By locator = null;
        switch(inputVal){
            case "charity_name":
            case "amount_donated_local":
            case "details":
                locator = By.xpath("//*[@id='" + inputVal +"']"); break;
            case "Search": locator = By.xpath("//*[@value='" + inputVal +"']"); break;
            case "description": locator = By.xpath("//*[@name='" + inputVal +"']"); break;
            case "Continue": locator = By.xpath("//*[@id=\"content\"]/div[2]/form/div[11]/div/div/input[2] | //*[@id=\"content\"]/div[2]/form/div[3]/div/div/input[2]"); break;
            case "Submit": locator = By.xpath("//*[@id=\"content\"]/div[2]/form/div/div[8]/div/div/input[2]"); break;
            case "It will be paid centrally": locator = By.xpath("//*[@id='paidHeadOffice']"); break;
            case "You will pay this locally": locator = By.xpath("//*[@id='paidLocally']"); break;
            case "Name": locator = By.xpath("//*[@id=\"content\"]/div[2]/form/div[4]/div/div/div[1]/div/span[1]"); break;
            case "Email": locator = By.xpath("//*[@id=\"content\"]/div[2]/form/div[4]/div/div/div[1]/div/span[2]"); break;
            case "Employee Reference": locator = By.xpath("//*[@id=\"content\"]/div[2]/form/div[4]/div/div/div[2]/div[1]/span[1]"); break;
            case "Country group": locator = By.xpath("//*[@id=\"content\"]/div[2]/form/div[4]/div/div/div[2]/div[1]/span[2]"); break;
            default:
                System.out.println("Invalid case to find locator in CorporateDonations.java: " + inputVal);
        }
        return locator;
    }

    public static By getLocatorFor(String field, String inputVal){
        By locator = null;
        switch(field){
            case "results": locator = By.xpath("//*[@id='getCharity']/div[" + inputVal + "]/a"); break;
        }
        return locator;
    }

}
