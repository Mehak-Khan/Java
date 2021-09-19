/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2s03.assignment2;

/**
 *
 * @author mehakkhan
 */
public class PriorityNode {

    public PriorityNode next;
    private MyQueue queue;

    public PriorityNode() {
        queue = new MyQueue();
    }

    public MyQueue getQeueue() {
        return queue;
    }

}
