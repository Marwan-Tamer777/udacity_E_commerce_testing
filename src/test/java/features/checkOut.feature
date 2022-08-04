
Feature: check out actions

  Scenario: SC12- Create successful Order
    Given Logged User "test20@example.com" "password" navigates to search page
    And user searches for "book" in search and enters
    And user clicks on first item search option

    When user clicks on add to shopping cart button
    And user navigates to shopping cart page
    And user clicks the policy checkbox and checkout button
    And user inputs billing personal info to checkout country: "Egypt" city: "Cairo" address: "1,ahmed fa7ry" zip code: "11512" phone: "010254681265"

    Then check if checkOut was successful