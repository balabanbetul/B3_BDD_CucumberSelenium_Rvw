Feature: Login Test-the user should be able to login with valid credential

  Background:
    Given the user is on the login page

  @loginWithOutParameters
  Scenario: Positive scenario 1-user should be able to login
    When the user enters valid credentials
    Then verify "Welcome etsB3"

  @LoginWithParameters
  Scenario: Positive scenario 2-user should be able to login
    When the user enters "etsB3" and "Test123+" and click login button
    Then verify "Welcome etsB3"

  @loginWithDataTable
  Scenario Outline: Positive scenario 3-user should be able to login
    When the user enters valid username and password
      | username | <username> |
      | password | <password> |
    Then verify "<message>"

    Examples:
      | username | password | message       |
      | etsB3    | Test123+ | Welcome etsB3 |
@loginInvalid
  Scenario Outline: Negative scenario-User should be able to login with invalid credential
    When the user enters "<invalid username>" and "<invalid password>" and click login button
    Then verify invalid credential "<message>"
    Examples:
      | invalid username | invalid password | message                                |
      | etsB3INVALID     | Test123+         | User does not exist.                   |
      | etsB3INVALID     | Test123invalid   | User does not exist.                   |
      | etsB3            | Test123++++      | Wrong password.                        |
      |                  | Test123+         | Please fill out Username and Password. |
      | etsB3            |                  | Please fill out Username and Password. |
      |                  |                  | Please fill out Username and Password. |

