@Test2
Feature: Login Validation
  Customers should not be able to login to section that they are not allowed in. Find out if they can log in.

  Scenario Outline:Customers and admin users should not be able to access to the supplier page
    Given user navigate to supplier login page
    When introducing invalid username "<Username>" and password "<Password>"
    And clicks on login button
    Then invalid logIn message is displayed

    Examples:
      | Username              | Password     |
      | user@phptravels.com   | demouser     |
      | admin@phptravels.com  | demoadmin    |

  Scenario Outline:Customers and suppliers should not be able to access to the admin page
    Given user navigates to admin URL
    When introducing invalid username "<Username>" and password "<Password>"
    And clicks on login button
    Then invalid logIn message is displayed

    Examples:
      | Username                  | Password        |
      | user@phptravels.com       | demouser        |
      | supplier@phptravels.comm  | demosupplier    |

  Scenario Outline:Admins and suppliers should not be able to access to the user details page
    Given user navigates to home page
    When user access to the login page
    And user introduces UserName "<Username>" and Password "<Password>"
    And user clicks in login button
    Then invalid logIn message is displayed

    Examples:
      | Username                   | Password         |
      | admin@phptravels.com       | demoadmin        |
      | supplier@phptravels.comm   | demosupplier     |