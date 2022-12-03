Feature: To test the Home page functionality
	
Scenario: Check home page title	
Given user navigates to home page after successful login
Then user verifies the title of the home page

Scenario: Check applications available on home page
When user is on home page
Then verify number of application displayed on home page
Then verify names of all the applications displayed on home page

Scenario: Search for "ROEM TMT" application 
When ROEM TMT application available on home page
And user clicks on ROEM TMT
Then Module menu page is displayed

