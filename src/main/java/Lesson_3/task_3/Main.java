package Lesson_3.task_3;

public class Main {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(10);
        pq.insert(2);
        pq.insert(4);
        pq.insert(3);
        pq.insert(8);

        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }
}
