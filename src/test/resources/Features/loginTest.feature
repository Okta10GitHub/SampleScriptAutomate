@runningAll
@login
Feature: Login with Various Scenarios
  In order to access my account
  As a user
  I want to be able to log in using different scenarios

  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter valid username "standard_user" and valid password "secret_sauce"
    And I click the login button
    Then I should be successfully logged in and direct to "https://www.saucedemo.com/inventory.html"

  Scenario: Failed login with incorrect password
    Given I am on the login page
    When I enter valid username "standard_user" and incorrect password "wrongpassword"
    And I click the login button
    Then I should see an error message "Epic sadface: Username and password do not match any user in this service"

  Scenario: Failed login with non-existing username
    Given I am on the login page
    When I enter non-existing username "nonexistentuser" and valid password "secret_sauce"
    And I click the login button
    Then I should see an error message "Epic sadface: Username and password do not match any user in this service"

  Scenario: Failed login with empty username
    Given I am on the login page
    When I enter empty username and password "secret_sauce"
    And I click the login button
    Then I should see an error message "Epic sadface: Username is required"

  Scenario: Failed login with empty password
    Given I am on the login page
    When I enter non-existing username "standard_user" and empty password
    And I click the login button
    Then I should see an error message "Epic sadface: Password is required"

  Scenario: Failed login with empty username and password
    Given I am on the login page
    When I enter empty username and empty password
    And I click the login button
    Then I should see an error message "Epic sadface: Username is required"
