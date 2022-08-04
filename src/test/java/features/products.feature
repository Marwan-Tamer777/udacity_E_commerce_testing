
Feature: user product actions and searching actions

  Scenario: SC4- Logged User "test20@example.com" "password" could search for any product
    Given Logged User "test20@example.com" "password" navigates to search page

    When user searches for "shoes" in search and enters

    Then check for any search results

  Scenario: SC5- Logged User "test20@example.com" "password" could switch between currencies US-Euro
    Given logged User "test20@example.com" "password" navigates to home page

    When user selects currency "Euro"
#    When user selects currency 1

    Then check for any item's currency "€"

  Scenario: SC6- Logged user "test20@example.com" "password" could select different Categories
    Given logged User "test20@example.com" "password" navigates to home page

    When user hovers on category "Electronics"
    And clicks on subcategory "Cell Phones"
 #   When user clicks on category "Computers"
    Then check for current category title "Cell Phones"

  Scenario: SC7- Logged user "test20@example.com" "password" could filter with color
    Given logged User "test20@example.com" "password" navigates to shoes page

    When user clicks on color selector "Red" radio buttons
    And user clicks on first item search option

    Then check for available color "Red"

  Scenario: SC8- Logged user "test20@example.com" "password" could select different tags
    Given Logged User "test20@example.com" "password" navigates to search page

    When user clicks on tag "awesome"
    And user clicks on first item search option

    Then check for item tags "awesome"