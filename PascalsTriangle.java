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
public class PascalsTriangle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      //  System.out.println(term(0, 0));
       row(7);
    }

    public static int term(int row, int col) {
        if (col == 0) {
            return 1;
        }
        if (row == 0) {
            return 1;
        }
        if (col == row) {
            return 1;
        }
        //if (row == 0) return 1;
        //if (row == 0) return 0;
        return (term(row - 1, col - 1) + term(row - 1, col));
    }

    public static void row(int row) {
        for (int i = 0; i < row; i++) {
            System.out.println("");
            for (int j = 0; j <= i; j++) {

                System.out.print(term(i, j));
                System.out.print(" ");

            }
        }

    }
}
        
