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
public class NodeTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Node n = new Node("Hello");
        assert(n.getValue().equals("Hello"));
        n.setNext(new Node("XX"));
        assert(n.getNext().getValue().equals("XX"));
                
    }
    
}
