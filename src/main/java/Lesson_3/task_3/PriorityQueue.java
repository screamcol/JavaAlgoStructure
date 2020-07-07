package Lesson_3.task_3;

import java.util.NoSuchElementException;

public class PriorityQueue {
    private int capacity;
    private int[] priorityQueue;
    private int items;

    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        this.priorityQueue =new int[capacity];
        this.items = 0;
    }

    public boolean isEmpty() {
        return items == 0;
    }

    public boolean isFull() {
        return items == capacity;
    }

    public int size() {
        return items;
    }

    public void insert(int value) {
        if (items == 0) {
            priorityQueue[items++] = value;
        } else {
            if (isFull()) {
                capacity *= 2;
                int[] newQ = new int[capacity];
                System.arraycopy(priorityQueue, 0, newQ, 0, items);
                priorityQueue = newQ;
            }

            int i;
            for (i = items - 1; i >= 0; i--) {
                if (value > priorityQueue[i]) {
                    priorityQueue[i + 1] = priorityQueue[i];
                } else break;
            }
            priorityQueue[i + 1] = value;
            items++;
        }
    }

    public int remove() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        return priorityQueue[--items];
    }

    public int peek() {
        return priorityQueue[items - 1];
    }
}
