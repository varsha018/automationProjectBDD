Feature: To test invoice maintenance operations page features

Scenario: Search for "Invoice Maintenance Operations" 
Given "Invoice Maintenance Operations" displayed on hovering over "Invoice Operations"
When user hovers over Invoice Maintenance Operations
Then List of all Invoice Maintenance Operations displayed

Scenario: Check all Invoice Maintenance Operations available 
When user hovers over Invoice Maintenance Operations
Then check the number of invoice Maintenance operations present
Then check names of all the invoice Maintenance operations

Scenario: Search for "Invoice Maintenance" 
Given "Invoice Maintenance" displayed on hovering over "Invoice Maintenance Operations"
When user clicks on Invoice Maintenance
Then user is taken to "Invoice Maintenance" page

Scenario: Search for "Manual Invoice Creation"
Given "Manual Invoice Creation" displayed on hovering over "Invoice Maintenance Operations"
When user clicks on Manual Invoice Creation
Then user is taken to "Manual Invoice Creation" page
When User selects "Invoice Type" as "Lot"
And checks the "Incomplete Lot Invoice" checkbox
Then invoice is generated and shipment done