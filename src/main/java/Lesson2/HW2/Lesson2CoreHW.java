package Lesson2.HW2;

/*
    -Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При подаче массива другого
    размера необходимо бросить исключение MyArraySizeException.
    -Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
    -Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
     должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
    -В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и
    MyArrayDataException и вывести результат расчета.
*/

import java.util.Arrays;

public class Lesson2CoreHW {
    public static void main (String[] args) {
        String[][] arrCorrect = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] arrIncorrect1 = {
                {"a", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "7", "12"},
                {"13", "14", "15", "8"}
        };

        String[][] arrIncorrect2 = {
                {"1", "2",},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] arrIncorrect3 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "7", "12"},
        };

        System.out.println("Массив 1:");
        System.out.println(Arrays.deepToString(arrCorrect));
        testArray(arrCorrect);

        System.out.println("Массив 2:");
        System.out.println(Arrays.deepToString(arrIncorrect1));
        testArray(arrIncorrect1);

        System.out.println("Массив 3:");
        System.out.println(Arrays.deepToString(arrIncorrect2));
        testArray(arrIncorrect2);

        System.out.println("Массив 4:");
        System.out.println(Arrays.deepToString(arrIncorrect3));
        testArray(arrIncorrect3);
    }
    public static void testArray(String[][] array){
        try {
            System.out.println("Сумма всех элементов массива равна " + converter(array) + ".\n");
        } catch (MyArrayDataException | MyArraySizeException e) {
            System.out.println(e.getMessage());
        }
    }
    public static int converter(String[][] array) {
        int sum = 0;

        if (array.length != 4) {
            throw new MyArraySizeException("Количество строк в масиве должно быть 4\n");
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException(String.format("Неверное количество столбцов в %d-й" + " строке" +"\n", i));
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}
