Feature: NavigatingToDifferentPages

@Scenario1
Scenario: Navigating to different pages of Automation Practice site

	Given User Launch Browser
	When User Open URL
	And User navigate on WOMEN page
	And User navigate on DRESSES page
	And User navigate on T-SHIRT Page
	And Verify the header and footer of the page
	And Close the browser
	

	
	
