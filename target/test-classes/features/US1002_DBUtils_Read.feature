Feature: US1002 User connects to the database with DBUtils
  @DBUtils
  Scenario: TC02 User prints the data from the database with DBUtils

    Given user connects to HMC database with DBUtils
    And user gets the data "Price" in the table "tHOTELROOM" with DBUtils
    And user prints the data on the column "Price" with DBUtils