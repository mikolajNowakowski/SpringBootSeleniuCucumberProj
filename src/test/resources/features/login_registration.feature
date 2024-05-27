Feature: Store login and registration

  Background:
    Given I am on the store home page
    When I click on the MyAccount button
    Then I am on the login form page

  @registerSuccess
  Scenario Outline: I want to register and then log in with specified credentials
    When I provide "<email>" and "<password>" to register
    Then I am successfully logged in to my account "<email>"
    When I log out from my account
    And I log in with the same "<email>" and "<password>"
    Then I am successfully logged in to my account "<email>"

    Examples:
      | email                                        | password                   |
      | user1342wre34sdfswddwee4344333231@example.com | password197887658756856345 |
      | use323wwser43ee433e441r2@example.com          | password2978345634563445   |
      | user233wersde65wer4344313@example.com         | password3978234523452345   |



  @alreadyRegisteredError
  Scenario Outline: I want to register twice with the same email
    When I provide "<email>" and "<password>" to register
    Then I am successfully logged in to my account "<email>"
    When I log out from my account
    And I provide "<email>" and "<password>" to register
    Then I get specified error message "<errorMessage>"
    And  I see only one error message



    Examples:
      | email                           | password                  | errorMessage                                                             |
      | flsdjhflkerresdjf@example.com    | passworsdfsdfsdfd1234*&^% | Błąd: Konto z Twoim adresem e-mail jest już zarejestrowane. Zaloguj się. |
      | flsdjhflerewewksdjf@example.com  | passworsdfsdfsdfd1234*&^% | Błąd: Konto z Twoim adresem e-mail jest już zarejestrowane. Zaloguj się. |
      | flsdjhflwergreksdjf@example.com  | passworsdfsdfsdfd1234*&^% | Błąd: Konto z Twoim adresem e-mail jest już zarejestrowane. Zaloguj się. |
      | flsdjhfwerdfrelksdjf@example.com | passworsdfsdfsdfd1234*&^% | Błąd: Konto z Twoim adresem e-mail jest już zarejestrowane. Zaloguj się. |
      | flsdjhfwerhrelksdjf@example.com  | passworsdfsdfsdfd1234*&^% | Błąd: Konto z Twoim adresem e-mail jest już zarejestrowane. Zaloguj się. |
