
Feature: Shopping carts actions

  Scenario: SC9- Logged user "test14@example.com" "password" could add different products to Shopping cart

    Given Logged User "test14@example.com" "password" navigates to search page
    And user searches for "book" in search and enters
    And user clicks on first item search option

    When user clicks on add to shopping cart button
    And user navigates to shopping cart page

    Then checks last item "macbook" on shopping cart list

  Scenario: SC10- Logged user could add different products to Wishlist
    Given Logged User "test14@example.com" "password" navigates to search page
    And user searches for "book" in search and enters
    And user clicks on first item search option

    When user clicks on add to wish list button
    And user navigates to wish list page

    Then checks last item "macbook" on wish list list

  Scenario: SC11- Logged user could add different products to compare list
    Given Logged User "test14@example.com" "password" navigates to search page
    And user searches for "book" in search and enters
    And user clicks on first item search option

    When user clicks on add to compare list button
    And user navigates to compare list page

    Then checks last item "macbook" on compare list list