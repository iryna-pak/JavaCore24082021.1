package Lesson1.HW1;

public class Main {
    public static void main(String[] args) {
        Course c = new Course(new Jump(10), new Swim(3), new Run(100)); // Создаем полосу препятствий
        Team team = new Team("Звери",   // Создаю команду
                new Wolf("Grizzly"),
                new Cat("Murzik"),
                new Dog("Bobik"),
                new Rabbit("Blue"));
        c.doIt(team); // Вызов метода прохождения командой препятсвий

        System.out.println("\nПобедители:");
        team.passedTheDistance();   // Вызов метода вывода информации кто остался на дистанцию

        System.out.println("\nРезультат:");
        team.showResults(); // Вызов метода вывода информации о членах команды
    }
}
