
Feature: user account actions

  Scenario: SC1- User could register with valid data
    Given user navigates to register page


    When user enters "TESTER4", "ROBOT4", "test14@example.com", "password" in register inputs
    And user clicks enter button

    Then check for valid register message

  Scenario: SC2- User could log in with valid email and password
    Given user navigates to login page

    When user enters valid email "test14@example.com" and password "password"

    Then check if logged in
#
#  Scenario: SC3- User could reset his/her password successfully
#    Given logged user "test14@example.com" "password" navigates to change password page
#
#    When user enters old password "password" and new password "p@ssw0rd"
#
#    Then check for valid password change flash message
#
