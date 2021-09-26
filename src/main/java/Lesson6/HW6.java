package Lesson6;

/*
1. С помощью http запроса получить в виде json строки погоду в Санкт-Петербурге на период времени, пересекающийся со
следующим занятием (например, выборка погода на следующие 5 дней - подойдет)
2. Подобрать источник самостоятельно. Можно использовать api accuweather, порядок следующий: зарегистрироваться,
зарегистрировать тестовое приложение для получения api ключа, найдите нужный endpoint и изучите документацию.
Бесплатный тарифный план предполагает получение погоды не более чем на 5 дней вперед (этого достаточно для выполнения
 д/з).
 */

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class HW6 {
    public static void main(String[] args) {
        // Экземпляр класса OkHttpClient выполняет всю работу по созданию и отправке запросов
        OkHttpClient okHttpClient = new OkHttpClient();
        // Экземпляр класса Request создается через Builder
        Request request = new Request.Builder()
                .url("http://dataservice.accuweather.com/forecasts/v1/daily/5day/295212?apikey=Kzd2AUyPnBnlKWtqSRdmMYl7TRyjo7gC")
                .build();

        try {
            // Получение объекта ответа от сервера
            Response response = okHttpClient.newCall(request).execute();
            // Тело сообщения возвращается методами объекта Response
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
