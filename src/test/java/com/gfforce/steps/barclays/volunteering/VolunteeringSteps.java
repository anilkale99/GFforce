package com.gfforce.steps.barclays.volunteering;

import com.gfforce.pom.common.ContextSteps;
import com.gfforce.pom.pages.Volunteering;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class VolunteeringSteps extends Volunteering {

    public VolunteeringSteps(ContextSteps contextSteps) {
        super(contextSteps);
    }

    @When("User clicks on {string} menu")
    public void clickSubMenu(String menu){
        clickOnSubMenu(menu);
    }

    @Then("Visible submenu for \"([^\"]*)\" is$")
    public void verifySubmenu(String subMenuName, List<String> subMenuItems){
        validateSubmenu(subMenuName, subMenuItems);
    }

    @When("User clicks on {string} sub-menu")
    public void clickOnSubMenuItem(String subMenuName){
        clickOnSubMenu(subMenuName);
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

//    @Then("close browser")
//    public void closeBrowser(){
//        closeAllBrowsers();
//    }

}
