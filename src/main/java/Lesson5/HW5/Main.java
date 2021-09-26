package Lesson5.HW5;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main (String[] args) throws IOException {
        AppData appData = new AppData();
        appData.save("Lesson5.csv");
        appData.load("Lesson5.csv");

        System.out.println(Arrays.toString(appData.getHeader()));
        System.out.println(Arrays.deepToString(appData.getData()));
    }

}