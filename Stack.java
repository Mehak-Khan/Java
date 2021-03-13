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
public class Stack implements StackInterface {

    //default capacity
    private final static int DEF_CAPACITY = 11;

    private String[] stack;
    private int capacity;
    private int top = -1;

    //DEFAULT SIZE
    public Stack() {
        capacity = DEF_CAPACITY;
        stack = new String[DEF_CAPACITY];
    }

    //SIZE GIVEN
    public Stack(int size) {
        stack = new String[size];
        capacity = size;

    }

    public int size() {
        return top + 1;
    }

    public int capacity() {
        return capacity;
    }

    public boolean isEmpty() {
        return (size() == 0);
    }

    public boolean isFull() {
        return (size() == capacity );
    }

    public void makeEmpty() {
//        for (int i = 0; i < this.capacity(); i++) {
//            this.pop();
//        }
            top = -1;

    }

    public String peek() {
        if (this.isEmpty() == true) {
            System.out.println("STACK IS EMPTY");
            return null;
        } else {
            return this.stack[top];
        }

    }

    public String pop() {

        if (this.isEmpty() == true) {
            System.out.println("STACK IS EMPTY");
            return null;
        } else {
            top--;
            return this.stack[top + 1];

        }
    }

    public void push(String value) {

        if (this.isFull() == true) {
            System.out.println("STACK IS FULL");
        } else {
            top++;
            this.stack[top] = value;
        }

    }
    
    public String toString() {
        for (int i = 0; i < this.size(); i++) {
            System.out.print(this.stack[i]);
            
        }
        return "";
    }

}
