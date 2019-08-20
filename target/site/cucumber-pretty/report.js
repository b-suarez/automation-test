$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("HotelBooking.feature");
formatter.feature({
  "line": 2,
  "name": "User should be able to book and hotel and check the reservation",
  "description": "\r\nUser should be able to log out and log in again",
  "id": "user-should-be-able-to-book-and-hotel-and-check-the-reservation",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Test4"
    }
  ]
});
formatter.scenarioOutline({
  "line": 13,
  "name": "User books an hotel reservation",
  "description": "",
  "id": "user-should-be-able-to-book-and-hotel-and-check-the-reservation;user-books-an-hotel-reservation",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 14,
  "name": "user account page is displayed",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "user clicks on the HOTELS button",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "introduces a \u003ccheckInDate\u003e and \u003ccheckOutDate\u003e on the searchbar",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "clicks on SEARCH button",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "user applies ratings and Hotel filters",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "selects the first displayed Hotel",
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "books the cheapest available room",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "user confirms booking",
  "keyword": "Then "
});
formatter.examples({
  "line": 23,
  "name": "",
  "description": "",
  "id": "user-should-be-able-to-book-and-hotel-and-check-the-reservation;user-books-an-hotel-reservation;",
  "rows": [
    {
      "cells": [
        "checkInDate",
        "checkOutDate"
      ],
      "line": 24,
      "id": "user-should-be-able-to-book-and-hotel-and-check-the-reservation;user-books-an-hotel-reservation;;1"
    },
    {
      "cells": [
        "20/02/2019",
        "22/02/2019"
      ],
      "line": 25,
      "id": "user-should-be-able-to-book-and-hotel-and-check-the-reservation;user-books-an-hotel-reservation;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 3007023479,
  "status": "passed"
});
formatter.background({
  "line": 6,
  "name": "User logins into the website",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 7,
  "name": "user navigates to home page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "user access to the login page",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "user introduces UserName \"user@phptravels.com\" and Password \"demouser\"",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "user clicks in login button",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "user account page is displayed",
  "keyword": "And "
});
formatter.match({
  "location": "LoginAndUpdateSteps.user_navigates_to_home_page()"
});
formatter.result({
  "duration": 8211087260,
  "status": "passed"
});
formatter.match({
  "location": "LoginAndUpdateSteps.user_access_to_the_login_page()"
});
formatter.result({
  "duration": 968948154,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "user@phptravels.com",
      "offset": 26
    },
    {
      "val": "demouser",
      "offset": 61
    }
  ],
  "location": "LoginAndUpdateSteps.user_introduce_username_and_password(String,String)"
});
formatter.result({
  "duration": 200803930,
  "status": "passed"
});
formatter.match({
  "location": "LoginAndUpdateSteps.user_clicks_in_login_button()"
});
formatter.result({
  "duration": 59007487,
  "status": "passed"
});
formatter.match({
  "location": "LoginAndUpdateSteps.user_account_page_is_displayed()"
});
