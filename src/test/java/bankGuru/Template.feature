Feature: <title>

  In order to <do something>
  As a <user>
  I want to <achieve some goal>

  Scenario Outline: <title>

  <additional description>

    Given <some state>
    When <some action>
    Then <some expectation> with <some_name> # where <some_name> is actual Gherkin syntax for a table lookup!

    Examples:
      | some_name |
      | A         |
      | B         |
      | C         |
      | ...etc    |
