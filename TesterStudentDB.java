/* Name: Mehak Khan
 * Date: 3rd June, 2019
 * Program: TesterStudentDB.java
 * Description: tests the studentDB.java program
 */
package edu.hdsb.gwss.khan.ics4u.u7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author 1khanmeh3
 */
public class TesterStudentDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student s1 = new Student("Mehak", "Khan", true, 3.7, 18, 12, 'A');
        Student s2 = new Student("Ali", "Syed", false, 3.0, 15, 10, 'B');
        Student s3 = new Student("John", "Smith", true, 2.4, 17, 12, 'C');
        Student s4 = new Student("Hamza", "Syed", true, 3.4, 17, 12, 'A');
        Student s5 = new Student("Hussain", "Rizvi", true, 3.9, 18, 12, 'A');
        Student s6 = new Student("Sandra", "Hwang", false, 2.7, 16, 11, 'B');
        Student s7 = new Student("Aryan", "Kapur", false, 1.4, 16, 11, 'D');
        Student s8 = new Student();

        StudentDB sDB = new StudentDB();

        sDB.open();

        //SAVE AND UPDATE
        sDB.save(s1);
        s1.setName("Moni");
        sDB.save(s1);

        sDB.save(s2);
        s2.setName("Farah");
        sDB.save(s2);

        //SAVE
        sDB.save(s4);

        //GET - assert
        Student check = sDB.get(2);
        assert (check.equals(s2));

        //NULL - assert
        assert (sDB.save(null) == null);

        //not valid
        sDB.save(s8);

        //ID doesnt exist
        System.out.println(sDB.get(99)); //doesnt exist

        sDB.close();
    }

}
