package Lesson9.HW9;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



public class MainHw9
{
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Arseniy",
                        Arrays.asList(new Course("Math"),
                                    new Course( "Java"),
                                    new Course("Python"),
                                    new Course("Eng"))));

        studentList.add(new Student("Boris",
                        Arrays.asList(new Course("Math"),
                                    new Course("Python"),
                                    new Course("German"))));

        studentList.add(new Student("Vasiliy",
                        Arrays.asList(new Course("Math"),
                                    new Course( "Philosophy"),
                                    new Course("Biology"))));

        studentList.add(new Student("Georgiy",
                        Arrays.asList(new Course("Math"),
                                    new Course( "Java"))));

/*
Написать функцию, принимающую список Student и возвращающую список уникальных курсов, на которые подписаны студенты.
беру у студентов курсы
превращаю в строку
выбираю уникальные
стрим закрывается
 */

        System.out.println("\n---------------Задание №1---------------");

        System.out.println("Список уникальных курсов :\n" + studentList.stream()
                .map(s -> s.getCourses())
                .flatMap(c -> c.stream())
                .distinct()
                .collect(Collectors.toList()));
                // вместо .distinct().collect(Collectors.toList()) можно .collect(Collectors.toSet()));

/*
Написать функцию, принимающую на вход список Student и возвращающую список из трех самых любознательных
(любознательность определяется количеством курсов).
сравниваю кол-во курсов у студентов
лимит на кол-во студентов с наибольшим кол-вом курсов
стрим закрывается
 */
        System.out.println("\n---------------Задание №2---------------");

        System.out.println("Список трёх самых любознательных студентов: \n" + studentList.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(3)
                .collect(Collectors.toList()));


/*
Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую список студентов,
которые посещают этот курс.
беру у студентов курсы, группирую, возвращаю значение false - если указанного элемента нет, true если список содержит указанный элемент.
 */
        System.out.println("\n---------------Задание №3---------------");

        Course course = new Course("Java");
        System.out.println("Список студентов посещяющих курс " + course + ": \n" + studentList.stream()
                .collect(Collectors.groupingBy(s -> s.getCourses().contains(course))));



        System.out.println("\n---------------Задание №3 второй вариант---------------");
        List<Student> studentList1 = studentList.stream()
                .filter(s -> s.getCourses().contains(course))
                .collect(Collectors.toList());
        System.out.println("Список студентов посещяющих курс " + course + ": \n" + studentList1);
    }
}
