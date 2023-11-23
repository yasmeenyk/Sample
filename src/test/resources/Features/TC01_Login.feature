@Login
Feature: Testing the Login Functionality

  Background: 
    Given I am on the login page

  Scenario Outline: Login with valid credentials
    When I enter username "<username>" and password "<password>"
    And I click the login button
    Then I should verify after login success message "Demo user"

    Examples: 
      | username | password |
      | demo     |     1234 |

  Scenario Outline: Login with Invalid credentials
    When I enter username "<username>" and password "<password>"
    And I click the login button
    Then I should verify the error message "The given name / password are incorrect. Please, try again."

    Examples: 
      | username | password |
      | demo     |    12345 |
