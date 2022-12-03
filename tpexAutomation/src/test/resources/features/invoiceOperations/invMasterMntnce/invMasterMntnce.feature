Feature: To test invoice Master maintenance page features

Scenario: Search for "Invoice Master Maintenance" 
Given "Invoice Master Maintenance" displayed on hovering over "Invoice Operations"
When user hovers over Invoice Master Maintenance
Then List of all Invoice Master Maintenance operations displayed

Scenario: Check all Invoice Master Maintenance options available 
When user hovers over Invoice Master Maintenance
Then check the number of Invoice Master Maintenance options present
Then check names of all the Invoice Master Maintenance operations

Scenario: Search for "National Calender Maintenance" 
Given "National Calender Maintenance" displayed on hovering over "Invoice Master Maintenance"
When user clicks on "National Calender Maintenance"
Then user is taken to "National Calender Maintenance" page
When user clicks on a date 
And user hits save button
Then the date is saved as holiday 
And colour of date box changes to pink

Scenario: Search for "Currency Code Maintenance" 
Given "Currency Code Maintenance" displayed on hovering over "Invoice Master Maintenance"
When user clicks on "Currency Code Maintenance"
Then user is taken to "Currency Code Maintenance" page
When user clicks on Add button  
Then a new row is inserted
When user enters below data
	|YEN | JAPAN YEN | YEN |
	|USD | US DOLLARS| USD |
And user hits on save button
Then rows gets added successfully


Scenario: Search for "Consignee Master" 
Given "Consignee Master" displayed on hovering over "Invoice Master Maintenance"
When user clicks on "Consignee Master"
And user enters below data
| TDEM| TMT | 1 |
And user clicks on Search button
Then invoice details are auto populated


