/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.khan.ics4u.u7;

import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author mehakkhan
 */
public class StudentIO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        RandomAccessFile raf = new RandomAccessFile("student_info.txt", "rw");

        Student s1 = new Student("Mehak", "Khan", true, 3.7, 18, 12, 'A');
        Student s2 = new Student("Ali", "Syed", false, 3.0, 15, 10, 'B');
        Student s3 = new Student("John", "Smith", true, 2.4, 17, 12, 'C');
        Student s4 = new Student("Hamza", "Syed", true, 3.4, 17, 12, 'A');
        Student s5 = new Student("Hussain", "Rizvi", true, 3.9, 18, 12, 'A');
        Student s6 = new Student("Sandra", "Hwang", false, 2.7, 16, 11, 'B');
        Student s7 = new Student("Aryan", "Kapur", false, 1.4, 16, 11, 'D');
        Student s8 = new Student("Bill", "Wang", true, 2.8, 18, 12, 'C');

        raf.seek(0);

        raf.writeChars(s1.getName());
        raf.writeChars(s1.getLastName());
        raf.writeChar(s1.getLetterGrade());
        raf.writeBoolean(s1.isSenior());
        raf.writeDouble(s1.getGpa());
        raf.writeInt(s1.getAge());
        raf.writeInt(s1.getGrade());

        raf.writeChars(s2.getName());
        raf.writeChars(s2.getLastName());
        raf.writeChar(s2.getLetterGrade());
        raf.writeBoolean(s2.isSenior());
        raf.writeDouble(s2.getGpa());
        raf.writeInt(s2.getAge());
        raf.writeInt(s2.getGrade());

        raf.writeChars(s3.getName());
        raf.writeChars(s3.getLastName());
        raf.writeChar(s3.getLetterGrade());
        raf.writeBoolean(s3.isSenior());
        raf.writeDouble(s3.getGpa());
        raf.writeInt(s3.getAge());
        raf.writeInt(s3.getGrade());

        raf.writeChars(s4.getName());
        raf.writeChars(s4.getLastName());
        raf.writeChar(s4.getLetterGrade());
        raf.writeBoolean(s4.isSenior());
        raf.writeDouble(s4.getGpa());
        raf.writeInt(s4.getAge());
        raf.writeInt(s4.getGrade());

        raf.writeChars(s5.getName());
        raf.writeChars(s5.getLastName());
        raf.writeChar(s5.getLetterGrade());
        raf.writeBoolean(s5.isSenior());
        raf.writeDouble(s5.getGpa());
        raf.writeInt(s5.getAge());
        raf.writeInt(s5.getGrade());

        raf.writeChars(s6.getName());
        raf.writeChars(s6.getLastName());
        raf.writeChar(s6.getLetterGrade());
        raf.writeBoolean(s6.isSenior());
        raf.writeDouble(s6.getGpa());
        raf.writeInt(s6.getAge());
        raf.writeInt(s6.getGrade());

        raf.writeChars(s7.getName());
        raf.writeChars(s7.getLastName());
        raf.writeChar(s7.getLetterGrade());
        raf.writeBoolean(s7.isSenior());
        raf.writeDouble(s7.getGpa());
        raf.writeInt(s7.getAge());
        raf.writeInt(s7.getGrade());

        raf.writeChars(s8.getName());
        raf.writeChars(s8.getLastName());
        raf.writeChar(s8.getLetterGrade());
        raf.writeBoolean(s8.isSenior());
        raf.writeDouble(s8.getGpa());
        raf.writeInt(s8.getAge());
        raf.writeInt(s8.getGrade());

        //READ
        Student s9 = new Student();

        long numRecords = raf.length() / Student.RECORD_SIZE;
        System.out.println("\nThere are " + numRecords + " records currently in the file.");

        Scanner input = new Scanner(System.in);
        System.out.println("Which record do you want [1 - " + numRecords + "] or 0 to exit");
        long rafNumber = input.nextLong();
        if (rafNumber > 0 && rafNumber < 9) {
            long position = Student.RECORD_SIZE * (rafNumber - 1);

            raf.seek(position);

            //NAME
            char[] data = new char[Student.LENGTH_NAME];
            for (int i = 0; i < data.length; i++) {
                data[i] = raf.readChar();
            }
            s9.setName(new String(data));

            //LASTNAME
            data = new char[Student.LENGTH_LASTNAME];
            for (int i = 0; i < data.length; i++) {
                data[i] = raf.readChar();
            }
            s9.setLastName(new String(data));

            //LetterGrade
            s9.setLetterGrade(raf.readChar());

            //SENIOR
            s9.setSenior(raf.readBoolean());

            //GPA
            s9.setGpa(raf.readDouble());

            //AGE
            s9.setAge(raf.readInt());

            //GRADE
            s9.setGrade(raf.readInt());

            System.out.println(s9.toString());
        }
        raf.close();

    }

}
