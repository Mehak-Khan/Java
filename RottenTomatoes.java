/* Name: MEHAK KHAN
 * Date: 22nd FEBRUARY 2019
 * Program: ROTTEN TOMATOES
 * Description: Calculates whether or not a movie review is positive/negative.
 */
package edu.hdsb.gwss.khan.ics4u.u1.rt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author 1khanmeh3
 */
public class RottenTomatoes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        //MENU - user enters option
        Scanner input = new Scanner(System.in);
        int option = 1;
        //RUN THE PROGRAM UNTIL EXITED (option 5)
        while (option >= 1 && option < 5) {
            option = 0;
            //CHECK FOR INVALID INPUT
            while (option < 1 || option > 5) {
                try {
                    System.out.print("\nWhat Would You Like To Do?\n1: Get the score of a "
                            + "word\n2: Get the average score of words in a file "
                            + "(one word per line)\n3: Find the highest/lowest scoring "
                            + "words in a file\n4: Sort words from a file into positive.txt"
                            + " and negative.txt\n5: Exit the program\nEnter a number (1-5): ");
                    option = Integer.parseInt(input.nextLine());
                    if (option < 1 || option > 5) {
                        System.out.println("\nInvalid input. Try again.\n");
                    }
                } //CHECK FOR USER INPUT AS A NON INTEGER VALUE
                catch (Exception e) {
                    System.out.println("\nInvalid input. Try again.\n");
                }
            }

            //PART 1
            if (option == 1) {
                //to check if word exists
                boolean wordFound = false;
                while (wordFound != true) {
                    System.out.print("\nEnter Word: ");
                    String word = input.nextLine();

                    //SORTS THE SCORE OF THE WORD AND WORDCOUNT INTO A 2D ARRAY
                    double scoreArray[][] = getAverageScore(getFileArray(getNumberOfLines("MovieReviews.txt"),
                            "MovieReviews.txt"), word);
                    if (scoreArray[1][0] == 0) {
                        //WORD NOT FOUND LOOP
                        System.out.println("\nWord not found. Try again.\n");
                    } else {
                        //WORD FOUND
                        System.out.println(word + " appears " + (int) scoreArray[1][0] + " times.");
                        //AVERAGE SCORE = SCORE/ WORD COUNT
                        System.out.println("The average score is "
                                + scoreArray[0][0] / scoreArray[1][0]);
                        wordFound = true;
                    }
                }
            } //PART 2, 3, and 4
            else if (option == 3 || option == 2 || option == 4) {
                //ASK USER FOR NAME OF FILE
                String fileName;
                //boolean to check if file exists
                boolean fileNotFound = false;

                while (fileNotFound != true) {
                    System.out.print("\nEnter file name: ");
                    fileName = input.nextLine();

                    try {
                        String arrayOfLines[] = getFileArray(getNumberOfLines(fileName), fileName);
                        double avgScore = 0;

                        switch (option) {
                            case 2:
                                getSentiment(arrayOfLines, avgScore, fileName);
                                break;

                            case 3:
                                getMaxAndMin(arrayOfLines);
                                break;

                            case 4:
                                sortToFiles(arrayOfLines, avgScore);
                                break;

                        }
                        fileNotFound = true;

                        //FILE DOES NOT EXIST - LOOP
                    } catch (FileNotFoundException ex) {
                        System.out.println("\nFile not found. Try again.\n");
                    }
                }

            }
        }
    }

    //METHOD FOR PART 1
    public static double[][] getAverageScore(String[] movie, String word) {
        //initialize word count
        int wordCount = 0;
        //2D array to store score AND word count
        double[][] score = new double[2][1];
        //loop through the array to check if array contains word
        for (String movie1 : movie) {
            String line = movie1.toLowerCase();
            String lineArray[] = line.split(" ");
            if (line.contains(word.toLowerCase())) {
                for (String lineArray1 : lineArray) {
                    //store score and word count in the array
                    if (lineArray1.equals(word.toLowerCase())) {
                        score[0][0] = score[0][0] + (movie1.charAt(0) - '0');
                        wordCount++;
                        score[1][0] = wordCount;
                    }
                }
            }
        }
        return score;

    }

    //METHOD FOR PART 2
    public static void getSentiment(String array[], double avgScore, String fileName) throws FileNotFoundException {
        double scoreArray = 0;
        double avgCount = 0;
        for (String array1 : array) {
            //ADDS THE TOTAL SCORES TO AN ARRAY
            scoreArray = scoreArray + getAverageScore(getFileArray(getNumberOfLines("MovieReviews.txt"),
                    "MovieReviews.txt"), array1)[0][0];
            //ADDS THE TOTAL WORD COUNT IN AN ARRAY
            avgCount = avgCount + getAverageScore(getFileArray(getNumberOfLines("MovieReviews.txt"),
                    "MovieReviews.txt"), array1)[1][0];
        }
        //DIVISION TO FIND AVERAGE SCORE
        avgScore = scoreArray / avgCount;

        //SENTIMENT CALCULATION
        String sentiment;
        if (avgScore > 2) {
            sentiment = "positive";
        } else if (avgScore < 2) {
            sentiment = "negative";
        } else {
            sentiment = "neutral";
        }

        System.out.println("The average score is of words in "
                + fileName + " is " + avgScore);
        System.out.println("The overall sentiment is " + sentiment + ".");
    }

    //METHOD FOR PART 3 
    public static void getMaxAndMin(String array[]) throws FileNotFoundException {
        //array = fileArray(numberOflines(fileName), fileName);
        double max = 0;
        double min = 4;
        String posWord = "";
        String negWord = "";
        Double[] score = new Double[array.length];
        for (int i = 0; i < array.length; i++) {
            double scoreArray[][] = getAverageScore(getFileArray(getNumberOfLines("MovieReviews.txt"),
                    "MovieReviews.txt"), array[i]);
            score[i] = scoreArray[0][0] / scoreArray[1][0];

            if (score[i] > max) {
                max = score[i];
                posWord = array[i];
            }
            if (score[i] < min) {
                min = score[i];
                negWord = array[i];
            }
        }
        System.out.println("most positive word is " + posWord
                + " with a score of " + max);
        System.out.println("most negative word is " + negWord
                + " with a score of " + min);
    }

    //METHOD FOR PART 4
    public static void sortToFiles(String array[], double avgScore) throws FileNotFoundException {
        //POSITIVE.TXT AND NEGATIVE.TXT FILES
        PrintWriter writerPos = new PrintWriter(".\\data\\movie.review\\positive.txt");
        PrintWriter writerNeg = new PrintWriter(".\\data\\movie.review\\negative.txt");

        /*LOOP TO CALCULATE SCORE OF EVERY WORD AND SORT
        IT INTO THE FILES*/
        for (String array1 : array) {
            double[][] avgScoreArray = getAverageScore(getFileArray(getNumberOfLines("MovieReviews.txt"),
                    "MovieReviews.txt"), array1);
            avgScore = avgScoreArray[0][0] / avgScoreArray[1][0];
            if (avgScore > 2.1) {
                writerPos.println(array1);
            } else if (avgScore < 1.9) {
                writerNeg.println(array1);
            }
        }
        //close both the files
        writerNeg.close();
        writerPos.close();
    }

    //METHOD TO CALCULATE THE NUMBER OF LINES A FILE CONTAINS
    public static int getNumberOfLines(String name) throws FileNotFoundException {
        //MACBOOK
        File file = new File(".//data//movie.review//" + name);
        //WINDOWS
        //File file = new File(".\\data\\movie.review\\" + name);
        Scanner fileInput = new Scanner(file);
        int lines = 0;
        //add to the variable lines
        while (fileInput.hasNextLine()) {
            lines++;
            fileInput.nextLine();

        }
        return lines;
    }

    //METHOD TO PUT THE LINES OF FILE INTO AN ARRAY
    public static String[] getFileArray(int size, String name) throws FileNotFoundException {
        String[] movie = new String[size];
        int i = 0;
        //MACBOOK
        File file = new File(".//data//movie.review//" + name);
        //WINDOWS
        //File file = new File(".\\data\\movie.review\\" + name);
        Scanner fileInput = new Scanner(file);

        //store each line into the array
        while (fileInput.hasNextLine()) {
            movie[i] = fileInput.nextLine();

            i++;

        }
        return movie;
    }

}
