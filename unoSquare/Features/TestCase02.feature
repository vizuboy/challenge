Feature: Amazon Search
  
  Scenario: Searching products in Amazon
    Given the user is on Amazon page
    When the user create and account
    And search for <search> support
    Then elements should be displayed

     Examples: 
      | search 	|
      |"Echo"		|