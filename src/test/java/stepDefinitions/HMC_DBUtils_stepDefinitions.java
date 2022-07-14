package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.SQLException;

public class HMC_DBUtils_stepDefinitions {

    @Given("user connects to HMC database with DBUtils")
    public void user_connects_to_HCM_database_with_DBUtils() {
        DBUtils.getConnection();
    }

    @Given("user gets the data {string} in the table {string} with DBUtils")
    public void user_gets_the_data_in_the_table_with_DBUtils(String table, String field) {
        String query = "SELECT " + field + " FROM " + table;
        DBUtils.executeQuery(query);
    }

    @Given("user prints the data on the column {string} with DBUtils")
    public void user_prints_the_data_on_the_column_with_DBUtils(String field) {
        try {
            DBUtils.getResultset().first();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println(DBUtils.getResultset().getString(field));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user prints all {string} values in order with DBUtils")
    public void user_prints_all_values_in_order_with_DBUtils(String field)  {

        int lastRowNumber = 0;
        try {
            DBUtils.getResultset().last();
            lastRowNumber = DBUtils.getResultset().getRow();
            DBUtils.getResultset().first();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            for (int i = 1; i <= lastRowNumber; i++) {
                System.out.println("Record no : "+i+" : " +DBUtils.getResultset().getString(field));
                DBUtils.getResultset().next();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("DBUtill ile {int}. {string} in {int} oldugunu test eder")
    public void dbutillIleInOldugunuTestEder(int istenenSiraNo, String field, int expectedDeger) throws SQLException {

        DBUtils.getResultset().absolute(istenenSiraNo);
        double actualDeger = DBUtils.getResultset().getDouble(field);
        System.out.println("expected deger : " + expectedDeger);
        System.out.println("actual deger : " + actualDeger);
        Assert.assertTrue(actualDeger == expectedDeger);
    }

    @Then("tHOTEL tablosunda IDHotel degeri {int} olan kaydin Email bilgisini {string} yapar")
    public void thotelTablosundaIDHotelDegeriOlanKaydinEmailBilgisiniYapar(int idHotel, String yeniEmail) {

        String updateQuery = "UPDATE tHOTEL SET Email = '" + yeniEmail + "' WHERE IDHotel=" + idHotel + ";";
        DBUtils.executeQuery(updateQuery);

    }
}
