Feature: Checkout Journey

	
	Background:
	Given User Launch Browser
	When User Open URL
	And User navigate on T-SHIRT Page
	And User will select Tshirt and add to cart
	
@Scenario4
Scenario: Checkout journey by adding a product to cart
	
	And User will create new account
	And User will enter address and shipping details
	And User will Select Payment Option and confirm the order
	And User will navigate to order history and do sign out
	And Close the browser
	
Scenario: Checkout journey by adding a product to cart
	
	And User will enter email and password
	And User will enter address and shipping details
	And User will Select Payment Option and confirm the order
	And User will navigate to order history and do sign out
	And Close the browser