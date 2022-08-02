
Feature: user account actions

  Scenario: SC1- User could register with valid data
    Given user navigates to register page

    #When user enters valid name, email and password
    When user enters "TESTER3", "ROBOT3", "test3@example.com", "p@ssw0rd" in register inputs
    And user clicks enter button

    Then check for valid register message

  Scenario: SC2- User could log in with valid email and password
    Given user navigates to login page

    When user enters valid email and password
    And user presses enter

    Then check if logged in

#  Scenario: SC3- User could reset his/her password successfully
#    Given logged user navigates to change password page
#
#    When user enters old and new passwords
#    And user presses enter
#
#    Then check for valid password change flash message
#
