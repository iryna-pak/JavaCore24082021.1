package Lesson1.HW1;

public abstract class Barrier {
    public abstract void doIt(Obstacles obstacles);
}

class Jump extends Barrier {
    int height;

    public Jump(int height) {

        this.height = height;
    }

    @Override
    public void doIt(Obstacles obstacles) { // Метод прохождения препятсвия - прыжок

        obstacles.jump(height);
    }
}

class Swim extends Barrier {
    int length;

    public Swim(int length) {

        this.length = length;
    }

    @Override
    public void doIt(Obstacles obstacles) { // Метод прохождения препятсвия - заплыв

        obstacles.swim(length);
    }
}

class Run extends Barrier {
    int length;

    public Run(int length) {

        this.length = length;
    }

    @Override
    public void doIt(Obstacles obstacles) { // Метод прохождения препятсвия - забег

        obstacles.run(length);
    }
}

class MainCross {
    public static void main(String[] args) {
        Obstacles[] competitors = {
                new Wolf("Grizzly"),
                new Cat("Mursik"),
                new Dog("Bobik"),
                new Rabbit("Blue")};

        Barrier[] barriers = {new Jump(10), new Swim(3), new Run(100)};

        for (Obstacles c : competitors) {
            for (Barrier b : barriers) {
                b.doIt(c);
                if (!c.atDistance()) {
                    break;
                }
            }
        }
        for (Obstacles c : competitors) {
            c.info();
        }
    }
}
