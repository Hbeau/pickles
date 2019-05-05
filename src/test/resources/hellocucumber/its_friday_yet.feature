
Feature: Is friday yet?
  I want to know when it's friday

  Scenario: sunday is not friday
    Given today is sunday
    When I ask it it's friday
    Then I should be told "Nope"