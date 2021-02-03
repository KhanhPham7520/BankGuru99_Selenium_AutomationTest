@parameter
Feature: Parameter Feature
  I want to use this template for my feature file

 # Background
  #  Given Open Facebook application


  @param
  Scenario: Scenario has no parameter
    When Input to Username textbox with "automationtest@gmail.com"
    And Input to Password textbox with "123456"
    And Click To Submit button



  @multiple_param
  Scenario: Scenario has parameter
    When Input to Username textbox with "automationtest@gmail.com" and password with "123456"
    And Click To Submit button








