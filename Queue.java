/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.khan.ics4u.u5;

/**
 *
 * @author 1khanmeh3
 */
public class Queue implements QueueInterface {

    //default capacity
    private final static int DEF_CAPACITY = 11;

    private String[] queue;
    private int capacity;
    private int head = -1;
    private int tail = -1;

    //DEFAULT SIZE
    public Queue() {
        capacity = DEF_CAPACITY;
        queue = new String[DEF_CAPACITY];
    }

    //SIZE GIVEN
    public Queue(int size) {
        queue = new String[size];
        capacity = size;

    }

    //toString
    @Override
    public String toString() {
        for (int i = 0; i < capacity(); i++) {
            if (tail == i) {
                System.out.format("|%5s|", "T  ");
            } else if (head == i) {
                System.out.format("|%5s|", "H  ");
            } else if (head == i && tail == i) {
                System.out.format("|%5s|", " T/H  ");
            } else {
                System.out.format("|%5s|", "X  ");
            }
        }
        System.out.println("");
        for (int i = 0; i < capacity(); i++) {
            if (this.queue[i] == null) {
                System.out.format("|%5s|", "Null  ");
            } else {
                System.out.format("|%5s|", this.queue[i] + "  ");
            }
        }
        return "";
    }

    public int size() {
        if (head == -1) {
            return 0;
        }
        if (tail > head) {
            return (tail - head + 1);
        }
        if (tail == head) {
            return 1;
        }
        return ( (head  + capacity) - head);

    }

    public int capacity() {
        return capacity;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isFull() {
        return size() == capacity;
    }

    public String dequeue() {
        
        if (this.isEmpty() == true) {
            System.out.println("STACK IS EMPTY");
            return null;
        }
        int toDel = head;

        if (head + 1 != capacity) {
            head++;
        } else {
            head = -1;
            tail = -1;
        }

        return this.queue[toDel];
    }

    public void enqueue(String value) {

        if (this.isFull() == true) {
            System.out.println("STACK IS FULL");
        } else {
            if (head == -1) {
                head++;
                tail++;
            } else if (tail + 1 != capacity) {
                tail++;
            } else {
                tail = 0;
            }
            this.queue[tail] = value;
        }
    }

    public String head() {
        if (head == -1) {
            return null;
        }
        return this.queue[head];
    }

    public String tail() {
        if (tail == -1) {
            return null;
        }
        return this.queue[tail];
    }

    public void makeEmpty() {
//        for (int i = 0; i < this.capacity(); i++) {
//            this.dequeue();
//        }
        tail = -1;
        head = -1;

    }

}
