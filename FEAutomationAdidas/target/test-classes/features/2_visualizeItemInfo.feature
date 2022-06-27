
Feature: Visualize Item information
  Scenario Outline: Item navigation
    Given The user is in the Laptop Category of the web application
    When The user clicks "<Element>" item
    Then The user navigates to that "<Element>" specific page

    Examples: 
      | Element  |
      | Sony vaio i5 |
      | Dell i7 8gb |
