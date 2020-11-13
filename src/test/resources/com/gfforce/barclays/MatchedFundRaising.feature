@tag @mdRegression
Feature: Matched Fund Raising feature


	@MatchedFundRaising
  Scenario: 1.Create New Fund Raising Event
  	When User enters value "md123" in "username" field
    And User enters value "Abcd@12345" in "password" field
    And User clicks on "sign-in"
    When User clicks on "Matched Fundraising" menu
  	And User clicks on "Apply" sub-menu
  	And User enters value in field
      | Chai Lifeline | organisation |
    And User clicks on button "Search"
    And User selects option "1" from displayed "results"
    And User enters MF event Name value "Event Name 001" in "event_name" field
    And User selects "30 November 2020" from "event_dts"
    And User clicks on Select Coding list to select value
    | Yes             |
    And User on MF enters value "blah blah blah" in "details" field
    And User clicks on "Continue"
    And User selects preference
      | 1 | checkbox8 |
    And User clicks on "Continue"
    And User selects preference
        | 1 | checkbox9 |
    And User on MF click element "Confirm"
    Then "Thank you" details are displayed
    Then User clicks on "Back to your homepage"
    #And User clicks on "sign-out"
   
@MatchedFundRaising
  Scenario: 2.Edit Fund Raising Event
  	When User enters value "md123" in "username" field
    And User enters value "Abcd@12345" in "password" field
    And User clicks on "sign-in"
    When User clicks on "Matched Fundraising" menu
    And User clicks on "Apply" sub-menu
  	And User enters value in field
      | Chai Lifeline | organisation |
    And User clicks on button "Search"
    And User selects option "1" from displayed "results"
    And User enters MF event Name value "Event Name 003" in "event_name" field
    And User selects "30 November 2020" from "event_dts"
		And User clicks on Select Coding list to select value
        | Yes             |
    And User on MF enters value "blah blah blah" in "details" field
    And User clicks on "Continue"
    And User selects preference
      | 1 | checkbox8 |
    And User clicks on "Continue"
    And User selects preference
        | 1 | checkbox9 |
    And User on MF click element "Confirm"
    Then "Thank you" details are displayed
   	And User clicks on "Your Applications" sub-menu
  	And User clicks "Event Name 003" application from Your Applications list
  	And User enters value in field
      | Yeldall Christian Centres | organisation |
    And User clicks on button "Search"
    And User selects option "1" from displayed "results"
    And User enters MF event Name value "Event Name 003_updated" in "event_name" field
    And User selects "10 December 2020" from "event_dts"
#    And User clicks on Select Coding list to select value
#    | No             |
    And User on MF enters value "blah blah blah" in "details" field
    And User clicks on "Continue"
    And User clicks on "Continue"
    And User on MF click element "Confirm"
    Then "Thank you" details are displayed
    Then User clicks on "Back to your homepage"
    #And User clicks on "sign-out"
    
    @MatchedFundRaising
  Scenario: 3.Validate Matched Fund Raising Events list on Overview tab
  	When User enters value "md123" in "username" field
    And User enters value "Abcd@12345" in "password" field
    And User clicks on "sign-in"
    When User clicks on "Matched Fundraising" menu
    And User clicks on "Apply" sub-menu
  	And User enters value in field
      | Chai Lifeline | organisation |
    And User clicks on button "Search"
    And User selects option "1" from displayed "results"
    And User enters MF event Name value "MF Event on Overview 001" in "event_name" field
    And User selects "30 November 2020" from "event_dts"
    And User clicks on Select Coding list to select value
    | Yes             |
    And User on MF enters value "blah blah blah" in "details" field
    And User clicks on "Continue"
    And User selects preference
      | 1 | checkbox8 |
    And User clicks on "Continue"
    And User selects preference
        | 1 | checkbox9 |
    And User on MF click element "Confirm"
    Then "Thank you" details are displayed
    And User clicks on "Overview" sub-menu
    Then User validate matched fund raising application list
    			|Event Name 003|
    			|MF Event on Overview 001 |
    #And User clicks on "sign-out"