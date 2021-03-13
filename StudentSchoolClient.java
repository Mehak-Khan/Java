/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.khan.ics4u.u4;

/**
 *
 * @author 1khanmeh3
 */
public class StudentSchoolClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        School school = new School();
        
        school.setRating( 100 );
        
        System.out.println( school.getRating() );
        
        
    }
    
}
