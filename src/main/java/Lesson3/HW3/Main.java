package Lesson3.HW3;

public class Main {
    public static void main(String[] args) {

        Box<Apple> appleBox = new Box<>();
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        System.out.println("Вес коробки с яблоками №1: " + appleBox.getWeight());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        System.out.println("Вес коробки с апельсинами: " + orangeBox.getWeight());

        System.out.println("Сравнение масс коробок: " + appleBox.compare(orangeBox));

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.add(new Apple());
        appleBox2.add(new Apple());
        System.out.println("Вес коробки с яблоками №2: " + appleBox2.getWeight());

        appleBox2.moveAllFrom(appleBox);
        System.out.println("Вес коробки с яблоками №1 после перемещения яблок в коробку №2: " + appleBox.getWeight());
        System.out.println("Текущий вес коробки с яблоками №2: " + appleBox2.getWeight());

        try {
            appleBox2.moveAllFrom(appleBox2);
        } catch (MoveItselfException e) {
            System.out.println(e.getMessage());
        }
    }
}
