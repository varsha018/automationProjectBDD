Feature: To test the ModuleMenu page functionality
	
Scenario: Check title of ModuleMenu Page	
When user navigates to ModuleMenu Page from HomePage
Then user verifies the title of the ModuleMenu page

Scenario: Check operations available on ModuleMenu Page	
Given user is on ModuleMenu Page
Then verify number of operations displayed on ModuleMenu page
Then verify names of all the operations displayed on ModuleMenu page

Scenario: Search for "Invoice Operations" 
Given Invoice Operations available on ModuleMenu page
When user hovers over Invoice Operations
Then List of all invoice operations displayed

Scenario: Check all Invoice Operations available 
When user hovers over Invoice Operations
Then check the number of invoice operations present
Then check names of all the invoice operations





