Feature: Purchase a product list

Scenario: Place an order
	Given The user is the cart page after adding some items to the cart in the web application
	When The user clicks the Place Order button
	Then A form pop up shows up



Scenario Outline: Purchase a product list
	Given the user has placed an order in the web application
	When The user fills in the user information "<name>" "<country>" "<city>" "<creditCard>" "<month>" "<year>" 
	And clicks the Purchase button
	Then A confirmation pop up shows up.
		Examples:
		|name|country|city|creditCard|month|year|
		|Name|Country|City|CreditCard|01|2030|

Scenario Outline: Purchase a product list
	Given the user has placed an order in the web application
	When The user fills in the user information wrong "<name>" "<country>" "<city>" "<creditCard>" "<month>" "<year>" 
	And clicks the Purchase button
	Then A error message shows up in the form.
		Examples:
		|name|country|city|creditCard|month|year|
		| | | | | | |
		|Name|||CreditCard|||



Scenario Outline: Finalize the purchase and return to home page
	Given the user has filled the purchase form with the user information  the user information "<name>" "<country>" "<city>" "<creditCard>" "<month>" "<year>" 
	And clicks the Purchase button
	When The user clicks the OK button
	Then The user returns to the Home Page
		Examples:
		|name|country|city|creditCard|month|year|
		|Name|Country|City|CreditCard|01|2030|
