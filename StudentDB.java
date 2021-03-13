/* Name: Mehak Khan
 * Date: 3rd June, 2019
 * Program: StudentDB.java
 * Description: creates a randomaccessfile to save and get student info
 */
package edu.hdsb.gwss.khan.ics4u.u7;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author 1khanmeh3
 */
public class StudentDB {

    RandomAccessFile raf;

    public void open() {
        try {
            raf = new RandomAccessFile("studentDB_info.txt", "rw");
            raf.seek(raf.length());
        } catch (IOException ex) {
            System.out.println("Error with Input/Output of file");
            System.out.println("Exception: " + ex);
            System.exit(1);
        }

    }

    public void close() {
        try {
            raf.close();
        } catch (IOException ex) {
            System.out.println("Error with Input/Output of file");
            System.out.println("Exception: " + ex);
            System.exit(1);
        }

    }

    public Student save(Student s) {
        try {
            //check is object is null
            if (s == null) {
                return null;
            }
            //check if student has frist name and last name
            if (s.isValid() == false) {
                System.out.println("Not enough info for Student");
            }
            //SAVE
            if (s.isValid() && s.getId() == -1) {
                s.setId((raf.length() / Student.RECORD_SIZE) + 1);
                raf.writeChars(s.getName());
                raf.writeChars(s.getLastName());
                raf.writeChar(s.getLetterGrade());
                raf.writeBoolean(s.isSenior());
                raf.writeDouble(s.getGpa());
                raf.writeInt(s.getAge());
                raf.writeInt(s.getGrade());
                raf.writeLong(s.getId());

                //UPDATE
            } else if (s.isValid() && s.getId() > 0) {
                //  s = this.get(s.getId());
                raf.seek(Student.RECORD_SIZE * (s.getId() - 1));
                raf.writeChars(s.getName());
                raf.writeChars(s.getLastName());
                raf.writeChar(s.getLetterGrade());
                raf.writeBoolean(s.isSenior());
                raf.writeDouble(s.getGpa());
                raf.writeInt(s.getAge());
                raf.writeInt(s.getGrade());
            }
            return s;

        } catch (IOException ex) {
            System.out.println("Error with Input/Output of file");
            System.out.println("Exception: " + ex);
            System.exit(1);
        }
        return null;
    }

    public Student get(long sID) {
        try {
            Student s = new Student();

            //ID DOESNT EXIST
            if (sID > (raf.length() / Student.RECORD_SIZE)) {
                System.out.println("ID DOESNT EXIST");
                return null;
            }
            if (sID > 0) {
                raf.seek(Student.RECORD_SIZE * (sID - 1));

                //NAME
                char[] data = new char[Student.LENGTH_NAME];
                for (int i = 0; i < data.length; i++) {
                    data[i] = raf.readChar();
                }
                s.setName(new String(data));

                //LASTNAME
                data = new char[Student.LENGTH_LASTNAME];
                for (int i = 0; i < data.length; i++) {
                    data[i] = raf.readChar();
                }
                s.setLastName(new String(data));

                //LetterGrade
                s.setLetterGrade(raf.readChar());

                //SENIOR
                s.setSenior(raf.readBoolean());

                //GPA
                s.setGpa(raf.readDouble());

                //AGE
                s.setAge(raf.readInt());

                //GRADE
                s.setGrade(raf.readInt());

                //ID
                s.setId(raf.readLong());

                return s;

            }

            return null;

        } catch (IOException ex) {
            System.out.println("Error with Input/Output of file");
            System.out.println("Exception: " + ex);
            System.exit(1);
        }
        return null;
    }

}
