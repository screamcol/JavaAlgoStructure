package Lesson_3.task_2;

import java.util.NoSuchElementException;

public class Deque {
    private int capacity;
    private int[] deque;
    private int head;
    private int tail;
    private int items;

    public Deque(int capacity) {
        this.capacity = capacity;
        deque = new int[capacity];
        head = 0;
        tail = -1;
        items = 0;
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

    public void insertRight(int value) {
        if (tail == capacity - 1) {
            capacity *= 2;
            int[] newDeque = new int[capacity];
            System.arraycopy(deque, 0, newDeque, 0, items);
            deque = newDeque;
        }
        deque[++tail] = value;
        items++;
    }

    public void insertLeft(int value) {
        if (head == 0) {
            capacity *= 2;
            int[] newDeque = new int[capacity];
            System.arraycopy(deque, 0, newDeque, capacity/2, items);
            deque = newDeque;
            head = capacity/2;
            tail = tail + head;
        }

        deque[--head] = value;
        items++;
    }

    public int removeRight() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        int temp = deque[tail--];
        items--;
        return temp;
    }

    public int removeLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        int temp = deque[head++];
        items--;
        return temp;
    }

    public int peekRight() {
        return deque[tail];
    }

    public int peekLeft() {
        return deque[head];
    }

    //t[h.........]
    // [h||||||t..]
    // [....h||t..]
    // [|t..h|||||]
    // [|t..................]

    //[.........h]t
    //[...t|||||h]
    //[|h...t||||]
    //[|h..................]
}
