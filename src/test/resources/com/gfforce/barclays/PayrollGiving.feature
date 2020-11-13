@tag @mdRegression
Feature: Payroll Giving feature


@PayrollGiving
Scenario: 1.Create Payroll Giving Instruction to Organisation
  	When User enters value "md123" in "username" field
    And User enters value "Abcd@12345" in "password" field
    And User clicks on "sign-in"
	When User clicks on "Payroll Giving" menu
  	And User clicks on "Donate" sub-menu
	And User selects options for "Where your donation should go"
        | where_to_donate | An organisation |
	And User enters value in field
		| Yeldall Christian Centres | organisation |
    And User on PG clicks on element "Search"
    And User selects option "1" from displayed "results"
    And User selects options for "The amount you wish to donate"
		| 50.00 | The amount you wish to donate |
	When User enters other amount value "111.50" in "other_amount" field
	And User selects options for "Where your donation should go"
	  	| is_once | How often you wish to donate |
	And User on PG clicks on element "Continue"
	And User clicks on "Continue"
	And User selects preference
        | 1 | checkbox11 |
	And User on PG clicks on element "Submit your instruction"
	Then "Thank you for your payroll donation" details are displayed
	#And User on PG clicks on element "sign-out"

	@PayrollGiving
	Scenario: 2.Create Payroll Giving Instruction to My Giving Account
		When User enters value "md123" in "username" field
		And User enters value "Abcd@12345" in "password" field
		And User clicks on "sign-in"
		When User clicks on "Payroll Giving" menu
		And User clicks on "Donate" sub-menu
		And User selects options for "Where your donation should go"
			| whatIsMyGiving | My Giving Acount |
		And User close "dialog_title_bar" having "What is a My Giving Account?" as title
		When User enters email value "useremail@abcd.com" in "personal_email" field
		And User selects options for "The amount you wish to donate"
			| 50.00 | The amount you wish to donate |
		When User enters other amount value "111.50" in "other_amount" field
		And User selects options for "Where your donation should go"
			| is_once | How often you wish to donate |
		And User on PG clicks on element "Continue"
		And User selects preference
			| 4 | pref_contact_by_text |
		And User clicks on "Continue"
		And User selects preference
			| 1 | checkbox11 |
		And User on PG clicks on element "Submit your instruction"
		Then "Thank you for your payroll donation" details are displayed
		#And User clicks on "sign-out"


	@PayrollGiving
	Scenario: 3.Create Payroll Giving Instruction to My Giving Account and search
		When User enters value "md123" in "username" field
		And User enters value "Abcd@12345" in "password" field
		And User clicks on "sign-in"
		When User clicks on "Payroll Giving" menu
		And User clicks on "Your Instructions" sub-menu
		And User enters search value "111.50" in "search" search donation
		And User select Amount value "Amount" from "within" dropdown
		And User select Include value "All instructions" from "include" dropdown
		And User on PG clicks on element "Go"
		Then User on PG validate your instructions list
			|111.50|
		#And User clicks on "sign-out"

	@PayrollGiving
	Scenario: 5.Modify Payroll Giving Instruction
		When User enters value "md123" in "username" field
		And User enters value "Abcd@12345" in "password" field
		And User clicks on "sign-in"
		When User clicks on "Payroll Giving" menu
		And User clicks on "Your Instructions" sub-menu
		And User enters search value "111.50" in "search" search donation
		And User select Amount value "Amount" from "within" dropdown
		And User select Include value "All instructions" from "include" dropdown
		And User on PG clicks on element "Go"
		Then User on PG validate your instructions list
			|111.50|
		And User on PG clicks on element "Modify instruction"
		And User selects options for "The amount you wish to donate"
			| 50.00 | The amount you wish to donate |
		When User enters other amount value "111.50" in "other_amount" field
		And User on PG clicks on element "Continue"
		And User clicks on "Continue"
		And User selects preference
			| 1 | checkbox11 |
		And User clicks on "Confirm"
		Then "Your payroll donation request has been modified" details are displayed
		#And User clicks on "sign-out"

	@PayrollGiving
	Scenario: 4.Cancel Payroll Giving Instruction
		When User enters value "md123" in "username" field
		And User enters value "Abcd@12345" in "password" field
		And User clicks on "sign-in"
		When User clicks on "Payroll Giving" menu
		And User clicks on "Your Instructions" sub-menu
		And User enters search value "111.50" in "search" search donation
		And User select Amount value "Amount" from "within" dropdown
		And User select Include value "All instructions" from "include" dropdown
		And User on PG clicks on element "Go"
		Then User on PG validate your instructions list
			|111.50|
		And User on PG clicks on element "Cancel instruction"
		And User selects preference
			| 1 | checkbox12 |
		And User on PG clicks on element "Continue"
		Then "Your payroll donation request has been cancelled" details are displayed
		#And User clicks on "sign-out"


#	This is one time activity for user - Not good candidate for automation.
#	@PayrollGiving
#	Scenario: Create Pennies from heaven
#		When User enters value "md123" in "username" field
#		And User enters value "Abcd@12345" in "password" field
#		And User clicks on "sign-in"
#		When User clicks on "Payroll Giving" menu
#		And User clicks on "Overview" sub-menu
#		And User on PG clicks on element "Sign up"
#		And User on PG clicks on element "is_participate"
#		And User clicks on "Continue"
#		And User selects preference
#			| 4 | pref_contact_by_text |
#		And User clicks on "Continue"
#		And User selects preference
#			| 1 | checkbox10 |
#		And User clicks on "Confirm"

