@mdRegression @Vol
Feature: Volunteering feature

  @create
  Scenario: Create Open Individual Opportunity
    #Given User is on application home page
    When User enters value "md123" in "username" field
    And User enters value "Abcd@12345" in "password" field
    And User clicks on "sign-in"
    When User clicks on "Volunteering" menu
    And User clicks on "Create opportunity" sub-menu
    Then Visible options are
      | Reserved opportunity |
      | Open opportunity     |
    When User clicks to create "Open opportunity"
    Then Visible options are
      | Individual |
      | Employee managed team |
    When User clicks to create "Individual"
    #And User enters value in field
    #  | Chai Pe Charcha 2 | title |
    #  | Chai Lifeline | organisation |
    And User enters title of opportunity
    And User enters value "Chai Lifeline" in "organisation"
    And User clicks on button "Search"
    And User selects option "1" from displayed "results"
    And User selects "28 December 2020" from "start_dts"
    And User clicks on "start_time" and selects value "09:00"
    And User clicks on "end_time" and selects value "10:00"
    And User selects "10 December 2020" from "apply_by_dts"
    And User clicks on "Physical location" option
    And User clicks on "manualAddressEntry" option
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
    And User enters value "This is note to admin" in "admin_note"
    And User clicks on "accept guidelines" option
    And User clicks on "accept policy" option
    And User clicks on "accept covid guidelines" option
    And User clicks on button "Next"
    And User clicks on button "Submit and Finish"
    #And User clicks on "sign-out"

  @applyVol
  Scenario: Apply for an opportunity
    When User enters value "md123" in "username" field
    And User enters value "Abcd@12345" in "password" field
    And User clicks on "sign-in"
    When User clicks on "Volunteering" menu
    And User clicks on "Search Opportunities" sub-menu
    Then All open opportunities are displayed
    #When User scrolls down 1 page
    #Update opportunity name before running scenario
    #And User clicks on "Charity June 2021" opportunity
    #Then "Charity June 2021" details are displayed
    When User clicks on link "50"
    When User clicks on an opportunity
    Then Opportunity details are displayed
    When User clicks on button "Apply Now"
    Then "Sign up to volunteer" details are displayed
    When User accepts all terms and conditions for "volunteering"
    #And User scrolls down 1 page
    And User scrolls to "Continue" to "click"
    And User selects preference
        | 1 | checkbox5 |
        | 2 | checkbox4 |
      And User clicks on "Continue"
      And User clicks on button "Next"
      And User clicks on button "Confirm"
      #And User clicks on "sign-out"

  @editVol
  Scenario: Edit an Opportunity
    When User enters value "md123" in "username" field
    And User enters value "Abcd@12345" in "password" field
    And User clicks on "sign-in"
    When User clicks on "Volunteering" menu
    And User clicks on "Your open opportunities" sub-menu
    Then "Volunteering opportunities" is displayed
    When User clicks on link "50"
    #Udate opportunity name before running scenario
    #And User clicks on "Edit opportunity" for "Helping hand 2021"
    When User clicks on Edit opportunity
    Then "Update volunteering opportunity" details are displayed
        #When User enters value "2021 Helping Hands" in "title"
      When User enters value "This is an updated description" in "description"
        And User scrolls to "Next" to "click"
        And User scrolls to "Update" to "click"
        Then "Thank you for updating your volunteering opportunity" is displayed
        #And User clicks on "sign-out"

  @searchVol
  Scenario: Search for an opportunity
    #Given User is on application home page
    When User enters value "md123" in "username" field
    And User enters value "Abcd@12345" in "password" field
    And User clicks on "sign-in"
    When User clicks on "Volunteering" menu
    Then Visible options are
      | Overview |
      | Search Opportunities |
      | Your Favourites |
      | Your volunteering |
      | Your open opportunities |
      | Create opportunity |
    When User clicks on "Search Opportunities" sub-menu
    And User enters value "411001" in "postcode"
    And User selects value "Coaching" from "hashtag" dropdown
    And User enters value "24 Nov 2020" in "from_date"
    And User enters value "30 Nov 2021" in "to_date"
    And User clicks on button "go"
    Then Volunteering opportunities are displayed
    And User can sort the results by clicking
          | Distance |
          | Start date |
    And User can navigate to opportunities by clicking
          | Virtual volunteering |
          | At a specific location |






