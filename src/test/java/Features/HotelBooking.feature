@Test4
Feature: User should be able to book and hotel and check the reservation

  User should be able to log out and log in again

  Background: User logins into the website
    Given user navigates to home page
    When user access to the login page
    And user introduces UserName "user@phptravels.com" and Password "demouser"
    Then user clicks in login button
    And user account page is displayed

  Scenario Outline: User books an hotel reservation
    Given user account page is displayed
    When user clicks on the HOTELS button
    And introduces a <checkInDate> and <checkOutDate> on the searchbar
    And clicks on SEARCH button
    Then user applies ratings and Hotel filters
    Then selects the first displayed Hotel
    And books the cheapest available room
    Then user confirms booking

    Examples:
      | checkInDate | checkOutDate |
      | 20/02/2019  | 22/02/2019   |

    Scenario: User should see his reservations on the profile section
      Given user account page is displayed
      When clicks on Bookings button
      Then user bookings should be displayed



