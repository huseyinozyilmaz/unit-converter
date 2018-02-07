Feature: Currency Converter
  As an international traveller
  I want to convert British Pound to Euro
  So that I can use plan my Europe trips accurately

  Scenario: Convert British Pound to Euro
    Given I have a currency converter
    When I specify a Pound value
    Then I should find out its equivalence in Euro

  Scenario: Convert Euro to British Pound
    Given I have a currency converter
    When I specify a Euro value
    Then I should find out its equivalence in British Pound