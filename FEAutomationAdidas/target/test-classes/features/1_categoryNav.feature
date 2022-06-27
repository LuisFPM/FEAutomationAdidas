Feature: Category navigation

  Scenario Outline: Category navigation
    Given The user is in the web application
    When The user clicks "<Element>" category 
    Then The user only visualize objects from the "<Element>" category
  	  Examples: 
       | Element | 
   	   | Phones |
     	 | Laptops |
    	 | Monitors |