package Lesson1.HW1;

public class Team {
    String nameTeam ;

    Obstacles[] partner = new Obstacles[4];

    public Team(String nameTeam,    // Формирую команду
                Obstacles command1,
                Obstacles command2,
                Obstacles command3,
                Obstacles command4 ) {
        this.nameTeam  = nameTeam;
        partner[0] = command1;
        partner[1] = command2;
        partner[2] = command3;
        partner[3] = command4;
    }

    public void passedTheDistance() {   // Вывод информации кто прошел дистанцию
        for (Obstacles command : partner) {
            if (command.atDistance()) {   // Если участник остался на дистанции, вывод его - true (Победители)
                command.info();
            }
        }
    }

    public void showResults() { // Вывод информации о членах команды
        for (Obstacles command : partner) {
            command.info();
        }
    }

    public Obstacles[] getTeammates() {    // геттер участников команды
        return partner;
    }
}
