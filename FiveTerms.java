/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.khan.ics4u.u3;

import java.text.DecimalFormat;

/**
 *
 * @author 1khanmeh3
 */
public class FiveTerms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DecimalFormat f = new DecimalFormat("##.00");
        for (int i = 1; i <= 5; i++) {
            System.out.print(sequence1(i));
            System.out.print(" ");
        }
        System.out.println("\n");
        for (int j = 1; j <= 5; j++) {
            System.out.print(f.format(sequence2(j)));
            System.out.print(" ");
        }

    }

    public static int sequence1(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return sequence1(n - 1) + (sequence1(n - 2));
    }

    public static double sequence2(int n) {
        if (n == 1) {
            return 2;
        }
        if (n < 1) {
            return -1;
        }
        return Math.sqrt((3 * (sequence2(n - 1)) + 4));
    }

}
