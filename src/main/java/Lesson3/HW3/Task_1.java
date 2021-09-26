package Lesson3.HW3;

import java.util.Arrays;

public class Task_1 {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7};

        System.out.println("Начальний массив:  " + Arrays.toString(array));
        changeElements(array, 0, 1);
        changeElements(array, 2, 3);
        changeElements(array, 4, 5);
        System.out.println("Конечный массив:  " + Arrays.toString(array));
    }

    public static void changeElements (int[] array, int i, int j) {

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }
}
