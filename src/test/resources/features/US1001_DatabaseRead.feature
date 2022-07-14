Feature: US1001 User should connect to the database with a correct login information

  @db
  Scenario: TC01 User prints the data from the database

    Given user connects to HMC database
    And user gets the data "tHOTELROOM" in the table "Price"
    And user prints the data on the column "Price"

