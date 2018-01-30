Feature: Length Unit Converter
  As an engineer
  I want to convert length measurements
  So that I can use those conversions in formulas

  Scenario Outline: Convert centimetre to inch
    Given I have a unit converter
    When I convert <centimetre> centimetre to inch
    Then the result must be <inch> inch

    Examples:
      | centimetre | inch       |
      | 0          | 0          |
      | 1          | 0.39370079 |