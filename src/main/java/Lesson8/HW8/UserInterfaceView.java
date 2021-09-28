package Lesson8.HW8;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class UserInterfaceView {
    private Controller controller = new Controller();

    public void runInterface() {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            try {
                System.out.println("Введите имя города: ");
                String city = scanner.nextLine();

                System.out.println("Введите 1 для получения погоды на сегодня;\nВведите 2 для прогноза погоды на 5 дней;\n" +
                                "Введите 3 для получения ВСЕХ данных на сегодня из базы;\n" +
                                "Введите 4 для получения ВСЕХ данных из базы на 5 дней;\n" +
                                "Введите 0 для выхода: ");
                String command = scanner.nextLine();
                if (command.equals("0")) break;

                controller.getWeather(command, city);

            } catch (IOException | SQLException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("!!!!!!!!!!!Не верный формат ввода данных. Попробуйте ещё раз!!!!!!!!!!!");
            } catch (NullPointerException e) {
                System.out.println("!!!!!!!!!!!Вы ввели не существующий параметр. Попробуйте ещё раз!!!!!!!!!!!");
            }
        }
    }
}
