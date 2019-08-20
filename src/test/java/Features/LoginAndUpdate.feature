@Test1
Feature: User login and profile update
  Users should be able to login in the website
  Users should be able to access to his profile
  Users should be able to update their profile and check the changes

  Background: User navigates to Login page
    Given user navigates to login page

  Scenario: User login
    Given user introduces UserName "user@phptravels.com" and Password "demouser"
    And user clicks in login button
    Then user account page is displayed

  Scenario: User access to My profile section
    Given user introduces UserName "user@phptravels.com" and Password "demouser"
    And user clicks in login button
    When user click on My Profile button
    Then user details are displayed

  Scenario: User updates profile
    Given user introduces UserName "user@phptravels.com" and Password "demouser"
    And user clicks in login button
    And user navigates to My Profile section
    When "98765" is introduced in the phone number textbox
    And user click on submit
    Then phone number value should be updated
    And profile updated message should be displayed