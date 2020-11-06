@tag
Feature: Volunteering feature

  @create
  Scenario: Create Open Individual Opportunity
    #Given User is on application home page
    When User enters value "md123" in "username" field
    And User enters value "Abcd@12345" in "password" field
    And User clicks on "sign-in"
    When User clicks on "Volunteering" menu
    And User clicks on "Create opportunity" sub-menu
    Then Visible options for "Create opportunity" are
      | Reserved opportunity |
      | Open opportunity     |
    When User clicks to create "Open opportunity"
    Then Visible options are
      | Individual |
      | Employee managed team |
    When User clicks to create "Individual"
    And User enters value in field
      | Helping hand | title |
      | Chai Lifeline | organisation |
    And User clicks on "Search"
    And User selects option "1" from displayed "results"
    And User selects "30 November 2020" from "datepicker"
    And User clicks on "start_time" and selects value "09:00"
    And User clicks on "end_time" and selects value "14:00"
    And User selects "30 November 2020" from "apply_by_dts"
    And User clicks on "Physical location"
    And User clicks on "manualAddressEntry"
    And User enters value in field
      | JM Road | street |
      | Shivajinagar | town|
      | GaneshKhind | locality|
      | Pune | county|
      | 411001 | postcode|
    And User selects value "India" from "country" dropdown
    And User clicks on "tags" and selects value "Coaching"
    And User enters value in field
      | here goes the description | description |
      | Mohammad                  | contact_name |
      | 7517853376                | contact_tel  |
      | mhdaimi@hotmail.com       | contact_email |
    And User clicks on list to select value
        | theme       | Yes             |
        | programme   | Digital Skills  |
        | colleagues  | Test 2          |
        | support     | Test            |
    And User clicks on "file" to upload "Sample.odt"
    And User waits for "file upload" operation to complete
    And User enters value "This is note to admin" in "admin_note" field
    And User clicks on "accept guidelines"
    And User clicks on "accept policy"
    And User clicks on "Next"
    And User clicks on "Submit and Finish"
    And User clicks on "sign-out"

  Scenario: Search for an opportunity
    #Given User is on application home page
    When User enters value "md123" in "username" field
    And User enters value "Abcd@12345" in "password" field
    And User clicks on "sign-in"
    When User clicks on "Volunteering" menu
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
    And User clicks on "go"
    And User clicks on "sign-out"

    @apply
  Scenario: Apply for an opportunity
    When User enters value "md123" in "username" field
    And User enters value "Abcd@12345" in "password" field
    And User clicks on "sign-in"
    When User clicks on "Volunteering" menu
    And User clicks on "Search Opportunities" sub-menu
    Then All open opportunities are displayed
    When User scrolls down 1 page
    And User clicks on "Helping hand" opportunity
    Then "Helping hand" details are displayed
    When User clicks on "Apply Now"
    Then "Sign up to volunteer" details are displayed
    When User accepts all terms and conditions for "volunteering"
    And User scrolls down 1 page
    And User clicks on "Continue"
    And User selects preference
        | 1 | checkbox5 |
        | 2 | checkbox4 |
      And User clicks on "Continue"
      And User clicks on "Next"
      And User clicks on "Confirm"
      And User clicks on "sign-out"

      @edit
  Scenario: Edit an Opportunity
    When User enters value "md123" in "username" field
    And User enters value "Abcd@12345" in "password" field
    And User clicks on "sign-in"
    When User clicks on "Volunteering" menu
    And User clicks on "Your open opportunities" sub-menu
    Then "Volunteering opportunities" details are displayed
    When User clicks on "Edit opportunity" for "Helping hand again"
    Then "Update volunteering opportunity" details are displayed
        When User enters value "Coaching Helping Hands" in "title" field
        #And User scrolls down 6 page
        And User scrolls to "Next" to "click"
        And User scrolls to "Update" to "click"
        Then "Thank you for updating your volunteering opportunity" is displayed
        And User clicks on "sign-out"






