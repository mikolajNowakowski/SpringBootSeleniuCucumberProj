Feature: Store login and registration

  Background:
    Given I am on the store home page
    When I click on the MyAccount button
    Then I am on the login form page

  @registerSuccess
  Scenario Outline: I want to register and then log in with specified credentials
    When I provide email and password to register from <csvRow> row
    Then I am successfully logged into my account <csvRow>
    When I log out from my account
    And I log in with the same email and password from <csvRow> row
    Then I am successfully logged into my account <csvRow>

    Examples:
      | csvRow |
      | 0      |


  @alreadyRegisteredError
  Scenario Outline: I want to register twice with the same email
    When I provide email and password to register from <csvRow> row
    Then I am successfully logged into my account <csvRow>
    When I log out from my account
    When I provide email and password to register from <csvRow> row
    Then I get specified error message from <csvRow> row
    And  I see only one error message

    Examples:
      | csvRow |
      | 10      |