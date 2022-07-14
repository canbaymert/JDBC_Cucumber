Feature: US1004 User should be able to print values of the the given column
  @DBUtils
  Scenario: TC04 User prints the given column

    Given user connects to HMC database with DBUtils
    And user gets the data "Email" in the table "tHOTELROOM" with DBUtils
    And user prints the data on the column "Email" with DBUtils
    And user prints all "Email" values in order with DBUtils
