/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.khan.isc4u.u1;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author mehakkhan
 */
public class NumericsPractice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(Math.sqrt(25)); //returns DECIMAL
        System.out.println(Math.pow(3, 2)); //returns DOUBLE
        System.out.println(Math.min(2, 3.0)); //returns DOUBLE if one is DOUBLE
        System.out.println(Math.round(2.5555)); //returns INT
        System.out.println(Math.abs(-3.0));
        System.out.println(Math.random()); //0 - less than 1
        System.out.println(Math.ceil(2)); //returns DOUBLE
        System.out.println("\n");
        long longX = 1000; 
        float floatX = longX; 
        System.out.println(floatX);
        
        System.out.println("\nBOOLEAN");
        boolean booleanVal = false;
        System.out.println("TO INT-DOUBLE-LONG");
        int intVal = (booleanVal) ? 1:0;
        System.out.println(intVal);
        System.out.println("TO STRING");
        String stringVal = String.valueOf(booleanVal);
        System.out.println(stringVal);
        
        System.out.println("\nCHAR");
        char charValue = 'a';
        System.out.println("TO INT-Double-Long");
        double doubleVal = (double) charValue;
        System.out.println(doubleVal);
        System.out.println("TO STRING");
        stringVal = String.valueOf(charValue);
        System.out.println(stringVal);
        
        System.out.println("\nINT");
        System.out.println("TO CHAR");
        charValue = (char) 97;
        System.out.println(charValue);
        
        System.out.println("\nLONG");
        System.out.println("TO INT");
        intVal = (int)87.8;
        System.out.println(intVal);
        System.out.println("TO CHAR");
        System.out.println((char) 97.9);
        
        System.out.println("\nDOUBLE");
        System.out.println("TO LONG");
        doubleVal = 87.6;
        long longVal = (long) doubleVal;
        
        System.out.println("\nSTRING");
        System.out.println("to CHAR");
        String str = "123";
        charValue = str.charAt(1);
        System.out.println(charValue);
        System.out.println("to INT");
        longVal = Long.parseLong(str);
        System.out.println(longVal);
        
        System.out.println("\nBIG INTEGERS");
        BigDecimal a = new BigDecimal ("1.0");
        BigDecimal b = new BigDecimal ("3");
        System.out.println(a.divide(b, 3, BigDecimal.ROUND_UP));
    }
    
}
