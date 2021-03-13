/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.khan.isc4u.u1;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author mehakkhan
 */
public class Palindrome1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in); 
        System.out.print("Enter sentence: ");
        String sentence = input.nextLine();
        StringTokenizer str = new StringTokenizer (sentence);
        //String reverse;
        String palindrome = "";
        String token;
        while (str.hasMoreTokens()) {
            token = str.nextToken();
          if (Palindrome.isPalindrome(token) == true) {
          palindrome+= token + " ";
 
        }
        }
        System.out.println("The palindromes are: " + palindrome);
        
        
    }
}
    

