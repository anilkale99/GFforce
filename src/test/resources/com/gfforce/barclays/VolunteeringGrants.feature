Feature: Volunteering Grants
  @vg
  Scenario: Create Volunteering Grants application
    #Given User is on application home page
    When User enters value "md123" in "username" field
    And User enters value "Abcd@12345" in "password" field
    And User clicks on "sign-in"
    When User clicks on "Volunteering" menu
    And User clicks on "Create opportunity" sub-menu
    Then Visible options for "Create opportunity" are
      | Reserved opportunity |
      | Open opportunity     |
    When User clicks to create "Reserved opportunity"
        Then Visible options are
      | Individual |
      | Employee managed team |
    When User clicks to create "Individual"
    Then "Create a volunteering opportunity" is displayed
    When User accepts all terms and conditions for "volunteering"
    And User enters value "Chai Lifeline" in "organisation" field
    And User clicks on "Search"
    And User selects option "1" from displayed "results"
    And User enters value "Other Professional Skills" in "title" field
    And User selects "25 November 2020" from "datepicker"
    And User clicks on "start_time" and selects value "09:00"
    And User clicks on "end_time" and selects value "14:00"
    #And User selects "30 November 2020" from "apply_by_dts"
    And User clicks on "Physical location"
    And User clicks on "manualAddressEntry"
    And User enters value in field
      | JM Road | street |
      | Shivajinagar | town|
      | GaneshKhind | locality|
      | Pune | county|
      | 411001 | postcode|
    And User selects value "India" from "country" dropdown
    And User enters value "here goes the description" in "description" field
    And User clicks on list to select value
      | theme       | Yes             |
      | programme   | Other Professional Skills  |
      | colleagues  | Test 2          |
      | support     | Test            |
    And User enters value in field
      | Mohammad                  | contact_name |
      | 7517853376                | contact_tel  |
      | mhdaimi@hotmail.com       | contact_email |
    And User clicks on "Continue"
    And User selects preference
      | 1 | checkbox5 |
      | 2 | checkbox4 |
    And User clicks on "Continue"
    And User selects "I wish to apply for a volunteering grant"
    When User accepts all terms and conditions for "grants"
    And User enters value "1000" in "grants required" field
    And User enters value "blah blah blah" in "Breakdown" field
    And User clicks on "Next"
    And User scrolls to "Confirm" to "click"
    Then "Your volunteering reference number is" is displayed
    When User clicks on "sign-out"