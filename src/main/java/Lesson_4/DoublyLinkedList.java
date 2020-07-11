package Lesson_4;

import java.util.Objects;

public class DoublyLinkedList {

    private class Node {
        Cat c;
        Node next;
        Node prev;

        public Node(Cat c) {
            this.c = c;
        }

        @Override
        public String toString() {
            return c.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return c.equals(node.c);
        }

        @Override
        public int hashCode() {
            return Objects.hash(c);
        }
    }

    class DoublyLinkedListIterator {
        private Node current;
        private Node previous;
        private DoublyLinkedList list;
        public DoublyLinkedListIterator (DoublyLinkedList list ){
            this.list = list;
            this.reset();
        }
        public void reset (){
            current = list.getFirst();
            previous = null;
        }
        public boolean atEnd (){
            return (current.next == null);
        }

        public void nextLink (){
            previous = current;
            current = current.next;
        }

        public Node getCurrent (){
            return current;
        }

        public void insertAfter (Cat c){
            Node newLink = new Node(c);
            if (list.isEmpty()){
                list.setFirst ( newLink );
                current = newLink;
            } else {
                newLink.next = current.next;
                current.next = newLink;
                nextLink();
            }
        }
        public void insertBefore (Cat c){
            Node newLink = new Node(c);
            if (previous == null){
                newLink.next = list.getFirst();
                list.setFirst(newLink);
                reset();
            }
            else{
                newLink.next = previous.next;
                previous.next = newLink;
                current = newLink;
            }
        }
        public String deleteCurrent (){
            String name = current.c.getName();
            if (previous == null){
                list.setFirst(current.next );
                reset ();
            } else {
                previous.next = current.next;
                if ( atEnd ()){
                    reset ();
                } else {
                    current = current.next;
                }
            }
            return name;
        }
    }

    private Node head;
    private int size;

    public boolean isEmpty() {
        return head == null;
    }

    public Node getFirst() {
        return head;
    }

    public void setFirst(Node head) {
        this.head = head;
    }

    public void push(Cat c) {
        Node newNode = new Node(c);
        newNode.next = head;
        newNode.prev = null;
        if (head != null)
            head.prev = newNode;
        head = newNode;
    }

    public void append(Cat c) {
        Node newNode = new Node(c);
        Node last = head;

        newNode.next = null;
        if (head == null) {
            newNode.prev = null;
            head = newNode;
            return;
        }
        while (last.next != null)
            last = last.next;
        last.next = newNode;
        newNode.prev = last;
    }

    public Cat pop() {
        if (isEmpty()) return null;
        Cat temp = head.c;
        head = head.next;
        size--;
        return temp;
    }


    @Override
    public String toString() {
        Node current = head;
        StringBuilder sb = new StringBuilder("[");
        while (current != null) {
            sb.append(current);
            current = current.next;
            sb.append((current == null) ? "]" : ", ");
        }
        return sb.toString();
    }

    public boolean contains(Cat c) {
        return find(c) == null;
    }

    private Node find(Cat c) {
        if (isEmpty()) return null;
        Node current = head;
        while (!current.c.equals(c)) {
            if (current.next == null)
                return null;
            else
                current = current.next;
        }
        return current;
    }

    public boolean delete(Cat c) {
        Node current = head;
        Node previous = head;
        while (!current.c.equals(c)) {
            if (current.next == null) {
                return false;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current == head) {
            head = head.next;
        } else {
            previous.next = current.next;
        }
        return true;
    }
}
