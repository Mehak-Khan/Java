/**
 * Stack Interface.
 *
 * @author Wm.Muir
 * @version 2018-19.S2
 */
package edu.hdsb.gwss.khan.ics4u.u5;

public interface StackInterface {

    public String peek();

    public String pop();

    public void push( String value );

    public int size();

    public int capacity();

    public boolean isEmpty();

    public boolean isFull();

    public void makeEmpty();

}
