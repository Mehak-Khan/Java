/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.khan.isc4u.u1;

import java.util.ArrayList;

/**
 *
 * @author mehakkhan
 */
public class TestPractice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        System.out.println(Math.floor(0.5)); //RETURNS DECIMAL
//        System.out.println(Math.round(0.05)); //RETURNS INT
//        System.out.println(Math.random()); //RANDOM DECIMAL VALUE
//        long x = 0;
//        float y = 3;
//        System.out.println(x + y);
//        BigInteger b = new BigInteger("2");
//        BigInteger c = new BigInteger("4");
//        BigInteger a = b.multiply(c);
//        System.out.println(a);
//
//        BigDecimal d = new BigDecimal(1.0);
//        BigDecimal e = new BigDecimal(3);
//        BigDecimal f = d.divide(e); //NON TERMINATING
        //System.out.println(f);

        System.out.println("\nCHART\n");
        System.out.println("BOOLEAN\n");

        //BOOLEAN
        boolean conversion = false;
        //to CHAR N/A 

        //to INT or DOUBLE or LONG
        double q = (conversion) ? 1 : 0;
        System.out.println(q);

        //to STRING
        String d = Boolean.toString(conversion);
        System.out.println(d);

        //CHAR
        char s = 's';
        //to BOOLEAN is N/A

        //to INT, LONG, DOUBLE
        double k = s;
        System.out.println(k);

        //STRING
        String f = Character.toString(s);
        System.out.println(f);

        //INT
        int g = 99;

        //to CHAR
        char zz = (char) g;
        System.out.println(zz);

        //to LONG or DOUBLE
        double qq = g;
        System.out.println(qq);

        //to STRING
        String ww = String.valueOf(g);

        System.out.println(ww);

        //LONG 
        long lon = 97;

        //to CHAR
        char ch = (char) lon;
        System.out.println("\n" + ch);

        //to INT or DOUBLE
        int dob = (int) lon;
        System.out.println(dob);

        //to STRING
        String str = String.valueOf(lon);
        System.out.println(str);

        //DOUBLE
        double xx = 98.7;

        //to BOOLEAN 
        //to CHAR
        ch = (char) xx;
        System.out.println("\n" + ch);

        //to INT or LONG
        dob = ch;
        System.out.println(dob);
        long lonnn = ch;
        System.out.println(lonnn);

        //to STRING 
        str = String.valueOf(xx);
        System.out.println(str);

        //STRING
        str = "1";

        //to CHAR 
        ch = str.charAt(0);
        System.out.println(ch);

        //to BOOLEAN
        conversion = Boolean.valueOf(str);
        System.out.println(conversion);

        //to INT/LONG/DOUBLE
        double dd = Long.parseLong(str);
        System.out.println(dd);

        //Math functions
        System.out.println("MATH FUNC");

        System.out.println("FLOOR:" + Math.floor(0.5));
        System.out.println("CEIL:" + Math.ceil(0.5));
        System.out.println("ROUND: " + Math.round(0.4));
        System.out.println("SQRT:" + Math.sqrt(25));
        System.out.println("POW" + Math.pow(2, 3));
        System.out.println("ABS" + Math.abs(-1.0));
        System.out.println("RANDOM:" + Math.random());
        System.out.println("MAX/MIN:" + Math.min(1, 3));

        System.out.println("\n\nARRAY LIST");

        ArrayList<Integer> prac = new ArrayList();

        prac.add(1);
        prac.add(2);
        prac.add(3);
        System.out.println(prac);
        prac.remove(1);
        prac.clear();
        System.out.println(prac);
        System.out.println(prac.size());

    }

}
