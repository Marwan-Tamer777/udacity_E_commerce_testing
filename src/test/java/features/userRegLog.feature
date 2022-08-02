
Feature: user account actions

#  Scenario: SC1- User could register with valid data
#    Given user navigates to register page
#
#
#    When user enters "TESTER3", "ROBOT3", "test3@example.com", "p@ssw0rd" in register inputs
#    And user clicks enter button
#
#    Then check for valid register message

#  Scenario: SC2- User could log in with valid email and password
#    Given user navigates to login page
#
#    When user enters valid email "test3@example.com" and password "p@ssw0rd"
#
#    Then check if logged in

  Scenario: SC3- User could reset his/her password successfully
    Given logged user "test3@example.com" "p@ssw0rd" navigates to change password page

    When user enters old password "p@ssw0rd" and new password "password"

    Then check for valid password change flash message
#
