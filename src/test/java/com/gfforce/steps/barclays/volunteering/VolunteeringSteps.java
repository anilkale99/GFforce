package com.gfforce.steps.barclays.volunteering;

import com.gfforce.pom.common.ContextSteps;
import com.gfforce.pom.pages.Volunteering;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class VolunteeringSteps extends Volunteering {

    public VolunteeringSteps(ContextSteps contextSteps) {
        super(contextSteps);
    }

    @When("User clicks on {string} menu")
    public void clickSubMenu(String menu){
        clickOnLink(menu);
    }

    @Then("Visible submenu for \"([^\"]*)\" is$")
    public void verifySubmenu(String subMenuName, List<String> subMenuItems){
        validateSubmenu(subMenuName, subMenuItems);
    }

    @When("User clicks on {string} sub-menu")
    public void clickOnSubMenuItem(String subMenuName){
        clickOnLink(subMenuName);
    }


    @When("User selects value {string} from {string} dropdown")
    public void selectValueFromDropdown(String value, String dropdownName){
        selectValue(value, dropdownName);
    }

    
    @When("Visible options for {string} are")
    public void subMenuOptions(String subMenuName, List<String> subMenuOptions){
        validateSubMenuOptions(subMenuName, subMenuOptions);
    }

    @When("User clicks to create {string}")
    public void userCreatesOpportunity(String opportunityType){
        clickCreateOpportunity(opportunityType);
    }

    @When("User selects option {string} from displayed {string}")
    public void selectValueFromResult(String index, String value){
        selectValueWithIndex(index, value);
    }

    @When("User selects {string} from {string}")
    public void userSelectsDate(String date, String datePicker){
        selectDateFromDatePicker(date, datePicker);
    }

    @When("Visible options are")
    public void subMenuOptions(List<String> subMenuOptions) {
        validateSubMenuOptions(subMenuOptions);
    }

    @When("User selects value {string} from {string} list")
    public void selectTime(String inputValue, String listName) {
        selectValueFromList(inputValue, listName);
    }

    @When("User enters value in field")
    public void enterValueInField(Map<String, String> fieldValueMap) {
        enterValueInEachField(fieldValueMap);
    }

    @When("User clicks on {string} and selects value {string}")
    public void UserClickAndSelectValue(String field, String value) {
        clickAndSelectValue(field, value);
    }

    @When("User clicks on {string} to upload {string}")
    public void userUploadsDocument(String locator, String fileName) {
        uploadADocument(locator,fileName);
    }

    @When("User waits for {string} operation to complete")
    public void userWaitsForOperation(String action) {
        waitForOperationToComplete(action);
    }

    @When("User clicks on list to select value")
    public void userClickOnListToSelectValue(Map<String, String> fieldValueMap) {
        clickAndSelectValuesFromMap(fieldValueMap);
    }

    @When("User clicks on {string} opportunity")
    public void userClickOnListToSelectValue(String opportunityName) {
        clickOnOpportunity(opportunityName);
    }

    @When("All open opportunities are displayed")
    public void allOpenOpportunitiesAreDisplayed() {
        verifyOpportunitiesAreDisplayed();
    }

    @When("{string} details are displayed")
    public void detailsAreDisplayed(String textOnPage) {
        verifyDetailsAreDisplayed(textOnPage);
    }

    @When("User scrolls down {int} page")
    public void userScrollsPageDown(int numberOfPages) throws InterruptedException {
        scrollPageDown(numberOfPages);
    }

    @When("User accepts all terms and conditions for {string}")
    public void userAcceptsAllTerms(String forAction) {
        acceptAllTermsAndConditions(forAction);
    }

    @When("User selects preference")
    public void userSelectsPreference(Map<String, String> userPreference) {
        selectPreference(userPreference);
    }

    @When("User clicks on {string} for {string}")
    public void userEditsOpportunity(String action, String name) {
        editOpportunity(action, name);
    }

    @When("User scrolls to {string} to {string}")
    public void userScrollsToElement(String element, String action) throws InterruptedException {
        scrollToElement(element, action);
    }

    @When("{string} is displayed")
    public void messageIsDisplayed(String textOnPage) {
        verifyDetailsAreDisplayed(textOnPage);
    }

    @When("User selects {string}")
    public void userSelection(String text) {
        userSelects(text);
    }

    @When("User clicks on link {string}")
    public void userClicksOnLink(String linkText) {
        clickOnLink(linkText);
    }


//    @Then("close browser")
//    public void closeBrowser(){
//        closeAllBrowsers();
//    }

}
