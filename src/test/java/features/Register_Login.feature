Feature: Register And Login to BankGuru Application
	As a Tester
  I want to register and login account
  So that I could verify login function work well

  @Register_Login
  Scenario Outline: Register and Login to BankGuru application
    Given I want to navigate to url "http://demo.guru99.com/"
    When I input Email ID with value "<Email_ID>"
    And I click Submit button
    Then I get User ID with value "<UserID>"
    And  I get Password with value "<Password>"
   
    When I want to navigate to url "http://demo.guru99.com/v4/" to login
    And I input UserID with value "<UserID>"
    And I input Password with value "<Password>"
    And I click Login button
    Then I verified marquee displayed with text "Welcome To Manager's Page of Guru99 Bank"
    And I verified Manager ID displayed with value "<UserID>"

		Examples: Registration Info
		
			| Email_ID							| 	UserID			| Password		|
			| khanhppn@yopmail.com  |		mngr293070	|	yhAsEsA			|