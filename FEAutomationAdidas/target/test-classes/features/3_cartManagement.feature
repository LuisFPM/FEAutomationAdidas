Feature: Cart management


Scenario Outline: Add Item to cart
	Given The user is in the "<Element>" page
	When The user clicks Add to Cart button
	Then A confirmation pop up shows up for user to accept
	Examples:
	| Element |
	| Sony vaio i5 |
	| Dell i7 8gb |
 
Scenario: Navigation to Cart page
Given The user has added an item to the cart in the web application
When The user clicks the Cart button on the top of the page
Then The user navigates to the List of items he previously added to the cart
 
Scenario: Remove item from cart
Given The user is in the cart page after adding some items to the cart in the web application
When The user clicks the Delete button in one item
Then The item is removed from the products lists
