/**
 * (Closed) hashtablee Interface
 *
 * @author Wm.Muir
 * @version 2018-19.S2
 */
package edu.hdsb.gwss.khan.ics4u.u5;

public interface HashTableInterface {

    /**
     * @return Returns the number of keys in this hashtable.
     */
    public int size();

    /**
     * @return The load factor of the hashtable.
     */
    public double loadFactor();

    /**
     * Clears this hashtablee so that it contains no keys.
     */
    public void makeEmpty();

    /**
     * Tests if this hashtable maps no keys to values.
     */
    public boolean isEmpty();

    /**
     * Increases the capacity of and internally reorganizes this hashtable, in
     * order to accommodate and access its entries more efficiently.
     */
    public void rehash();

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     *
     * @param key
     * @return
     */
    public Student get( int key );

    /**
     * Maps the specified key to the specified value in this hashtable. Neither
     * the key nor the value can be null.
     *
     * @param key
     * @param value
     */
    public void put( int key, Student value );

    /**
     * Tests if a SECONDARY KEY of the value maps into the specified value in this hashtable. 
     * This operation is more expensive than the containsKey method.
     * SECONDARY KEY:  First Name, Last Name, DOB
     * 
     * @param value
     * @return
     */
    public boolean contains( Student value );

    /**
     * Tests if the specified object is a key in this hashtable.
     *
     * @param key
     * @return
     */
    public boolean containsKey( int key );

    /**
     *
     * @param key
     * @return
     */
    public int hash( int key );

}
