package Lesson4.HW4;

import java.util.*;
/*
1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных слов,
 из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое слово.
 */
public class Task_1_Lesson4 {

    public static void main(String[] args) {
        ArrayList<String> wordList = new ArrayList<>(Arrays.asList("Арнольд", "Марина", "Борис", "Светлана",
                "Михаил", "Ирина", "Наталья", "Сергей",
                "Марина", "Светлана", "Ирина", "Наталья",
                "Марина", "Светлана", "Ирина", "Наталья",
                "Марина", "Светлана"));
        System.out.println("\nПервоночальный список: " + wordList);


        Set<String> wordsListUnique = new LinkedHashSet<>(wordList);
        System.out.println("\nУникальные слова в списке: " + wordsListUnique);


        System.out.println("\nЧастота повторения слов: ");
        for (String key : wordsListUnique) {
            System.out.println(key + ": "+ Collections.frequency(wordList, key) + " раз");
        }
    }
}
