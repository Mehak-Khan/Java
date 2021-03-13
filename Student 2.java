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
public class Student {

    private String firstName;
    private String lastName;
    private String dob;
    //private final int nextID = 1000;
    private int id;

    @Override
    public String toString() {
        return "Student{" + "firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", id=" + id + '}';
    }
    

    public Student() {
        this.id = -1;
        //this(null,null,null);
    }

    //SECONDARY KEY
    public Student(String firstName, String lastName, String dob) {
        this.id = -1;
        this.lastName = lastName;
        this.firstName = firstName;
        this.dob = dob;
        //this.id = nextID;
        
    }
    
    public Student(int id, String firstName, String lastName, String dob) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.dob = dob;
        //this.id = nextID;
        
    }
    
    //PRIMARY KEY 
//    public Student (long id ) {
//       this.id = id;
//    }

    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    //ISVALID 
    public boolean isValid() {
        return !(this.dob == null || this.firstName == null || this.id == -1 || this.lastName == null);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
