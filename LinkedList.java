/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.khan.ics4u.u5;

/**
 *
 * @author mehakkhan
 */
public class LinkedList implements LinkedListInterface {

    private String obj;
    private Node head = null;
    private Node tail = null;
    //private int size = 0;

    public LinkedList() {
        this.obj = null;
    }

    public LinkedList(String obj) {
        this.obj = obj;
    }

    public void addAtFront(String str) {
        //size++;
        if (head == null) {
            head = new Node(str);
            tail = head;
        } else {
            head = new Node(str, head);
        }

    }

    public void addAtEnd(String str) {
       // size++;
        if (head == null) {
            addAtFront(str);

        } else {
            tail.setNext(new Node(str));
            tail = tail.getNext();
        }
    }

    public String removeHead() {
        if (isEmpty()) {
            System.out.println("NO HEAD TO REMOVE");
            return null;
        }
       // size--;
        Node toDelete = head;
        head = head.getNext();
        return toDelete.getValue();
    }

    public String removeTail() {

        if (isEmpty()) {
            System.out.println("NO TAIL TO REMOVE");
            return null;
        }

       // size--;
        Node toDelete = tail;
        Node n = head;
        while (n.getNext() != tail) {
            n = n.getNext();
        }
        tail = n;
        n.setNext(null);

        return toDelete.getValue();

    }

    public void remove(String str) {
        if (isEmpty()) {
            System.out.println("IS EMPTY");
        } else if (str.equals(head.getValue())) {
            this.removeHead();
        } else if (str.equals(tail.getValue())) {
            this.removeTail();
        } else {
           // size--;
            Node current = head;

            for (int i = 0; i < size() - 1; i++) {

                if (current.getNext().getValue().equals(str)) {

                    //System.out.println("YO");
                    Node toDelete = current.getNext();
                    current.setNext(current.getNext().getNext());

                }
                current = current.getNext();
            }

        }
    }

    public boolean isFull() {
        return false;
    }

    public boolean isEmpty() {
        return (head == null);

    }

    public int size() {
        int size = 0;
        Node n = head;
        while (n != null) {
            size++;
            n = n.getNext();
        }
        return size;
    }

    public String toString() {
        String str = "";
        Node current = head;
        while (current != null) {
            if (current == head && current == tail) {
                str += String.format("%-5s", "H/T");

            } else if (current == tail) {
                str += String.format("%-5s", "T");
            } else if (current == head) {
                str += String.format("%-5s", "H");
            } else {
                str += String.format("%-5s", "");
            }
            current = current.getNext();

        }

        str += "\n";
        current = head;

        while (current != null) {
            str += String.format("%-5s", current.getValue());
            current = current.getNext();
        }
        return str;
    }

    public void makeEmpty() {
        head = null;
        tail = null;

    }

    public int capacity() {
        return Integer.MAX_VALUE;

    }

    public String head() {
        if (isEmpty()) {
            return null;
        }
        return head.getValue();

    }

    public String tail() {
        if (isEmpty()) {
            return null;
        }
        return tail.getValue();

    }

}
