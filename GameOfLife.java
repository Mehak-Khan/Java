/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.khan.ics4u.u2;

/**
 *
 * @author 1khanmeh3
 */
public class GameOfLife {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // final String CELL_ALIVE = "X";
        // final String CELL_EMPTY = ".";
        String data[][] = new String[10][10];
        int livingCells = 20;
        for (int i = 0; i < livingCells;) {
            // int row = 0;
            // int column = 0;   
            int row = (int) (Math.random() * data.length);
            //System.out.println(row);
            int column = (int) (Math.random() * data.length);
            //System.out.println(column);   
            if (data[row][column] == null) {
                data[row][column] = "X";
                i++;
            }
        }

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] == null) {
                    data[i][j] = ".";
                }
            }
        }

        //   System.out.println("\n");
        //int generation = 0;
        for (int generation = 0; generation < 5; generation++) {
            System.out.println("Generation: " + generation);
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {

                    System.out.print(data[i][j]);
                    System.out.print(" ");
                }
                System.out.println("");
                data = createNewGeneration(data);
                //generation++;

            }
            //createNewGeneration(data);
        }
    }

    public static int checkAliveOrDead(String data[][], int i, int j) {
        int alive = 0;
        int dead = 0;
//
        // for (int i = 0; i < data.length; i++) {
        //  for (int j = 0; j < data[i].length; j++) {
        try {
            if (data[i + 1][j + 1].equals("X")) {
                alive++;
            } else {
                dead++;
            }
        } catch (Exception e) {
        }
        try {
            if (data[i + 1][j - 1].equals("X")) {
                alive++;
            } else {
                dead++;
            }
        } catch (Exception e) {
        }
        try {
            if (data[i - 1][j + 1].equals("X")) {
                alive++;
            } else {
                dead++;
            }
        } catch (Exception e) {
        }
        try {
            if (data[i - 1][j - 1].equals("X")) {
                alive++;
            } else {
                dead++;
            }
        } catch (Exception e) {
        }
        try {
            if (data[i][j + 1].equals("X")) {
                alive++;
            } else {
                dead++;
            }
        } catch (Exception e) {
        }
        try {
            if (data[i][j - 1].equals("X")) {
                alive++;
            } else {
                dead++;
            }
        } catch (Exception e) {
        }
        try {
            if (data[i + 1][j].equals("X")) {
                alive++;
            } else {
                dead++;
            }
        } catch (Exception e) {
        }
        try {
            if (data[i - 1][j].equals("X")) {
                alive++;
            } else {
                dead++;
            }
        } catch (Exception e) {
        }

        return alive;

    }

    public static String[][] createNewGeneration(String data[][]) {
        final String CELL_ALIVE = "X";
        final String CELL_EMPTY = ".";
        String dataNewGen[][] = new String[10][10];
        int alive;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                alive = checkAliveOrDead(data, i, j);
                if (data[i][j].equals("X")) {

                    if (alive < 2 || alive > 3) {
                        dataNewGen[i][j] = CELL_EMPTY;
                    } else {
                        dataNewGen[i][j] = CELL_ALIVE;
                    }
                } else {
                    if (alive == 3) {
                        dataNewGen[i][j] = CELL_ALIVE;

                    } else {
                        dataNewGen[i][j] = CELL_EMPTY;
                    }

                }
            }
        }
        return dataNewGen;
    }

}
