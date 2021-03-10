package lesson8;

import java.sql.*;
import java.util.List;

public class RepositoryDB {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public void addToDB(List<WeatherResponse> weatherResponseList) {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:weather.db");
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS weatherResponse");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS weatherResponse (city STRING NOT NULL," +
                    " localDate STRING NOT NULL, weatherText STRING, temperature DOUBLE);");
            for (int i = 0; i < weatherResponseList.size(); i++) {
                statement.executeUpdate(
                        "INSERT INTO weatherResponse (city, localDate, weatherText, temperature) VALUES " +
                                "('" + weatherResponseList.get(i).getCityName() + "'," +
                                " '" + weatherResponseList.get(i).getDate() + "'," +
                                " '" + weatherResponseList.get(i).getText() + "'," +
                                " " + weatherResponseList.get(i).getTemperature() + ");");
            }

            connection.close();
            statement.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public void showDateBase() {

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:weather.db");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM weatherResponse");
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getString(1) + " | " +
                                resultSet.getString(2) + " | " +
                                resultSet.getString(3) + " | " +
                                resultSet.getDouble(4) + " | ");
            }
            resultSet.close();
            connection.close();
            statement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }


}
