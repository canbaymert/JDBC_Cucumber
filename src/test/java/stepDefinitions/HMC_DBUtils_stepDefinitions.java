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
    public void user_gets_the_data_in_the_table_with_DBUtils (String field, String table) {
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

    @Then("user asserts that the {int} value of {string} is {int} with DBUtils")
    public void user_asserts_that_the_value_of_is_with_DBUtils (int rowNumber, String field, int expectedValue) {
        try {
            DBUtils.getResultset().absolute(rowNumber);
            double ActualValue = DBUtils.getResultset().getDouble(field);
            System.out.println("Expected Value : " + expectedValue);
            System.out.println("Actual Value : " + ActualValue);
            Assert.assertTrue(ActualValue == expectedValue);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("user replaces email data with the {string} of the record with ID {int} on the table {string}")
    public void user_replaces_email_data_with_the_of_the_record_with_ID_on_the_table (String newEmail, int ID, String table) {
        String updateQuery = "UPDATE "+table+" SET Email = '" + newEmail + "' WHERE IDHotel=" + ID + ";";
        DBUtils.executeQuery(updateQuery);
    }
}
