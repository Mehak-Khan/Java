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
public class Palindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in); 
        System.out.print("Enter word: ");
        String word = input.nextLine();
        if (isPalindrome(word) == true) {
            System.out.println(word +  " is a palindrome");
        }
        else {
            System.out.println(word + " is not a palindrome");
        }
    }   
        public static boolean isPalindrome (String word) {
        String reverse = "";
        for (int i = word.length() -1; i >= 0; i--) {
            reverse = reverse + word.charAt(i);            
        }
        if (reverse.equalsIgnoreCase(word)) {
            return true;
        }
        else {
            return false;
    }
    
}
}

