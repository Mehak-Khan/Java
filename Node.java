/**
 * Node.
 *
 * @author Wm.Muir
 * @version 2018-19.S2
 */
package edu.hdsb.gwss.khan.ics4u.u5;

/**
 * TODO
 */
public class Node implements NodeInterface {

    private String obj;
    private Node next;

    public Node() {
        this.obj = null;
        this.next = null;
    }
    
    public Node(String obj) {
        this.obj = obj;
        this.next = null;
    }
    

    public Node(String obj, Node next) {
        this.obj = obj;
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node newNode) {
        next = newNode;
    }

    public String getValue() {
        if (this.obj == null) return null;
        return this.obj;
    }

}
