package Lesson_3.task_1;

import java.util.NoSuchElementException;

public class Stack {
    private char[] stack;
    private int capacity;
    private int top;

    public Stack(int capacity) {
        this.stack = new char[capacity];
        this.capacity = capacity;
        this.top = -1;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isFull() {
        return this.top == this.capacity - 1;
    }

    public void push(char value) {
        if (isFull()) {
            capacity *= 2;
            char[] newStack = new char[capacity];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }
        stack[++top] = value;
    }

    public char pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        return stack[top--];
    }

    public int peek() {
        return stack[top];
    }
}
