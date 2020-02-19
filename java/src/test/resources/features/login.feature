Feature: Login access

  Background:
    Given user would like to log in application

  Scenario: User valid and password invalid
    Given user informs login with value equal "robson" with id
    And user informs password with value equal "GFT"
    When user clicks on login button
    Then user should see fail page with "Fail Login!" message

  Scenario: User invalid and password valid
    Given user informs login with value equal "GFT" with xpath
    And user informs password with value equal "agapito"
    When user clicks on login button
    Then user should see fail page with "Fail Login!" message

  Scenario: User invalid and password invalid
    Given user informs login with value equal "GFT" with css
    And user informs password with value equal "GFT"
    When user clicks on login button
    Then user should see fail page with "Fail Login!" message

  Scenario: User valid and password valid
    Given user informs login with value equal "robson" with name
    And user informs password with value equal "agapito"
    When user clicks on login button
    Then user should see success page with "Success Login!" message

  Scenario: User and password with data table
    Then user informs follow data with follow results:
      | Situation                         | User   | Password | Result         |
      | User valid and Password Invalid   | robson | GFT      | Fail Login!    |
      | User invalid and Password Valid   | GFT    | agapito  | Fail Login!    |
      | User Invalid and Password Invalid | GFT    | GFT      | Fail Login!    |
      | User valid and Password Valid     | robson | agapito  | Success Login! |

  Scenario Outline: User and password with data table with examples
    Given user informs login with value equal "<User>" with name
    And user informs password with value equal "<Password>"
    When user clicks on login button
    Then user should see success page with "<Result>" message

    Examples:
      | User   | Password | Result         |
      | robson | GFT      | Fail Login!    |
      | GFT    | agapito  | Fail Login!    |
      | GFT    | GFT      | Fail Login!    |
      | robson | agapito  | Success Login! |

