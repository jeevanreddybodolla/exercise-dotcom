Feature: Verifies values on the https://www.exercise1.com/values web page

  @ValidateValues
  Scenario: Verify the values on the page
    Given I am on https://www.exercise1.com/values page
    Then The number of values on the screen should be 5
    And The values on the screen should be greater than 0
    And The total balance should be correct based on the values listed on the screen
    And The values should be formatted as currencies
    And The total balance should match the sum of the values