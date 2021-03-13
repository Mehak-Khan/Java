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
public class Encryption {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.print("ENTER PHRASE: ");
        String phrase = input.nextLine().toLowerCase();
        System.out.print("ENTER ROTATION AMOUNT (1-25): ");
        char rotation = (char) input.nextInt();
        System.out.print("1. ENCRYPTION\n2.DECRYPTION ");
        int encDec = input.nextInt();
        StringTokenizer str = new StringTokenizer (phrase);
        if (encDec == 1) {
            while (str.hasMoreTokens()) {
        System.out.print(encryption(str.nextToken() , rotation) + " ");
        }
        }
        else {
        while (str.hasMoreTokens()) {
        System.out.print(decryption(str.nextToken() , rotation) + " ");
        }
        }
       
    }
    public static String encryption(String text, int shift) {
        String encrypt = "";
        for (int i = 0; i < text.length(); i++) {
            char reverse = (char) (text.charAt(i) + shift);
            if (reverse > 'z') {
               encrypt += (char)(text.charAt(i) - (26-shift)); 
            }
            else {
                encrypt += (char)(text.charAt(i) + (shift));

            }
            
            
        }
        
    return encrypt;
    
}
    public static String decryption(String text, int shift) {
        String encrypt = "";
        for (int i = 0; i < text.length(); i++) {
            char reverse = (char) (text.charAt(i) - shift);
            if (reverse < 'a' ) {
               encrypt += (char)((26-shift)+ text.charAt(i)); 
            }
            else {
                encrypt += (char)(text.charAt(i) - (shift));
       
            }
            
            
        }
        
    return encrypt;
    
}
}
