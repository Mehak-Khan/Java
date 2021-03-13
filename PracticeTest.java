/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.khan.ics4u.u3;

/**
 *
 * @author mehakkhan
 */
public class PracticeTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //EUCLID ALGORITHM
        //GCD
        System.out.println(gcd(54,90)); 
        int[] array = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
        System.out.println(binarySearch(2,array,0, 10));
    }
    public static int gcd(int m, int n) {
        if (m == n) return m;
        if (n > m) return gcd (n, m);
        return gcd(n, m-n);
    }
    
    public static int binarySearch (int search, int[] array, int start, int end) {
        int middle = (start+end)/2;
        if (end < start) {
            return -1;
        }  
        if (search < array[middle]) {
            return binarySearch(search, array, start, middle-1); 
        }
        if (search > array[middle]) {
            return binarySearch(search, array, middle+1, end); 
        }
        if (search == array[middle]) {
            return middle;
        }
        return -1;
    }
    
}
