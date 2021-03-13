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
public class LinkedListTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList L = new LinkedList();
        System.out.println(L.toString());
        L.addAtFront("A");
        L.addAtFront("B");
        L.addAtEnd("C");
        L.addAtEnd("D");
        L.removeHead();
        L.removeTail();
        L.addAtEnd("Y");
        L.remove("C");
        L.remove("Y");
        L.addAtEnd("D");
        L.addAtFront("S");
        L.remove("A");
        System.out.println(L.size());
        System.out.println(L.toString());

    }

}
