Feature: To test the functionality of InvoiceGeneration Page

Scenario: Check Invoice Slip generated successfully
Given user is on "Invoice Maintenance" page
And user selects "Invoice No." from the DropDown
When user clicks on Search button
Then details of invoice automatically gets populated in text field
Then user verifies all the details
When user clicks on Print button
Then Invoice Slip is generated successfully in a new window

Scenario: Verify Invoice Slip Summary details
Given Invoice slip is generated
Then user verifies all the details of invoice summary slip

Scenario: Verify number of containers and modules from invoice slip