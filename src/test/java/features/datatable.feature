@datatable
Feature: Datatable feature
  I want to use this template for my feature file

  @param
  Scenario: Scenario has parameter
    Given Open Facebook application
    When Input to Username textbox with "automationtest@gmail.com"
    And Input to Password textbox with "123456"
    And Click To Submit button
  # Then verify....
    Then Close application


  @multiple_param
  Scenario: Scenario has parameter
    Given Open Facebook application
    When Input to Username textbox with "automationtest@gmail.com" and password with "123456"
    And Click To Submit button
  # Then verify....
    Then Close application


  @datatable_step
  Scenario Outline: Create new customer with email <Username> and password <Password>
    Given Open Facebook application
    When Input to Username "<Username>" and Password with "<Password>"
      | Username                 | Password |
      | automationtest@gmail.com | 123456   |
    And Click To Submit button
    Then Verify submitted infor displayed
      | Username                 | Password |
      | automationtest@gmail.com | 123456   |
    When Open Customer page
    And Input to Customer name textbox <Customer Name>
    And Input to City textbox <City>
    And Input to other required fields
      | Phone               | Email |
      | 022121314           | automationtest@gmail.com |
    Then Close application


    Examples:
      | Username                 | Password | City   | Address | Phone     | Email                  |Customer Name |
      | automationtest@gmail.com | 123456   | Ha Noi | Le Loi  | 022121314 | automationfc@gmail.com |Nhat Khanh    |
      | automationtest@gmail.com | 123456   | Ha Noi | Le Loi  | 022121314 | automationfc@gmail.com |Nhat Khanh    |


    @datable_scenario
    Scenario Outline: Data Table in Scenario
      Given Open Facebook application
      When Input to Username textbox with "<Username>"
      And Input to Password textbox with "<Password>"
      And Click To Submit button
      Then Close application

      Examples:
        | Username                 | Password |
        | automation01@gmail.com   | 123456   |
        | automation02@gmail.com   | 123456   |
        | automation03@gmail.com   | 123456   |
        | automation04@gmail.com   | 123456   |

