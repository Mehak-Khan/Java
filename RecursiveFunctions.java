/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.khan.ics4u.u3;

/**
 *
 * @author 1khanmeh3
 */
public class RecursiveFunctions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(function(1, 4));
        System.out.println(Ackermansfunction(1, 1));
        System.out.println(Ackermansfunction(2, 1));
        //System.out.println(Ackermansfunction(5,5));
    }

    //DIFFERENCE TWO TERMS (x-y)
    public static int function(int x, int y) {
        if (x == y) {
            return 0;
        }
        if (x < y) {
            return -function(y, x);
        }
        return 1 + function(x - 1, y);
    }

    public static int Ackermansfunction(int m, int n) {
        if (m < 0 || n < 0) {
            return -1;
        }
        if (m == 0) {
            return n + 1;
        }
        if (m > 0 && n == 0) {
            return Ackermansfunction(m - 1, 1);
        }
        return Ackermansfunction(m - 1, Ackermansfunction(m, n - 1));
    }

}
