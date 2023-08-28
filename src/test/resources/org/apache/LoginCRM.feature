Feature: Login to CRM
  As a user, i want to be able to log into the CRM System
  So that I can manage customer information

  Scenario: Successful login
    Given I am on the login page
    When I enter my username and password
    And I click the login button
    Then I should be taken to the Dashboard page
    And I should see the "Dashboard" title