Feature: US1005 Kullanici databasede update yapar

  Scenario: TC05 Kullanici update yapabilmeli

    Given user connects to HMC database with DBUtils
    Then tHOTEL tablosunda IDHotel degeri 1017 olan kaydin Email bilgisini "bendenBuKadar@gmail.com" yapar
    # UPDATE tHOTEL SET Email = 'sizOldunuz@gmail.com' WHERE IDHotel=1016;
