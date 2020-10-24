@tag
Feature: Volunteering feature

  Scenario: Search for an opportunity
    Given User is on application home page
    When User enters value "jyoti123" in "username" field
    And User enters value "Abcd@1234" in "password" field
    And User clicks on "sign-in" button
    When User clicks on Volunteering menu
    Then Visible submenu for "Volunteering" is
        | Overview |
        | Search Opportunities |
        | Your Favourites |
        | Your volunteering |
        | Your open opportunities |
        | Create opportunity |
    When User clicks on "Search Opportunities" sub-menu
    And User enters value "N31JJ" in "postcode" field
    And User selects value "Employability" from "hashtag" dropdown
    And User enters value "24 Oct 2020" in "from_date" field
    And User enters value "20 Nov 2020" in "to_date" field
    And User clicks on "go" button

