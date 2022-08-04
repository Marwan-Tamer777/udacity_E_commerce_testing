
Feature: check out actions

  Scenario: SC12- Create successful Order
    Given Logged User "test@example.com" "password" navigates to search page
    And user searches for "book" in search and enters
    And user clicks on first item search option

    When user clicks on add to shopping cart button
    And user checkOuts

    Then check if checkOut was successful