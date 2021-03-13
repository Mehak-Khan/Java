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
public class School {

    private String name;
    private String city;
    private long schoolNumber;
    private int numberOfStudents;
    private double rating;
    private boolean highschool;

    public static void main(String[] args) {
        School gwss = new School();
        gwss.name = "GARTH WEBB SS";
        gwss.city = "OAKVILLE";
        gwss.highschool = true;
        gwss.rating = 4.5;
        gwss.schoolNumber = 96572;

    }

    public School() {

    }

    //PRIMARY KEY
    public School(int schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    //SECONDARY KEY
    public School(String name, String city, int numberOfStudents, double rating, boolean highschool) {
        this.name = name;
        this.city = city;
        this.numberOfStudents = numberOfStudents;
        this.rating = rating;
        this.highschool = highschool;
    }

    //CITY - GET AND SET
    public String getCity() {
        if (city == null) {
            System.out.println("SCHOOL NOT NAMED");
        }
        return city;
    }

    public void setCity(String city) {
        this.city = city.toString();
    }

    //RATING - GET AND SET
    public double getRating() {
        if (rating == -1) {
            System.out.println("SCHOOL NOT RATED");
        }
        return rating;
    }

    public void setRating(double rating) {

        if (rating >= 0 && rating <= 5) {
            this.rating = rating;
        } else {
            System.out.println("INVALID RATING");
        }

    }

    //HIGHSCHOOL - GET AND SET
    public boolean isHighschool() {
        return highschool;
    }

    public void setHighschool(boolean highschool) {
        if (highschool != true || highschool != false) {
            System.out.println("INVALID INPUT");
        } else {
            this.highschool = highschool;
        }
    }

    //NAME - GET AND SET
    public String getName() {
        if (name == null) {
            System.out.println("SCHOOL NOT NAMED");
        }
        return name;
    }

    public void setName(String name) {
        this.name = name.toString();
    }

    //NUMBER OF STUDENTS - GET AND SET
    public int getNumberOfStudents() {
        if (numberOfStudents == -1) {
            System.out.println("# OF STUDENTS NOT DEFINED");
        }
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        if (numberOfStudents >= 0) {
            this.numberOfStudents = numberOfStudents;
        } else {
            System.out.println("INVALID INPUT");
        }
    }

    //SCHOOL NUMBER - GET AND SET
    public long getSchoolNumber() {
        if (schoolNumber == -1) {
            System.out.println("SCHOOL # NOT DEFINED");
        }
        return schoolNumber;
    }

    public void setSchoolNumber(long schoolNumber) {
        if (schoolNumber >= 0) {
            this.schoolNumber = schoolNumber;
        } else {
            System.out.println("INVALID INPUT");
        }
    }

    @Override
    public String toString() {
        return "School{" + "name=" + name + ", city=" + city + ", schoolNumber=" + schoolNumber + ", numberOfStudents=" + numberOfStudents + ", rating=" + rating + ", highschool=" + highschool + '}';
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
        final School other = (School) obj;
        return true;
        
    
    }
    
    

}
