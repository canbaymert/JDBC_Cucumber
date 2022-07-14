Feature: US1001 kullanici dogru bilgilerle database baglanabilmeli

  @db
  Scenario: TC01 Kullanici database'deki bilgileri okur

    Given user connects to HMC database
    And user gets the data "tHOTELROOM" in the table "Price"
    # SELECT Price FROM tHOTELROOM
    And user prints the data on the column "Price"

