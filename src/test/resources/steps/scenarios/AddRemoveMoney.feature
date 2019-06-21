@AddRemoveMoney
Feature: AddRemoveMoney (&quot;Add)

  Scenario Outline:  &quot;Add

    Given I check that user '<user>' is not empty.
    Given I check that password '<password>' is not empty.

    Given 'ALBANQUE_HOME' is opened.
    Then The ALBANQUE home page is displayed

    And I go back to 'ALBANQUE_HOME'

  Examples:
    #DATA
    |id|user|password|
    #END
