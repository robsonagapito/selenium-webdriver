Feature: Login access

  Scenario: User valid and password invalid
    Given user would like to log in application
    And user informs login with value equal "robson"
    And user informs password with value equal "GFT"
    When user clicks on login button
    Then user should see fail page with "Fail Login!" message

  Scenario: User invalid and password valid
    Given user would like to log in application
    And user informs login with value equal "GFT"
    And user informs password with value equal "agapito"
    When user clicks on login button
    Then user should see fail page with "Fail Login!" message

  Scenario: User invalid and password invalid
    Given user would like to log in application
    And user informs login with value equal "GFT"
    And user informs password with value equal "GFT"
    When user clicks on login button
    Then user should see fail page with "Fail Login!" message

  Scenario: User valid and password valid
    Given user would like to log in application
    And user informs login with value equal "robson"
    And user informs password with value equal "agapito"
    When user clicks on login button
    Then user should see success page with "Success Login!" message

  Scenario: User and password with data table
    Given user would like to log in application
    Then user informs follow data with follow results:
    | Situation                         | User   | Password | Result         |
    | User valid and Password Invalid   | robson | GFT      | Fail Login!    |
    | User invalid and Password Valid   | GFT    | agapito  | Fail Login!    |
    | User Invalid and Password Invalid | GFT    | GFT      | Fail Login!    |
    | User valid and Password Valid     | robson | agapito  | Success Login! |


