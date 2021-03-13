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
public class HashTableTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student s = new Student(1, "Mehak", "Khan", "0710");
        Student s1 = new Student(2, "Hamza", "Khan", "0710");
        Student s2 = new Student(3, "Jav", "Khan", "0710");
        Student s3 = new Student(4, "Seema", "Khan", "0890");
        Student s4 = new Student(5, "Sumbul", "Khan", "9898");
        Student s5 = new Student(6, "Ghul", "Khan", "9898");
        Student s6 = new Student(7, "F", "Khan", "9898");

        HashTable h = new HashTable(4);
        // HashTable h2 = new HashTable(4);

        h.put(s.getId(), s);
        h.put(s1.getId(), s1);
        h.put(s2.getId(), s2);
        h.put(s3.getId(), s3);
        h.put(s4.getId(), s4);
        h.put(s5.getId(), s5);

        System.out.println(h.toString());

        System.out.println(h.get(2));
        System.out.println(h.containsKey(0));

        //h.put(3, s1);
        // System.out.println(h.hash(4));
        //System.out.println(h.keys.length + " " + h.table.length);
        //  assert( h.get(3).getId() == s1.getId() );
        //System.out.println(h.table.length);
        // h.put(4, s2);
        // h.put(5, s3);
        // h.put(6, s4);
        //System.out.println(h.containsKey(6));
        // h.put(1, s5);
        // h.put(1, s6); // REHASH
        // System.out.println(h.containsKey(2)); //true
        // System.out.println(h.containsKey(5)); // false
        //System.out.println(h.contains(s1)); // true
        // System.out.println(h.contains(s4)); //false
        //  System.out.println(h.get(5)); //NULL
        // System.out.println(h.isEmpty()); //false
        //h.makeEmpty();
        //System.out.println(h.isEmpty()); //true
        //  System.out.println(h.toString());
        //GET
        //System.out.println(h.get(2));
        //System.out.println(h.containsKey(2));
    }

}
