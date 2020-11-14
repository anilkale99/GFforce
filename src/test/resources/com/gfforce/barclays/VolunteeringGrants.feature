@mdRegression @VolG @VolunteeringGrants
Feature: Volunteering Grants

  @vgTest @VolunteeringGrants
  Scenario Outline: Create Open Individual Opportunity
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
    #And User enters title of opportunity
    And User enters value "<title>" in "title"
    And User enters value "Chai Lifeline" in "organisation"
    And User clicks on button "Search"
    And User selects option "1" from displayed "results"
    And User selects "<volDate>" from "start_dts"
    #And User selects start date from "start_dts"
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
  Examples:
    | title | volDate |
    | Vol For VG - 9 | 24 March 2021 |
    | Vol For VG - 10 | 21 October 2021 |

  @vgTest @VolunteeringGrants
  Scenario: Create Volunteering Grants application
    #Given User is on application home page
    When User enters value "md123" in "username" field
    And User enters value "Abcd@12345" in "password" field
    And User clicks on "sign-in"
    When User clicks on "Volunteering" menu
    And User clicks on "Create opportunity" sub-menu
    Then Visible options are
      | Reserved opportunity |
      | Open opportunity     |
    When User clicks to create "Reserved opportunity"
        Then Visible options are
      | Individual |
      | Employee managed team |
    When User clicks to create "Individual"
    Then "Create a volunteering opportunity" is displayed
    When User accepts all terms and conditions for "volunteering"
    And User enters value "Chai Lifeline" in "organisation"
    And User clicks on button "Search"
    And User selects option "1" from displayed "results"
    #And User enters value "Professional Skills 2022" in "title"
    And User enters value in VG "title"
    #And User selects "29 August 2021" from "start_dts"
    And User selects start date for VG from "start_dts"
    And User clicks on "start_time" and selects value "09:00"
    And User clicks on "end_time" and selects value "10:00"
    And User clicks on "Physical location" option
    And User clicks on "manualAddressEntry" option
    And User enters value in field
      | JM Road | street |
      | Shivajinagar | town|
      | GaneshKhind | locality|
      | Pune | county|
      | 411001 | postcode|
    And User selects value "India" from "country" dropdown
    And User enters value "here goes the description" in "description"
    And User clicks on list to select value
      | theme       | Yes             |
      | programme   | Other Professional Skills  |
      | colleagues  | Test 2          |
      | support     | Test            |
    And User enters value in field
      | Mohammad                  | contact_name |
      | 7517853376                | contact_tel  |
      | mhdaimi@hotmail.com       | contact_email |
    And User clicks on button "Continue"
    And User clicks on "Continue" when popup appears
    And User selects preference
      | 1 | checkbox5 |
      | 2 | checkbox4 |
    And User clicks on button "Continue"
    And User selects "I wish to apply for a volunteering grant"
    When User accepts all terms and conditions for "grants"
    And User enters value "1000" in "grants required"
    And User enters value "blah blah blah" in "Breakdown"
    And User clicks on button "Next"
    And User scrolls to "Confirm" to "click"
    Then "Your volunteering reference number is" is displayed
    #And User clicks on "sign-out"

    @vgTest @VolunteeringGrants
  Scenario: Update Volunteering Grant application
    When User enters value "md123" in "username" field
    And User enters value "Abcd@12345" in "password" field
    And User clicks on "sign-in"
    When User clicks on "Volunteering" menu
    And User clicks on "Your volunteering" sub-menu
    Then "volunteering applications" is displayed
    #When User clicks on link "Update grant - VG433144-17"
      When User clicks on "Update grant" link
    #Then "Volunteering grant: VG433144-17" is displayed
    And User enters value "1800" in "grants required"
    And User enters value "Refreshment - 500\n Attire - 1000" in "Breakdown"
    And User scrolls to "Update" to "click"
    Then "Thank you for updating your application" is displayed
    And "Back to your homepage" is displayed
      #And User clicks on "sign-out"

  @vgTest @VolunteeringGrants
  Scenario: Edit Volunteering application to create Volunteering Grant application
    When User enters value "md123" in "username" field
    And User enters value "Abcd@12345" in "password" field
    And User clicks on "sign-in"
    When User clicks on "Volunteering" menu
    And User clicks on "Your open opportunities" sub-menu
    Then "Volunteering opportunities" is displayed
    When User clicks on link "50"
    #When User clicks on "Official Chai Pe Charcha (VOL433144-38)" opportunity
    When User clicks on "Vol For VG - 10" link
    And User clicks on button "Apply Now"
    And User accepts all terms and conditions for "volunteering"
    And User scrolls to "Continue" to "click"
    And User clicks on "Continue" when popup appears
    And User selects preference
      | 1 | checkbox5 |
      | 2 | checkbox4 |
    And User scrolls to "Continue" to "click"
    And User selects "I wish to apply for a volunteering grant"
    When User accepts all terms and conditions for "grants"
    And User enters value "1000" in "grants required"
    And User enters value "blah blah blah" in "Breakdown"
    And User clicks on button "Next"
    And User scrolls to "Confirm" to "click"

  @vgTest @VolunteeringGrants
  Scenario: Apply for an opportunity
    When User enters value "md123" in "username" field
    And User enters value "Abcd@12345" in "password" field
    And User clicks on "sign-in"
    When User clicks on "Volunteering" menu
    And User clicks on "Search Opportunities" sub-menu
    Then All open opportunities are displayed
    When User clicks on link "50"
    #Update opportunity name before running scenario
    And User clicks on "Vol For VG - 9" opportunity
    #Then "Charity June 2021" details are displayed
    When User clicks on button "Apply Now"
    Then "Sign up to volunteer" details are displayed
    When User accepts all terms and conditions for "volunteering"
    #And User scrolls down 1 page
    And User scrolls to "Continue" to "click"
    And User clicks on "Continue" when popup appears
    And User selects preference
      | 1 | checkbox5 |
      | 2 | checkbox4 |
    And User clicks on "Continue"
    And User clicks on button "Next"
    And User clicks on button "Confirm"

    @vgTest @VolunteeringGrants
  Scenario: Create VG application from Your Volunteering
    When User enters value "md123" in "username" field
    And User enters value "Abcd@12345" in "password" field
    And User clicks on "sign-in"
    When User clicks on "Volunteering" menu
      And User clicks on "Your volunteering" sub-menu
      Then "volunteering applications" is displayed
      #When User clicks on "Apply for a grant" for "Volunteer for a Teer - 1 (VOL433144-40)"
      #When User clicks on Apply for a grant
      When User clicks on Apply for a grant link
      Then "Apply for volunteering grant" is displayed
      When User accepts all terms and conditions for "grants"
      And User enters value "1500" in "grants required"
      And User enters value "blah blah blah" in "Breakdown"
      And User scrolls to "Submit" to "click"
      Then "Thank you for applying your application" is displayed
      And "Back to your homepage" is displayed
      #And User clicks on "sign-out"
