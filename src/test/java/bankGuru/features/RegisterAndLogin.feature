@customer
 Feature: Register / Login And New Customer

  @Register_Login
  Scenario: Register to system and login
    Given Open Register page
    And Input to Email textbox
    And Click To Submit button
    Then Get User and password Infor
    When Back to Login page
    And Submit valid infor to login form
    Then Home page displayed

   @new_customer
   Scenario Outline: New Customer
   	Given Navigate to New Customer page
   	When Input to "Customer Name" textbox with value "<CustomerName>"
   	When Click to "Male Option" radio
   	When Input to "Date of birth" textbox with value "<DobIn>"
   	When Input to "Address" textbox with value "<Address>"
   	When Input to "City" textbox with value "<City>"
   	When Input to "State" textbox with value "<State>"
   	When Input to "Pin" textbox with value "<Pin>"
   	When Input to "Phone number" textbox with value "<Phone>"
   	When Input to "Email" textbox with value "<Email>"
   	When Input to "Password" textbox with value "<Password>"
   	When Click to "Submit" button
   	Then Verify message "Customer Registered Succesfully!!!" is displayed
   	And The correct value displayed at "<DobIn>" with value "<DobOut>"
   	
   	
   	Examples:
		|CustomerName | DobIn           | DobOut            | Address    | City    | State  | Pin   | Phone  | Email 													 | Password |
    | Joe Hart    | 09/13/1995     | 1905-09-13        | Ho Chi Minh| Thu Duc | Quan 9 | 65000 | 094232 | phamphannhatkhanh7520@gmail.com  | 12345678 |
    
    