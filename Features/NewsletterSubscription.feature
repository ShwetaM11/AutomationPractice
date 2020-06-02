Feature: NewsletterSubscription.feature 

@Scenario2
Scenario: Automate Newsletter Subscrption by entering unique email 
	Given User Launch Browser 
	When User Open URL 
	And User navigate on Newsletter filed 
	And User will subscribe Newsletter by entering email id 
	And User get a successful subscription message on screen 
	And User will subscribe Newsletter by entering duplicate email id
	And User get an error message as subscription is already done with this email 
	And Close the browser
