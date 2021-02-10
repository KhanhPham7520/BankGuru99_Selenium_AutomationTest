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
   	Given Open "New Customer" page
   	When Input to "Customer Name" textbox with value ""
   	When Click to "Male Option" radio
   	When Input to "Date of birth" textbox with value ""
   	When Input to "Address" textbox with value ""
   	When Input to "City" textbox with value ""
   	When Input to "State" textbox with value ""
   	When Input to "Phone number" textbox with value ""
   	When Input to "Email" textbox with value ""
   	When Input to "Password" textbox with value ""
   	When Click to "Submit" button
   	Then Verify message "Customer Registered Succesfully!!!" is displayed
   	And The correct value displayed at "" with value ""
   	
   	
   	Examples:
		|Customer Name| DobIn           | DobOut            | Address    | City    | State  | Pin   | Phone  | Email 													 | Password |
    | Joe Hart    | 09/13/1995      | 1905-09-13        | Ho Chi Minh| Thu Duc | Quan 9 | 65000 | 094232 | phamphannhatkhanh7520@gmail.com | 12345678 |
    
    