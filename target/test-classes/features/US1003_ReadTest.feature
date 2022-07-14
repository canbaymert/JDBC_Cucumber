Feature: US1003 User should be able to test the given value
  @DBUtils
  Scenario: TC03 User tests the given value

    Given user connects to HMC database with DBUtils
    And user gets the data "Price" in the table "tHOTELROOM" with DBUtils
    And user prints the data on the column "Price" with DBUtils
    Then user asserts that the 2 value of "Price" is 4000 with DBUtils