Feature: Length Unit Converter
  As an engineer
  I want to convert length measurements
  So that I can use those conversions in formulas

  Scenario Outline: Convert centimetre to inch
    Given I have a unit converter
    When I convert <centimetre> centimetre to inch
    Then the result must be <inch> inch

    Examples:
      | centimetre | inch        |
      | 101        | 39.76377979 |
      | 1          | 0.39370079  |

  Scenario Outline: Convert inch to centimetre
    Given I have a unit converter
    When I convert <inch> inch to centimetre
    Then the result must be <centimetre> centimetre

    Examples:
      | inch | centimetre |
      | 1    | 2.54       |
      | 5    | 12.7       |