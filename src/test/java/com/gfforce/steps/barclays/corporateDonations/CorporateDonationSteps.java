package com.gfforce.steps.barclays.corporateDonations;

import com.gfforce.pom.common.ContextSteps;
import com.gfforce.pom.pages.CorporateDonations;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class CorporateDonationSteps extends CorporateDonations {

    public CorporateDonationSteps(ContextSteps contextSteps) {
        super(contextSteps);
    }

    @When("User clicks on menu {string}")
    public void userClickOnMenu(String linkName) throws InterruptedException {
        clickByLinkText(linkName);
    }

    @When("User clicks on CD submenu {string}")
    public void userClickSubmenu(String linkName) throws InterruptedException {
        clickByLinkText(linkName);
    }

    @When("Verify the donation request is visible")
    public void userVerifyRequestIsPresent() throws InterruptedException {
        verifyRequestIsPresent();
    }

    @When("User clicks on CD reference id")
    public void userClicksOnRefernce() throws InterruptedException {
        clickOnReferenceID();
    }

    @When("Visible options for Corporate Donations are")
    public void userVerifiesOptions(List<String> menuOptions) throws InterruptedException {
        validateSubMenuOptions(menuOptions);
    }

    @When("User clicks on {string} to {string} corporate donation")
    public void userClickOnAction(String link, String action) throws InterruptedException {
        clickByLinkText(link);
    }

    @When("{string} page is displayed")
    public void userVerifyPage(String textOnPage) throws InterruptedException {
        verifyDetailsAreDisplayed(textOnPage);
    }

    @When("User clicks to select option {string}")
    public void userClickToSelect(String optionText) throws InterruptedException {
        clickToSelectOption(optionText);
    }
    @When("User clicks to select radio {string}")
    public void userClickToSelectRadio(String optionText) throws InterruptedException {
        clickToSelectRadio(optionText);
    }


    @When("User enters value {string} in field {string}")
    public void userEntersValueInField(String value, String field) throws InterruptedException {
        enterValueInField(field, value);
    }

    @When("User enters value {string} in donation amount")
    public void userEntersDonationAmount(String value) throws InterruptedException {
        enterDonationAmount(value);
    }

    @When("User clicks on CD page button {string}")
    public void userEntersValueInField(String buttonName) throws InterruptedException {
        clickOnButton(buttonName);
    }

    @When("From displayed {string} user selects option {string}")
    public void userSelectValueFromResult(String selectFrom, String index){
        selectValueFromResult(selectFrom, index);
    }

    @When("User selects {string} from {string} calendar")
    public void userSelectsDate(String date, String calendarName) throws Exception {
        selectDateFromDatePicker(date, calendarName);
    }

    @When("Store the CD reference number")
    public void userStoreNominationID() {
        storeCDReferenceNum();
    }

    @When("User verifies below corporate donation details")
    public void userVerifiesCD(Map<String, String> cdDetails) {
        verifyCDDetails(cdDetails);
    }

}
