@Test5
Feature: Admin creates a new hotel and customer books a room in it
  All facilities but laundry service should be available
  Hotel should be available in other languages
  User books a room on the hotel

  Scenario: : Admin user creates new hotel
    Given user navigates to admin URL
    And admin logs in with admin credentials Username "admin@phptravels.com" and Password "demoadmin"
    When admin access to the HOTELS section
    And clicks on Add
    Then introduces "Monks palace" as hotel name
    And "Amazing hotel !!11!!" as hotel description
    And select "hilversum" as location
    Then selects all the facilities but laundry service
    And fill the spanish translations with "Palacio Monks" as name and "Que hotel" description
    Then click on the submit button
    And confirmation message should be displayed

  Scenario: : Admin user adds a room to an hotel
    Given user navigates to admin URL
    And admin logs in with admin credentials Username "admin@phptravels.com" and Password "demoadmin"
    When user access to the ROOMS section
    And adds a room to the "Monks palace" hotel

  Scenario Outline: User books a room in the monks palace
    Given user navigates to home page
    When user access to the login page
    And user introduces UserName "user@phptravels.com" and Password "demouser"
    Then user clicks in login button
    And user click on home button
    When introduces "Monks palace" in the searchbox
    And introduces a <checkInDate> and <checkOutDate> on the searchbar
    And clicks on SEARCH button
    And books the cheapest available room
    Then user confirms simple booking

    Examples:
      | checkInDate | checkOutDate |
      | 20/02/2019  | 22/02/2019   |

  Scenario Outline: Hotel info should be displayed in other language
    Given user navigates to home page
    And introduces "Palacio Monks" in the searchbox
    And introduces a <checkInDate> and <checkOutDate> on the searchbar
    And clicks on SEARCH button
    When user changes the language to "Spanish"
    Then hotel description should be "Que hotel"

    Examples:
      | checkInDate | checkOutDate |
      | 20/02/2019  | 22/02/2019   |