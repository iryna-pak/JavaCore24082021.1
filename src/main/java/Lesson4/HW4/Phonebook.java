package Lesson4.HW4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
/*
2. Написать простой класс «Телефонный Справочник», который хранит в себе список фамилий и телефонных номеров. В этот
телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать номер телефона
по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при
запросе такой фамилии должны выводиться все телефоны.
Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес), взаимодействие с пользователем
через консоль и т.д). Консоль использовать только для вывода результатов проверки телефонного справочника.
 */
public class Phonebook {

    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();

        phonebook.add("Абакумов", 10000000);
        phonebook.add("Абакумов", 11111111);
        phonebook.add("Абакумов", 22222222);
        phonebook.add("Бобров", 33333333);
        phonebook.add("Винокур", 44444444);
        phonebook.add("Гайморов", 55555555);
        phonebook.add("Дубовой", 66666666);
        phonebook.add("Дубовой", 77777777);

        // Проверки
        phonebook.get("Ермолаев");
        phonebook.add("Дубовой", 77777777);
        phonebook.add("Винокур", 88888888);

        //Запросы
        phonebook.get("Абакумов");
        phonebook.get("Винокур");
        phonebook.get("Дубовой");
    }

    private HashMap<String, ArrayList<Integer>> phoneBook;

    public Phonebook() {
        this.phoneBook = new HashMap<>();
    }

    public void add(String surname, int phoneNumber) {
        if(phoneBook.containsKey(surname)) {
            ArrayList<Integer> phoneNumbers = phoneBook.get(surname);
            if (!phoneNumbers.contains(phoneNumber)) {
                phoneNumbers.add(phoneNumber);
                System.out.println("Номер " + phoneNumber + " добавлен для " + surname);
            } else {
                System.out.println("Номер " + phoneNumber + " уже записан под фамилией " + surname);
            }
        } else {
            phoneBook.put(surname, new ArrayList<>(Arrays.asList(phoneNumber)));
            System.out.println("Номер " + phoneNumber + " добавлен для " + surname);
        }
    }

    public void get(String surname) {
        if (phoneBook.containsKey(surname)) {
            System.out.println(surname + ": " + phoneBook.get(surname));
        } else {
            System.out.println("В справочнике нет записи с фамилией " + surname);
        }
    }
}
