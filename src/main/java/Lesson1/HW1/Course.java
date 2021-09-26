package Lesson1.HW1;

public class Course {
    Barrier[] course = new Barrier[3];

    public Course(Barrier b1, Barrier b2, Barrier b3) { // Создала полосы препятствий
        course[0] = b1;
        course[1] = b2;
        course[2] = b3;
    }

    public void doIt(Team t) {  // Метод прохождения командой препятствий
        System.out.println("\nTeam \"" + t.nameTeam + "\":\n");
        for (Obstacles com : t.getTeammates()) {    // Пробег по каждому участнику команды
            for (Barrier b: course) {   //Пробег по каждому препятствию
                b.doIt(com);    //Вызов метода прохождения препятствия текущим участником команды
            }
        }
    }
}
