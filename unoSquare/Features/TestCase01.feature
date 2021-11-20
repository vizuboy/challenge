Feature: Shopping Cart
  
  Scenario: Visual Studio Shopping
    Given the user is on the windows home page
    And validate that all menu items are present
    And print all elements in dropdown from windows page
    When the user search <search>
    And click the first one
    And add to the cart, select <value>
    Then the user validate the correct price

    Examples: 
      | value   | search 				|
      |   "20"  |"Visual Studio"|