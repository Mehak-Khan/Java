/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.khan.ics4u.u7;


/**
 *
 * @author 1khanmeh3
 */
public class Student  {

    //INSTANCE VARIABLES
    private String name;
    private String lastName;

    private long id;

    private boolean senior;

    private double gpa;

    private int age;
    private int grade;

    private char letterGrade;

    public static final int LENGTH_LASTNAME = 10;
    public static final int LENGTH_NAME = 10;

    protected static final int RECORD_SIZE = 59;

    //EMPTY CONSTRUCTOR
    public Student() {
        this.grade = -1;
        this.age = -1;
        this.id = -1;
    }

    //PRIMARY KEY
    public Student(long id) {
        this.id = id;
    }

    //SECONDARY KEY
    public Student(String name, String lastName, boolean senior, double gpa, int age, int grade, char letterGrade) {
        this.setLastName(lastName);
        this.setName(name);
        this.senior = senior;
        this.gpa = gpa;
        this.age = age;
        this.grade = grade;
        this.letterGrade = letterGrade;
        this.id = -1;
    }
    
    //ISVALID
    public boolean isValid() {
        return this.name != null && this.lastName != null;
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
//        if (id == -1) {
//            System.out.println("ID NOT SET");
//        }
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
        StringBuilder temp = new StringBuilder();

        if (lastName != null) {
            temp.append(lastName.trim());
        } else {
            temp.append("TBD");
        }

        // trucates or pads the string
        temp.setLength(LENGTH_LASTNAME);
        this.lastName = temp.toString();
    }

    //NAME - GET AND SET
    public String getName() {
        if (name == null) {
            System.out.println("NAME NOT SET");
        }
        return name;
    }

    public void setName(String name) {
        StringBuilder temp = new StringBuilder();

        if (name != null) {
            temp.append(name.trim());
        } else {
            temp.append("TBD");
        }

        // trucates or pads the string
        temp.setLength(LENGTH_NAME);
        this.name = temp.toString();
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public char getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(char letterGrade) {
        this.letterGrade = letterGrade;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", lastName=" + lastName + ", id=" + id + ", senior=" + senior + ", gpa=" + gpa + ", age=" + age + ", grade=" + grade + ", letterGrade=" + letterGrade + '}';
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
