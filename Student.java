/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.khan.ics4u.u4;

import java.util.Objects;

/**
 *
 * @author 1khanmeh3
 */
public class Student {

    //INSTANCE VARIABLES
    private String name;
    private long id;
    private String lastName;
    private boolean senior;
    private double gpa;
    private int age;

    public static void main(String[] args) {
        Student mehak = new Student();
        mehak.name = "Mehak";
        mehak.id = 345678;
        mehak.lastName = "Khan";
        mehak.gpa = 3.6;
        mehak.age = 18;
        mehak.senior = true;
    }

    //EMPTY CONSTRUCTOR
    public Student() {
    }

    //PRIMARY KEY
    public Student(long id) {
        this.id = id;
    }

    //SECONDARY KEY
    public Student(String name, String lastName, boolean senior, double gpa, int age) {
        this.name = name;
        this.lastName = lastName;
        this.senior = senior;
        this.gpa = gpa;
        this.age = age;
    }

    //AGE - GET AND SET
    public int getAge() {
        if (age == -1) {
            System.out.println("AGE NOT SET");
        }
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("INVALID INPUT");
        }
    }

    //GPA - GET AND SET
    public double getGpa() {
        if (gpa == -1) {
            System.out.println("GPA NOT SET");
        }
        return gpa;
    }

    public void setGpa(double gpa) {
        if (gpa > 0 || gpa < 4) {
            this.gpa = gpa;
        } else {
            System.out.println("INVALID INPUT");
        }
    }

    //ID - GET AND SET
    public long getId() {
        if (id == -1) {
            System.out.println("ID NOT SET");
        }
        return id;
    }

    public void setId(long id) {
        if (id > 0) {
            this.id = id;
        } else {
            System.out.println("INVALID INPUT");
        }
    }

    //LASTNAME - GET AND SET
    public String getLastName() {
        if (lastName == null) {
            System.out.println("LAST NAME NOT SET");
        }
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.toString();
    }

    //NAME - GET AND SET
    public String getName() {
        if (name == null) {
            System.out.println("NAME NOT SET");
        }
        return name;
    }

    public void setName(String name) {
        this.name = name.toString();
    }

    //SENIOR - GET AND SET
    public boolean isSenior() {
        return senior;
    }

    public void setSenior(boolean senior) {
        if (senior == true || senior == false) {
            this.senior = senior;
        } else {
            System.out.println("INVALID INPUT");
        }
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", id=" + id + ", lastName=" + lastName + ", senior=" + senior + ", gpa=" + gpa + ", age=" + age + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        return true;
    }

    
}
