package Lesson_3.task_2;

public class Main {
    public static void main(String[] args) {
        Deque dq = new Deque(3);
        dq.insertRight(2);
        dq.insertLeft(1);
        dq.insertRight(3);
        dq.insertLeft(7);

        while (!dq.isEmpty()) {
            System.out.println(dq.removeLeft());
        }
//        System.out.println(dq.peekLeft());
//        System.out.println(dq.peekRight());
    }
}
