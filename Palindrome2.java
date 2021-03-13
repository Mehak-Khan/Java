/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.khan.isc4u.u1;

import java.util.Scanner;


/**
 *
 * @author mehakkhan
 */
public class Palindrome2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner input = new Scanner (System.in); 
        System.out.print("Enter sentence: ");
        String sentence = input.nextLine();
        sentence = sentence.replaceAll(" ", "");
        if (Palindrome.isPalindrome(sentence) == true) {
            System.out.println("Sentence is a palindrome");
        }
        else {
           System.out.println("Sentence is not a palindrome");  
        }
    
}
}
