@mdRegression @CharityGrants
Feature: Charity Grants feature

  @createCG @CharityGrants
  Scenario: Create Charity Grant Nomination
    #Given User is on application home page
    When User enters value "md123" in "username" field
    And User enters value "Abcd@12345" in "password" field
    And User clicks on "sign-in"
    When User clicks on "Charity Grants" from menu
    Then Visible submenu options are
      | Overview |
      | Nominate |
      | Your Nominations |
    And User clicks on "Start application" to "Apply for SoC funding"
    Then Verify "Nominate a charity" is displayed
    And Verify "Eligibility Questions" is displayed
    When User enters value "Mohammad Daimi, Anil Kale" in "List Employees" on CG page
    And User selects options for "Eligibility Questions"
          | 1-2000 | No |
          | 1-2002 | No |
          | 0-2003 | Yes |
          | 0-2004 | Yes |
          | 1-2005 | No |
          | 1-2006 | No |
          | 0-2008 | Yes |
          | 0-2009 | Yes |
          | 0-2010 | Yes |
          | 0-2011 | I will complete it |
    And User clicks on "Continue" button
    When User enters value "Chai-Lifeline Cancer Care" in charity "charity-search"
    And User scrolls to button "Search" to "click"
    And User selects option "1" from search "results"
    And User enters value "Jyoti Singh" in charity "contact_name"
    And User enters value "jyotisingh@abc.com" in charity "contact_email"
    And User enters value "1234567890" in charity "contact_tel"
    #And User clicks on "Continue" button
    And User scrolls to button "Continue" to "click"
    When User selects "Other" from "focus" dropdown
    And User selects "Other" from "group" dropdown
    And User selects options for "previously received funding"
        | 0-2101 | Yes |
    And User enters value "Something" in charity "Project title"
    And User enters value "Something" in charity "Project description"
    And User enters following values in cost breakdown
        | Item | Description | 1500 | null |
        | Item1 | Description1 | 1500 | null |
    And User scrolls to button "Continue" to "click"
    And User scrolls to Submit button to "click"
    And Store the nomination id
    Then "Thank you!" is displayed

  @CharityGrants
    Scenario: Verify the newly create nomination
      When User enters value "md123" in "username" field
      And User enters value "Abcd@12345" in "password" field
      And User clicks on "sign-in"
      When User clicks on "Charity Grants" from menu
      And User clicks on "Your Nominations" submenu
    When User clicks on reference number
    Then Nomination details of the Charity Grant are displayed
    And User verifies below nomination details
        | Employee Reference | 12345 |
        | Country group      | Barclays-UK |
        | Name       | Mohammad Daimi |
        | Email      | jyoti.singh@givingforce.com |
    #And User clicks on "sign-out"

    @viewCG @CharityGrants
  Scenario: Verify User is able to see CG Nomination on applications page
    When User enters value "md123" in "username" field
    And User enters value "Abcd@12345" in "password" field
    And User clicks on "sign-in"
    When User clicks on "Charity Grants" from menu
    And User clicks on "View application(s)" to "View your application(s)"
      Then Verify "Your nominations" is displayed
      And User verifies below nomination details for reference number "CGN-433144-8"
          | Date             | 08 Nov 2020 |
          | Charity Name     | Chai-Lifeline Cancer Care |
          | Status           | In progress               |
      #And User clicks on "sign-out"

  @CharityGrants
  Scenario: View Charity Grant nominations
    When User enters value "md123" in "username" field
    And User enters value "Abcd@12345" in "password" field
    And User clicks on "sign-in"
    When User clicks on "Charity Grants" from menu
    And User clicks on "Your Nominations" submenu
    Then Verify "Your nominations" is displayed
    And Verify "CGN-433144-12" is displayed




