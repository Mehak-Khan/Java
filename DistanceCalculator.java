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
public class DistanceCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double lat1; 
        double lat2;
        double lon1; 
        double lon2; 
        double distance;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Longitude 1: ");
        lon1 =  scanner.nextDouble() / 57.29577951;
        System.out.print("Latitude 1: ");
        lat1 =  scanner.nextDouble() / 57.29577951;;
        System.out.print("Longitude 2: ");
        lon2 =  scanner.nextDouble() / 57.29577951;
        System.out.print("Latitude 2: ");
        lat2 =  scanner.nextDouble() / 57.29577951;
        distance = 6378.8 * Math.acos(Math.sin(lat1) * Math.sin(lat2) + 
                Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon2 - lon1));
        
        System.out.println("Distance: " + distance + " km");
        
    }
    
}
