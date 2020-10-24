package com.gfforce.steps.common;

import com.gfforce.pom.common.ContextSteps;
import com.gfforce.pom.pages.Volunteering;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class VolunteeringSteps extends Volunteering {

    public VolunteeringSteps(ContextSteps contextSteps) {
        super(contextSteps);
    }

    @When("User clicks on Volunteering menu")
    public void clickVolunteeringLink(){
        clickVolunteering();
    }

    @Then("Visible submenu for \"([^\"]*)\" is$")
    public void verifySubmenu(String subMenuName, List<String> subMenuItems){
        validateSubmenu(subMenuName, subMenuItems);
    }

    @When("User clicks on {string} sub-menu")
    public void clickOnSubMenuItem(String subMenuName){
        clickOnSubMenu(subMenuName);
    }

    @When("User enters value {string} in {string} field")
    public void enterValueInfield(String value, String fieldName){
        enterValue(value, fieldName);
    }

    @When("User selects value {string} from {string} dropdown")
    public void selectValueFromDropdown(String value, String dropdownName){
        selectValue(value, dropdownName);
    }

    @When("User clicks on {string} button")
    public void clickOnButton(String fieldName){
        clickButton(fieldName);
    }


}
