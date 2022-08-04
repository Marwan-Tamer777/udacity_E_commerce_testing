
Feature: user account actions

  Scenario: SC1- User could register with valid data
    Given user navigates to register page


    When user enters "TESTER4", "ROBOT4", "test20@example.com", "pa@@@ssword" in register inputs
    And user clicks enter button

    Then check for valid register message

  Scenario: SC2- User could log in with valid email and password
    Given user navigates to login page

    When user enters valid email "test20@example.com" and password "pa@@@ssword"

    Then check if logged in

  Scenario: SC3- User could reset his/her password successfully
    Given logged user "test20@example.com" "pa@@@ssword" navigates to change password page

    When user enters old password "pa@@@ssword" and new password "password"

    Then check for valid password change flash message

