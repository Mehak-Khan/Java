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
public class HashTable implements HashTableInterface {

    // int capacity;
    Student[] table;   

    public HashTable() {
        this(53);
    }

    public HashTable(int capacity) {
        while (!isPrime(capacity, 2)) {
            capacity++;
        }

        //this.length( = capacity;
        table = new Student[capacity];

    }

    private static boolean isPrime(int x, int y) {
        //RECURSION

        if (x <= 2) {
            return (x == 2);
        }
        if (x % y == 0) {
            return false;
        }
        if (y * y > x) {
            return true;
        }
        return isPrime(x, y + 1);
    }

    public String toString() {
        String str = "";

        for (int i = 0; i < table.length; i++) {
            str += String.format("%-6s", i + " ");
        }
        str += "\n";

        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                str += String.format("%-6s", " ");
            } else {
                str += String.format("%-6s", table[i].getFirstName());

            }

        }
        return str;

    }

    public boolean containsKey(int key) {

        return get(key) != null;

    }

    public int size() {
        int size = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                size++;
            }

        }
        return size;
    }

    public double loadFactor() {
        return size() * 1.0 / table.length;
    }

    public void makeEmpty() {
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
    }

    public boolean isEmpty() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                return false;
            }

        }
        return true;

    }

    public void rehash() {
        int newCap = table.length;
        while (size() * 1.0 / newCap > 0.25) {
            newCap++;
        }
        while (!isPrime(newCap, 2)) {
            newCap++;
        }

        HashTable x = new HashTable(newCap);

        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                x.put( table[i].getId(), table[i]);
            }
        }

        this.table = x.table;        

    }

    public Student get(int key) {
        int index = hash(key);
        while (table[index] != null) {
            if (table[index].getId() == (key)) {
                //System.out.println(keys[index]);
                return table[index];
            }
            index = (index + 1) % table.length;

        }
        //System.out.println(keys[index]);
        return null;

    }
    // return table[index];

    public boolean contains(Student value) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                if (value.getFirstName().equals(table[i].getFirstName()) && value.getLastName().equals(table[i].getLastName())
                        && value.getDob().equals(table[i].getDob())) {
                    return true;
                }
            }

        }
        return false;
    }

    public int hash(int key) {
        return key % table.length;
    }

    public void put(int key, Student value) {
        int collissions = 0;
        int index = hash(key);
        if (!value.isValid()) {
            System.out.println("Student does not have first, or last name or DOB or ID");
        } else {
            if (table[index] != null) {
                while (table[index] != null) {
                    index++;
                    collissions++;
                    if (index >= table.length) {
                        index = 0;
                    }
                }
            }
            table[index] = value;
 
        }
        System.out.println("Collissions: " + collissions);

        if (loadFactor() > 0.75) {
            rehash();
        }

    }

}
