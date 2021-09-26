package Lesson5.HW5;

import java.io.*;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class AppData {

    private String[] headers;
    private Integer[][] data;

    public AppData() {
        headers = new String[]{"Value 1", "Value 2", "Value 3"};
        data = new Integer[][]{{100, 200, 300}, {400, 500, 600}};
    }

    public String[] getHeader() {
        return headers;
    }

    public Integer[][] getData() {
        return data;
    }
/*
    public void setHeaders(String[] headers) {
        this.headers = headers;
    }
    public  void  setData(Integer[][] data){
        this.data = data;
    }
 */

    private <T> String rowToString(T[] row) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < row.length; i++) {
            if (i < row.length - 1) {
                result.append(row[i]).append(";");
            } else {
                result.append(row[i]);
            }
        }
        result.append("\n");
        return result.toString();
    }

    public void save(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(rowToString(headers));
            for (var arrayData : data) writer.write(rowToString(arrayData));
            writer.flush();   //выталкивает из буфера в поток вывода
        }
    }

    public void load(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            //обнулила данные объектов, чтобы не осталось старых данных в случае не успешного чтения файла
            headers = new String[]{};
            data = new Integer[][]{};

            String tempString;

            tempString = reader.readLine();
            if (tempString != null) {    // Если заголовок не пустой, выделить данные(распарсить)
                headers = tempString.split(";");

                ArrayList<Integer[]> arrayList = new ArrayList<>();
                while ((tempString = reader.readLine()) != null) {
                    String[] arr = tempString.split(";");
                    Integer[] intArray = new Integer[arr.length];
                    for (int i = 0; i < arr.length; i++) {
                        intArray[i] = parseInt(arr[i]);
                    }
                    arrayList.add(intArray);
                }
                data = arrayList.toArray(new Integer[][]{});
            }
        }
    }
}
