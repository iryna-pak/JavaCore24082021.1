package Lesson8.HW8;

import java.io.IOException;
import java.sql.SQLException;

public interface WeatherModel {
    void getWeather(String selectedCity, Period period) throws IOException, SQLException;

    void getSavedToDBWeather();
    void getSavedToDBWeathers5Days();

}