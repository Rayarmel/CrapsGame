/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package craps;

/**
 *
 * @author armel
 */
public class Craps {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        CrapsRound round = new CrapsRound(1,6); // creates a new CrapsRound object
        round.Random1(); // creates two random numbers which represent the two value of the die
        round.Random2();
        
        round.firstTen(); // calls the firstTen method to get the details of the first ten rounds
        round.finalRounds(); // calls the finalRounds method to get the results of the final rounds
        
    }
    
}
