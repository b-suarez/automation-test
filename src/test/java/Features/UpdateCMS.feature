@Test6
Feature: CMS Updates and SEO checks
  Users update CMS constantly, changes should be reflected immediatly
  SEO-wise the site should be up to date

  Scenario: User updates FAQ information
    Given user navigates to admin URL
    When admin logs in with admin credentials Username "admin@phptravels.com" and Password "demoadmin"
    And click CMS dropdown and select pages
    And clicks on the edit button of the FAQ section
    And introduces "QA Test Description" as FAQ content
    Then clicks on submit


  Scenario: Verify FAQ'S is Updated
    Given user navigates to FAQ page
    Then FAQ text should be "QA Test Description"
