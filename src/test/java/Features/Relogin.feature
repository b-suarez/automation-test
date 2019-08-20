@Test3
Feature: User login and relogin checks
  User should be able to see his first name in the navigation bar when navigation through the site
  User should be able to log out and log in again

  Background: User navigates to Login page
    Given user navigates to home page
    When user access to the login page
    And user introduces UserName "user@phptravels.com" and Password "demouser"
    Then user clicks in login button
    And user account page is displayed
    And user click on My Profile button

  Scenario: User should see his first name in the navigation bar
    Given user details are displayed
    Then user first name should be displayed in the navigation bar

  Scenario: User should be able to log out and log in again
    Given user details are displayed
    When user logs out
    And user introduces UserName "user@phptravels.com" and Password "demouser"
    Then user clicks in login button
    And user account page is displayed