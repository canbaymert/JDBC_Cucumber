Feature: US1005 User should be able to update data on the database
  @DBUtils
  Scenario: TC05 User updates data

    Given user connects to HMC database with DBUtils
    Then user replaces email data with the "usernew@gmail.com" of the record with ID 1017 on the table "tHOTEL"

