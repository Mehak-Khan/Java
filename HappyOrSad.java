/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.khan.isc4u.u1;

import java.util.Scanner;

/**
 *
 * @author 1khanmeh3
 */
public class HappyOrSad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.print("ENTER SENTENCE: ");
        String phrase = input.nextLine();
        int j;
        int happy = 0;
        int sad = 0; 
        for (int i = 0; i < phrase.length(); i+=3) {    
         j = phrase.indexOf(":", i);  
         if (phrase.charAt(j + 1) == '-' && phrase.charAt(j + 2) == ')') {
             happy+= 1;
         }
         else if (phrase.charAt(j + 1) == '-' && phrase.charAt(j + 2) == '(') {
             sad+= 1;
         }
          
        
        
    }
        if (happy > sad) {
            System.out.println("HAPPY");
        }
        else if (sad > happy) {
            System.out.println("SAD");
        }
        else if (sad == happy && sad != 0) {
            System.out.println("UNSURE");
        }
        else {
            System.out.println("NONE");
        }
    
}
}
