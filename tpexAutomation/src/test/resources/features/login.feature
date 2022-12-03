Feature: To test the Login Page functionality 

Background:
Given open the browser
And user navigate to "<URL>"
And user enter "<userName>" and "<password>"

@SmokeTest
Scenario Outline: Check login functionality scenario

When user click on login button
Then verify user is logged in successfully
Then user close the browser

Examples:
  |  URL 																		| Domain | userName | password |
  |  https://example.testproject.io/web/| TDEM	 |	Gaurav   | 12345    |
 

 
 
Scenario Outline: Check incorrect login by the user

When user click on login button
Then user gets login failed error message
Then user close the browser

Examples:
  |  URL 																| Domain |		 userName 	| password 		|
  |  https://example.testproject.io/web/| TDEM	 |		IncGaurav 	| wrong   		|

