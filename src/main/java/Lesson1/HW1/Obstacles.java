package Lesson1.HW1;

public interface Obstacles {
    void run(int dist);

    void swim(int dist);

    void jump(int height);

    boolean atDistance();

    void info();
}
