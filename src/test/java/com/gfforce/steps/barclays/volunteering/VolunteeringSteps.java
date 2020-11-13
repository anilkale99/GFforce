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
    public void clickLink(String linkName) throws InterruptedException {
        clickOnLink(linkName);
    }

    @When("User clicks on {string} sub-menu")
    public void clickOnSubMenuItem(String subMenuName) throws InterruptedException {
        clickOnLink(subMenuName);
    }


    @When("User clicks on an opportunity")
    public void userClickOnOpportunity() throws InterruptedException {
        clickOnOpportunity();
    }


    @When("User selects value {string} from {string} dropdown")
    public void userSelectValueFromDropdown(String value, String dropdownName){
        selectValueFromDropdown(value, dropdownName);
    }

    @When("User clicks to create {string}")
    public void userCreatesOpportunity(String opportunityType){
        clickCreateOpportunity(opportunityType);
    }

    @When("User selects option {string} from displayed {string}")
    public void selectValueFromResult(String index, String value){
        selectValueWithIndex(index, value);
    }

    @When("User selects start date from {string}")
    public void userSelectsStartDate(String datePicker) throws Exception {
        selectStartDate(datePicker);
    }

    @When("User selects {string} from {string}")
    public void userSelectsDate(String date, String datePicker) throws Exception {
        selectDateFromDatePicker(date, datePicker);
    }

    @When("User selects start date for VG from {string}")
    public void userSelectsDateForVG(String datePicker) throws Exception {
        selectVGStartDate(datePicker);
    }

    @When("Visible options are")
    public void subMenuOptions(List<String> subMenuOptions) throws InterruptedException {
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
    public void UserClickAndSelectValue(String field, String value) throws InterruptedException {
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
    public void userClickOnListToSelectValue(Map<String, String> fieldValueMap) throws InterruptedException {
        clickAndSelectValuesFromMap(fieldValueMap);
    }

    @When("User clicks on {string} opportunity")
    public void userClickOnListToSelectValue(String opportunityName) throws InterruptedException {
        clickOnLink(opportunityName);
    }

    @When("All open opportunities are displayed")
    public void allOpenOpportunitiesAreDisplayed() {
        verifyOpportunitiesAreDisplayed();
    }

    @When("{string} details are displayed")
    public void detailsAreDisplayed(String textOnPage) {
        verifyDetailsAreDisplayed(textOnPage);
    }

    @When("Opportunity details are displayed")
    public void userVerifyOpportunityDetails() {
        opportunityDetailsAreDisplayed();
    }

    @When("User scrolls down {int} page")
    public void userScrollsPageDown(int numberOfPages) throws InterruptedException {
        scrollPageDown(numberOfPages);
    }

    @When("User accepts all terms and conditions for {string}")
    public void userAcceptsAllTerms(String forAction) throws InterruptedException {
        acceptAllTermsAndConditions(forAction);
    }

    @When("User selects preference")
    public void userSelectsPreference(Map<String, String> userPreference) {
        selectPreference(userPreference);
    }

    @When("User clicks on {string} for {string}")
    public void userEditsOpportunity(String action, String name) {
        editOpportunityByName(action, name);
    }

    @When("User clicks on Edit opportunity")
    public void userClicksEditsOpportunity() {
        editOpportunity();
    }

    @When("User clicks on Apply for a grant")
    public void userClicksApplyForGrant() {
        clickApplyForGrant();
    }

    @When("User scrolls to {string} to {string}")
    public void userScrollsToElement(String element, String action) throws InterruptedException {
        scrollToElementOnPage(element, action);
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
    public void userClicksOnLink(String linkText) throws InterruptedException {
        clickOnLink(linkText);
    }

    @When("User clicks on button {string}")
    public void userClicksOnButton(String buttonName) throws InterruptedException {
        clickOnAButton(buttonName);
    }

    @When("User clicks on {string} option")
    public void userClickOnOption(String optionName) throws InterruptedException {
        clickOnAButton(optionName);
    }

    @When("User enters value {string} in {string}")
    public void userEntersValueInfield(String value, String fieldName){
        enterValueInFieldWithName(value, fieldName);
    }

    @When("User enters title of opportunity")
    public void userEntersTitle(){
        enterTitle();
    }

    @When("User enters value in VG {string}")
    public void userEntersVGTitle(String fieldName){
        enterVGTitle(fieldName);
    }


    @When("Volunteering opportunities are displayed")
    public void volunteeringOpportunitiesAreDisplayed(){
        verifySearchResult();
    }


    @When("User can sort the results by clicking")
    public void userCanSortResults(List<String> sortOptions) throws InterruptedException {
        verifyOptions(sortOptions);
    }

    @When("User can navigate to opportunities by clicking")
    public void userCanNavigate(List<String> typeOptions) throws InterruptedException {
        verifyNavOptions(typeOptions);
    }

    @When("User clicks on {string} when popup appears")
    public void userclicksContinueOnPopup(String buttonName){
        try {
            clickOnPopupButton(buttonName);
            System.out.println("Clicked on popup continue");
        } catch (Exception e){
            System.out.println("No pop-up appeared");
        }
    }

//    @Then("close browser")
//    public void closeBrowser(){
//        closeAllBrowsers();
//    }

}
