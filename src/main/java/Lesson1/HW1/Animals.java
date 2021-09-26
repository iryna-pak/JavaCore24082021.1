package Lesson1.HW1;

public class Animals implements Obstacles {
    String type;
    String name;

    int maxRunDistance;
    int maxJumpHeight;
    int maxSwimDistance;

    boolean onDistance;

    public Animals(String type, String name, int maxRunDistance, int maxJumpHeight, int maxSwimDistance) {
        this.type = type;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.maxSwimDistance = maxSwimDistance;
        this.onDistance = true;
    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.println(type + " - " + name + " справился с прыжком");
        } else {
            System.out.println(type + " - " + name + " не смог преодалеть прыжок");
            onDistance = false;
        }
    }

    @Override
    public void swim(int distance) {
        if (maxSwimDistance == 0){
            System.out.println(type + " - " + name + " не умеет плавать!");
            onDistance = false;
            return;
        }
        if (distance <= maxSwimDistance) {
            System.out.println(type + " - " + name + " справился с заплывом");
        } else {
            System.out.println(type + " - " + name + " не смог преодалеть заплыв");
            onDistance = false;
        }
    }

    @Override
    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println(type + " - " + name + " справился с бегом");
        } else {
            System.out.println(type + " - " + name + " не смог преодалеть забег");
            onDistance = false;
        }
    }

    @Override
    public boolean atDistance() {
        return onDistance;
    }

    @Override
    public void info() {
        System.out.println(type + " - " + name + " " + onDistance);
    }
}
