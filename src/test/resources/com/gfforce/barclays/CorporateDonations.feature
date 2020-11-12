@mdRegression
Feature: Corporate Donations
  Scenario: Create a corporate donation
    When User enters value "md123" in "username" field
    And User enters value "Abcd@12345" in "password" field
    And User clicks on "sign-in"
    When User clicks on menu "Corporate Donations"
    Then Visible options for Corporate Donations are
          | Overview |
          | Apply |
          | All Active |
          | Completed/Cancelled |
    When User clicks on "Apply" to "create" corporate donation
    Then "Request a corporate donation" page is displayed
    #When User clicks to select option "Myself"
    And  User enters value "Centre for Animals and Social Justice" in field "charity_name"
    And User clicks on CD page button "Search"
    And From displayed "results" user selects option "1"
    And User enters value "This is a description" in field "description"
    And User selects "30 December 2020" from "expected_payment_date" calendar
    And User clicks to select radio "It will be paid centrally"
    And User enters value "50" in donation amount
    And User enters value "these are the details" in field "details"
    And User clicks on CD page button "Continue"
    And User clicks on CD page button "Continue"
    And User clicks on CD page button "Submit"
    And Store the CD reference number
    Then "Thank you for requesting a corporate donation" page is displayed

    Scenario: Verify the newly create Corporate Donation request
      When User enters value "md123" in "username" field
      And User enters value "Abcd@12345" in "password" field
      And User clicks on "sign-in"
      When User clicks on menu "Corporate Donations"
      And User clicks on CD submenu "All Active"
      Then Verify the donation request is visible
      When User clicks on CD reference id
      Then User verifies below corporate donation details
          | Name | Mohammad Daimi |
          | Employee Reference | 12345 |
          | Country group      | Barclays-UK |
          | Email              | jyoti.singh@givingforce.com |

  Scenario: View Corporate Donation requests from View applications
    When User enters value "md123" in "username" field
    And User enters value "Abcd@12345" in "password" field
    And User clicks on "sign-in"
    When User clicks on menu "Corporate Donations"
    And User clicks on "View applications" to "view" corporate donation
    Then "Your corporate donation requests" page is displayed
    And Verify the donation request is visible
