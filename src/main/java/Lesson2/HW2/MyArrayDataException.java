package Lesson2.HW2;

public class MyArrayDataException extends NumberFormatException{

    public MyArrayDataException(int i, int j) {
        super(String.format("Данные в ячейке [%d, %d] не могут быть преобразованы в цифровой формат\n", i, j));
    }
}
