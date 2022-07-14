package stepDefinitions;

import io.cucumber.java.en.Given;

import java.sql.*;

public class HMC_db_stepDefinitions {

    String url="jdbc:sqlserver://184.168.194.58:1433;databaseName=hotelmycamp ; " +
            "user=techproed;password=P2s@rt65";
    String username="techproed";
    String password="P2s@rt65";

    Connection connection; // Establish a connection to the database
    Statement statement; // Runs a query
    ResultSet resultSet; // Stores the result


    @Given("user connects to HMC database")
    public void user_connects_to_HMC_database() throws SQLException {
        connection= DriverManager.getConnection(url,username,password);
        statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }
    @Given("user gets the data {string} in the table {string}")
    public void user_gets_the_data_in_the_table (String field, String table) {
        String query = "SELECT "+field+" FROM "+ table;
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Given("user prints the data on the column {string}")
    public void user_prints_the_data_on_the_column (String field)  {

        // resultSet works like an iterator

        try {
            resultSet.first();
            System.out.println(resultSet.getString("Price"));// 225.0000
            resultSet.next(); // moves to the next data and returns boolean
            System.out.println(resultSet.getString("Price")); // 4000.0000

            System.out.println(resultSet.next()); // true
            System.out.println(resultSet.getString("Price")); // 445.0000

            System.out.println("===============List===============");
            resultSet.absolute(0);
            int line=1;
            while(resultSet.next()){
                System.out.println(line+". record : " + resultSet.getString(field));
                line++;
            }

            // Number of the records on the table
            resultSet.last();
            System.out.println(resultSet.getRow()); // 416

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
