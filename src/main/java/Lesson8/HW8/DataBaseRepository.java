package Lesson8.HW8;

import Lesson8.HW8.entity.Weather;
import Lesson8.HW8.entity.WeatherFiveDays;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseRepository {
    private static String DB = "jdbc:sqlite:Lesson8db.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveWeatherToDataBase(Weather weather) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB)) {
            String insertWeather = "insert into weatherOneDay (city, localdate, temperature) values (?, ?, ?)";
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            saveWeather.setString(1, weather.getCity());
            saveWeather.setString(2, weather.getLocalDate());
            saveWeather.setDouble(3, weather.getTemperature());
            saveWeather.execute();
            return;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Сохранение погоды в базу данных не выполнено!");
    }

    public void getSavedToDBWeather() {    //List тип возвращаемого значения
        List<Weather> weathers = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from weatherOneDay");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " "
                        + resultSet.getString("city") + " "
                        + resultSet.getString("localdate") + " "
                        + resultSet.getDouble("temperature"));
                weathers.add(new Weather(resultSet.getString("city"),
                        resultSet.getString("localdate"),
                        resultSet.getDouble("temperature")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void saveWeatherToDataBase5Days(WeatherFiveDays weatherFiveDays) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB)) {
            String insertWeatherFiveDays = "insert into weatherFiveDays (city, localdate, weatherTextDay," +
                    " weatherTextNight, minTemperature, maxTemperature) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement saveWeatherFiveDays = connection.prepareStatement(insertWeatherFiveDays);
            saveWeatherFiveDays.setString(1, weatherFiveDays.getCity());
            saveWeatherFiveDays.setString(2, weatherFiveDays.getLocalDate());
            saveWeatherFiveDays.setString(3, weatherFiveDays.getWeatherTextDay());
            saveWeatherFiveDays.setString(4, weatherFiveDays.getWeatherTextNight());
            saveWeatherFiveDays.setDouble(5, weatherFiveDays.getMinTemperature());
            saveWeatherFiveDays.setDouble(6, weatherFiveDays.getMaxTemperature());
            saveWeatherFiveDays.execute();
            return;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Сохранение погоды в базу данных не выполнено!");
    }

    public void getSavedToDBWeathers5Days() {
        List<WeatherFiveDays> weathers5Days = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from weatherFiveDays");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " "
                            + resultSet.getString("city") + " "
                            + resultSet.getString("localdate") + " "
                            + resultSet.getString("weatherTextDay") + " "
                            + resultSet.getString("weatherTextNight") + " "
                            + resultSet.getString("minTemperature") + " "
                            + resultSet.getDouble("maxTemperature") + " ");

                weathers5Days.add(new WeatherFiveDays(resultSet.getString("city"),
                        resultSet.getString("localdate"),
                        resultSet.getString("weatherTextDay"),
                        resultSet.getString("weatherTextNight"),
                        resultSet.getDouble("minTemperature"),
                        resultSet.getDouble("maxTemperature")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
