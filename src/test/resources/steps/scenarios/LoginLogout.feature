@LoginLogout
Feature: LoginLogout (Scenario that 1st sample.) 

	Scenario Outline:  Scenario that 1st sample.
	
    Given I check that user '<user>' is not empty.
    Given I check that password '<password>' is not empty.
    
    Given 'ALBANQUE_HOME' is opened.
    Then The ALBANQUE home page is displayed
      
    When I log in to ALBANQUE as '<user>' '<password>'
    Then The ALBANQUE portal is displayed with '<user>'
      
    When I log out of ALBANQUE
    Then The ALBANQUE logout page is displayed

    And I go back to 'ALBANQUE_HOME'
		
	Examples:
	  #DATA
	  |id|user|password|
    |1|axel|test|
    |2|toto|test|
    #END