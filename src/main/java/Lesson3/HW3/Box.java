package Lesson3.HW3;

import java.util.ArrayList;

public class Box<T extends Fruit>{

    public T getWeight;
    private ArrayList<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public float getWeight() {     // Метод ссумирования веса фруктов в коробке
        float weight = 0;

        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }

        return weight;
    }

    public boolean compare(Box<?> other) {      // Метод сравнивания

        return this.getWeight() == other.getWeight();
    }

    public void add(T fruit) {      // Метод добавления фруктов в коробку
        fruits.add(fruit);
    }   //Метод добавления

    public void moveAllFrom(Box<T> other) {      // Метод перемещения с проверкой
        if (this == other) {
            throw new MoveItselfException();
        } else {
            fruits.addAll(other.fruits);
            other.fruits.clear();
        }
    }
}
