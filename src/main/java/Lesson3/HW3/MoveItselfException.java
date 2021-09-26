package Lesson3.HW3;

public class MoveItselfException extends RuntimeException {
    public MoveItselfException() {
        super("Нельзя пересыпать в самого себя!");
    }
}
