/* Name: Mehak Khan
 * Date: April 4th, 2019
 * Program: Mountain Paths
 * Description: Find the best possible path with the lowest elevation change 
 * through mountains.
 */
package edu.hdsb.gwss.khan.ics4u.u3;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author 1khanmeh3
 */
public class MountainPaths {

    static final String FS = File.separator;

    /**
     * Mount Paths
     */
    public static void main(String[] args) throws Exception {

        // ***********************************
        // TASK 1:  read data into a 2D Array
        // 
        System.out.println("TASK 1: READ DATA");
        int[][] data = read("." + FS + "data" + FS + "mountain.paths" + FS + "Colorado.844x480.dat");

        // ***********************************
        // Construct DrawingPanel, and get its Graphics context
        //
        DrawingPanel panel = new DrawingPanel(data[0].length, data.length);
        Graphics g = panel.getGraphics();

        // ***********************************
        // TASK 2:  find HIGHEST & LOWEST elevation; for GRAY SCALE
        //
        System.out.println("TASK 2: HIGHEST / LOWEST ELEVATION");
        int min = findMinValue(data);
        System.out.println("\tMin: " + min);

        int max = findMaxValue(data);
        System.out.println("\tMax: " + max);

        // ***********************************
        // TASK 3:  Draw The Map
        //
        System.out.println("TASK 3: DRAW MAP");
        drawMap(g, data);

        // ***********************************
        // TASK 4A:  implement indexOfMinInCol
        //
        System.out.println("TASK 4A: INDEX OF MIN IN COL 0");
        int minRow = indexOfMinInCol(data, 0);
        System.out.println("\tRow with lowest Col 0 Value: " + minRow);

        //***********************************
        // TASK 4B:  use minRow as starting point to draw path
        //
        System.out.println("TASK 4B: PATH from LOWEST STARTING ELEVATION");
        g.setColor(Color.RED);
        int totalChange = drawLowestElevPath(g, data, minRow, 0); //
        System.out.println("\tLowest-Elevation-Change Path starting at row " + minRow + " gives total change of: " + totalChange);

        // ***********************************
        // TASK 5:  determine the BEST path
        g.setColor(Color.RED);
        int bestRow = indexOfLowestElevPath(g, data);
        System.out.println(bestRow);
//
//        // ***********************************
        // TASK 6:  draw the best path
        //
        System.out.println("TASK 6: DRAW BEST PATH");
        //drawMap.drawMap(g); //use this to get rid of all red lines
        g.setColor(Color.GREEN); //set brush to green for drawing best path
        totalChange = drawLowestElevPath(g, data, bestRow, 0);
        System.out.println("\tThe Lowest-Elevation-Change Path starts at row: " + bestRow + " and gives a total change of: " + totalChange);
    }

    /**
     * This method reads a 2D data set from the specified file. The Graphics'
     * industry standard is width by height (width x height), while programmers
     * use rows x cols / (height x width).
     *
     * @param fileName the name of the file
     * @return a 2D array (rows x cols) of the data from the file read
     */
    public static int[][] read(String fileName) throws FileNotFoundException {

        int lines = 1;
        int col = 0;
        File file = new File(fileName);
        Scanner fileInput = new Scanner(file);
        StringTokenizer st = new StringTokenizer(fileInput.nextLine());

        //COUNT columns by looping through the tokens in one line
        while (st.hasMoreTokens()) {
            col++;
            st.nextToken();
        }
        //COUNT LINES by looping through the file
        while (fileInput.hasNextLine()) {
            lines++;
            fileInput.nextLine();
        }

        /**
         * sort the data in the file to an array using the number of rows
         * (lines) and columns found
         */
        int[][] data = new int[lines][col];
        file = new File(fileName);
        fileInput = new Scanner(file);
        for (int i = 0; i < data.length; i++) {
            st = new StringTokenizer(fileInput.nextLine());
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());

            }

        }

        return data;
    }

    /**
     * @param grid a 2D array from which you want to find the smallest value
     * @return the smallest value in the given 2D array
     */
    public static int findMinValue(int[][] grid) {
        //Set the first value of the array to min 
        int min = grid[0][0];
        //loop through the array to find value the min value
        for (int i = 0; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                if (grid[i][j] < min) {
                    min = grid[i][j];
                }
            }

        }

        return min;

    }

    /**
     * @param grid a 2D array from which you want to find the largest value
     * @return the largest value in the given 2D array
     */
    public static int findMaxValue(int[][] grid) {
        //Set the first value of the array to max
        int max = grid[0][0];
        //loop through the array to find value the max value
        for (int i = 0; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }

        }
        return max;

    }

    /**
     * Given a 2D array of elevation data create a image of size rows x cols,
     * drawing a 1x1 rectangle for each value in the array whose color is set to
     * a a scaled gray value (0-255). Note: to scale the values in the array to
     * 0-255 you must find the min and max values in the original data first.
     *
     * @param g a Graphics context to use
     * @param grid a 2D array of the data
     */
    public static void drawMap(Graphics g, int[][] data) {
        double max = findMaxValue(data); //MAX value
        double min = findMinValue(data); //MIN value
        double c = 0; //GRAYSCALE value

        //loop through the array to colour every pixel according to grayscale v
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {

                // (data value - min / range) *255 = grayscale value
                c = (((data[i][j]) - min) / (max - min)) * 255;

                g.setColor(new Color((int) c, (int) c, (int) c));
                g.fillRect(j, i, 1, 1);

            }

        }

    }

    /**
     * Scan a single column of a 2D array and return the index of the row that
     * contains the smallest value
     *
     * @param grid a 2D array
     * @col the column in the 2D array to process
     * @return the index of smallest value from grid at the given col
     */
    public static int indexOfMinInCol(int[][] grid, int col) {
        //set the min row to 0
        int min = grid[0][col];
        int index = 0;

        //loop through every row to find the minimum rowValue for a certain col
        for (int i = 1; i < grid.length; i++) {
            if (grid[i][col] < min) {
                min = grid[i][col];
                index = i;
            }

        }
        return index;
    }

    /**
     * Find the minimum elevation-change route from West-to-East in the given
     * grid, from the given starting row, and draw it using the given graphics
     * context
     *
     * @param g - the graphics context to use
     * @param grid - the 2D array of elevation values
     * @param row - the starting row for traversing to find the min path
     * @return total elevation of the route
     */
    public static int drawLowestElevPath(Graphics g, int[][] data, int row, int col) {

        //BASE CASE if last column is reached
        if (col == data[row].length - 1) {
            return 0;
        }

        g.fillRect(col, row, 1, 1);

        //variable for elevation change for path FWD, DOWN and UP
        int pathFwd = Math.abs(data[row][col + 1] - data[row][col]);
        int pathFwdUp;
        int pathFwdDown;

        /**
         * if row is zero, set UP path to max integer value to avoid going up as
         * that would result in an index out of bounds error
         */
        if (row == 0) {
            pathFwdUp = Integer.MAX_VALUE;
        } else {
            pathFwdUp = Math.abs(data[row - 1][col + 1] - data[row][col]);
        }
        /**
         * if row is highest, set DOWN path to max integer value to avoid going
         * down as that would result in an index out of bounds error
         */
        if (row == data.length - 1) {
            pathFwdDown = Integer.MAX_VALUE;
        } else {
            pathFwdDown = Math.abs(data[row + 1][col + 1] - data[row][col]);
        }

        /**
         * CHECK to see if FWD path is LESS THAN/EQUAL TO UP and DOWN if TRUE
         * --> move FWD
         */
        if (pathFwd <= pathFwdUp && pathFwd <= pathFwdDown) {
            return pathFwd + drawLowestElevPath(g, data, row, col + 1);

            /**
             * CHECK to see if UP path is LESS THAN DOWN if TRUE --> move UP
             */
        } else if (pathFwdUp < pathFwdDown) {
            return pathFwdUp + drawLowestElevPath(g, data, row - 1, col + 1);

            /**
             * CHECK to see if DOWN path is LESS THAN UP if TRUE --> move DOWN
             */
        } else if (pathFwdDown < pathFwdUp) {
            return pathFwdDown + drawLowestElevPath(g, data, row + 1, col + 1);

            ///IF UP and DOWN are equal choose randomly between the paths
        } else {
            int path = (int) (Math.random() * 2);
            if (path == 1) {
                return pathFwdDown + drawLowestElevPath(g, data, row + 1, col + 1);
            } else {
                return pathFwdUp + drawLowestElevPath(g, data, row - 1, col + 1);
            }
        }

    }

    /**
     * Generate all west-to-east paths, find the one with the lowest total
     * elevation change, and return the index of the row that path starts on.
     *
     * @param g - the graphics context to use
     * @param grid - the 2D array of elevation values
     * @return the index of the row where the lowest elevation-change path
     * starts.
     */
    public static int indexOfLowestElevPath(Graphics g, int[][] data) {
        //SET MIN elevation change to the one in row 0
        int min = drawLowestElevPath(g, data, 0, 0);
        int index = 0;
        /**
         * LOOP through the array length to find the min elevation change AND
         * draw all the paths
         */
        for (int i = 1; i < data.length; i++) {
            int x = drawLowestElevPath(g, data, i, 0);
            if (x < min) {
                min = x;
                index = i;
            }

        }
        return index;

    }

}
