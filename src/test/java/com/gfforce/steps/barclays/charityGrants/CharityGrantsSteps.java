package com.gfforce.steps.barclays.charityGrants;

import com.gfforce.pom.common.ContextSteps;
import com.gfforce.pom.pages.CharityGrants;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class CharityGrantsSteps extends CharityGrants {

    public CharityGrantsSteps(ContextSteps contextSteps){
        super(contextSteps);
    }

    @When("User selects options for {string}")
    public void userSelectsValueFor(String optionsFor, Map<String, String> optionsToSelect) throws InterruptedException {
        selectValuesFor(optionsFor, optionsToSelect);
    }

    @When("User clicks on {string} button")
    public void userClickContinueToNavigate(String element) {
        clickToNavigate(element);
    }

    @When("User selects option {string} from search {string}")
    public void userSelectsOption(String option, String from) throws InterruptedException {
        selectOption(option, from);
    }

    @When("User enters value {string} in charity {string}")
    public void userEntersValue(String value, String field) {
        entersValueInField(value, field);
    }

    @When("User selects {string} from {string} dropdown")
    public void userClicksToSelect(String value, String dropdownName) {
        selectValueFromDropdown(value, dropdownName);
    }

    @When("User enters following values in cost breakdown")
    public void userEntersValuesForCostBreakdown(Map<String, List<String>> mapOfValues) throws InterruptedException {
        enterValuesForCostBreakdown(mapOfValues);
    }

    @When("User scrolls to button {string} to {string}")
    public void userScrollsToButtonToClick(String element, String action) throws InterruptedException {
        scrollToButtonToClick(element, action);
    }

    @When("User scrolls to Submit button to {string}")
    public void userScrollsToSubmitButtonToClick(String action) throws InterruptedException {
        scrollToSubmitButtonToClick(action);
    }

    @When("Store the nomination id")
    public void userStoreNominationID() {
        storeNominationID();
    }

    @When("User clicks on reference number")
    public void userClicksReferenceNumber() throws InterruptedException {
        clickReferenceNumber();
    }

    @When("Nomination details of the Charity Grant are displayed")
    public void userChecksNominationDetails() {
        checkNominationDetailsAreDisplayed();
    }

    @When("User verifies below nomination details")
    public void userVerifiesNominationDetails(Map<String, String> nominationDetails) {
        verifyNominationDetails(nominationDetails);
    }

    @When("User verifies below nomination details for reference number {string}")
    public void userVerifiesNominationDetails(String referenceNumber, Map<String, String> details) {
        verifyNominationDetailsOfReferenceNumber(referenceNumber, details);
    }

    @When("Visible submenu options are")
    public void userVerifiesSubmenu(List<String> subMenuOptions) throws InterruptedException {
        validateSubMenuOptions(subMenuOptions);
    }

    @When("User clicks on {string} from menu")
    public void userVerifiesSubmenu(String menuName) throws InterruptedException {
        clickByLinkText(menuName);
    }

    @When("User clicks on {string} submenu")
    public void userClicksSubmenu(String submenuName) throws InterruptedException {
        clickByLinkText(submenuName);
    }

    @When("User clicks on {string} to {string}")
    public void userApplyForFunding(String action, String funding) {
        applyForFunding(action, funding);
    }

    @When("Verify {string} is displayed")
    public void messageIsDisplayed(String textOnPage) {
        verifyDetailsAreDisplayed(textOnPage);
    }

    @When("User enters value {string} in {string} on CG page")
    public void userEntersValueInfield(String value, String fieldName){
        enterValueInFieldWithName(value, fieldName);
    }

}
