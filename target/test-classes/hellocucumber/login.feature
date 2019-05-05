
Feature: User want to login
  I want to login to the application

  Scenario: The database don't know me
    Given I'm hugo.beaucamps@jooxter.com
    When I want to login
    Then I get a response code 404