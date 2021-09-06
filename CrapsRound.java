/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package craps;
import java.util.Random;

/**
 *
 * @author armel
 */

/*
 * ITSC 1213 Programming Checkpoint 1
 * The CrapsRound class provides constructors and methods to be used for CrapsRound objects
 */

public class CrapsRound {
    
    Random gen = new Random();
    
    public int wins = 0; // incrementable variable to keep track of wins
    public int losses = 0; // incrementable varibale to keep track of losses
    
    public int max; // max and mins variables for random number generator
    public int min;
    
    public int ranNum1; // initializes the two random numbers
    public int ranNum2;
    
    public int rollNum = 1; // initializes variable to keep track of number of rolls
    public int roll; // variable used for the sum of the results from dice roll
    
    /**
     * used to create a CrapsRound object using the given values
     * @param min
     * @param max 
     */
    public CrapsRound(int min, int max){ // Constructor used to find the random numbers between the two given numbers
        this.max = max;
        this.min = min;
    }
    
    /**
     * Method finding random numbers for the first dice
     */
    public void Random1(){
        ranNum1 = (int)(min + gen.nextInt((max - min) + 1)); // random num generators to simulate dice roll
        
        if (ranNum1 == 0){
            ranNum1 = (int)(min + gen.nextInt((max - min) + 1)); // used to make sure 0 is not a number given from roll
        }

    }
    
    /**
     * Method finding random numbers for the second dice
     */
    public void Random2(){
        ranNum2 = (int)(min + gen.nextInt((max - min) + 1)); // random num generators to simulate dice roll
        
        if (ranNum2 == 0){
            ranNum2 = (int)(min + gen.nextInt((max - min) + 1)); // used to make sure 0 is not a number given from roll
        }

    }
    
    /**
     * method to print the basic details of a roll
     */
    public void printDetails(){
        roll = ranNum1 + ranNum2;
        
        String result = "";
        if (roll == 7 || roll == 1) { // used to figure out whether the roll is a come-out win
            result = "wins";
        }
        else if (roll == 2 || roll == 3 || roll == 12){ // used to figure out whether the roll is a come-out loss
            result = "loses, Craps!";
        }
        
        System.out.println("Roll " + rollNum + "\n Die 1 rolled a " + ranNum1 
                + " and Die 2 rolled a " + ranNum2 + ". Your roll total is " 
                + roll + ", come-out roll " + result + "\n");
    }
    
    /**
     * Method for the loop of the first 10 rounds
     */
    public void firstTen(){
        for (int rounds = 1; rounds <= 10; rounds++) {
            System.out.println("****** Round " + rounds + " Results ****** \n");
            Random1();
            Random2();
            rollNum = 1; // resets the roll count to 1 each time
            roll = ranNum1 + ranNum2; // gets the sum of the dice roll 
            
            switch(roll){ // loop used to determine come-out win or loss or if more rolls are needed
                case 7:
                    printDetails(); // calls printDetails method and increments wins by 1
                    wins += 1;
                    break;
                case 11:
                    printDetails(); // calls printDetails method and increments wins by 1
                    wins += 1;
                    break;
                case 2:
                    printDetails(); // calls printDetails method and increments losses by 1
                    losses += 1;
                    break;
                case 3:
                    printDetails(); // calls printDetails method and increments losses by 1
                    losses += 1;
                    break;
                case 12:
                    printDetails(); // calls printDetails method and increments losses by 1
                    losses += 1;
                    break;
                default:
                    System.out.println("Roll " + rollNum); // prints basic details of the roll
                    int roundPoint = roll;
                    System.out.println("Die 1 rolled a " + ranNum1 + " and die 2 rolled a " 
                            + ranNum2 + ". Your total is " + roundPoint 
                            + ". Your round point is " + roundPoint + "\n");
                    
                    
                    int random1; // creates a new set of random numbers and total
                    int random2;
                    int total;
                    
                    do { // loops the following code while the bottom condition is true
                        random1 = (int) (min + gen.nextInt((max - min) + 1));
                        if (random1 == 0) {
                            random1 = (int) (min + gen.nextInt((max - min) + 1));
                        }
                        
                        random2 = (int) (min + gen.nextInt((max - min) + 1));
                        if (random2 == 0) {
                            random2 = (int) (min + gen.nextInt((max - min) + 1));
                        }
                        
                        total = random1 + random2;
                        
                        rollNum += 1;
                        System.out.println("Roll " + rollNum);
                        System.out.println("Die 1 rolled a " + random1 + " and Die 2 rolled a " 
                                + random2 + ". Your total is " + total + "\n");
                        
                        
                        
                    } while(total != roundPoint && total != 7); // condition needed for the round to end
                    
                        if (total == roundPoint) { // if statement for a victory and increments wins
                            wins += 1;
                            System.out.println("VICTORY! \n");
                        } 
                        else if (total == 7) { // if statement for a loss and increments losses
                            losses += 1;
                            System.out.println("YOU LOSE! \n");
                        }
                    
                    
                  
                
            }
            
            System.out.println("Wins: " + wins); // prints the total wins and losses
            System.out.println("Losses: " + losses);
            System.out.println("\n");
        }
        
    }
    
    /**
     * Method for the loop of the last final rounds
     */
    public void finalRounds(){
        
        for (int rounds = 11; rounds <= 100000; rounds++) {
            Random1();
            Random2();
            rollNum = 1; // resets the roll count to 1 each time
            roll = ranNum1 + ranNum2; // gets the sum of the dice roll 
            
            switch(roll){ // loop used to determine come-out win or loss or if more rolls are needed
                case 7:                     
                    wins += 1; // increments wins by 1
                    break;
                case 11:
                    wins += 1; // increments wins by 1
                    break;
                case 2:
                   losses += 1; // increments losses by 1                    
                    break;
                case 3:
                    losses += 1; // increments losses by 1 
                    break;
                case 12:
                    losses += 1; // increments losses by 1 
                    break;
                default:
                    int roundPoint = roll;                    
                    
                    int num1; // creates a new set of random numbers and total
                    int num2;
                    int total2;
                    
                    do { // loops the following code while the bottom condition is true
                        num1 = (int) (min + gen.nextInt((max - min) + 1));
                        if (num1 == 0) {
                            num1 = (int) (min + gen.nextInt((max - min) + 1));
                        }
                        
                        num2 = (int) (min + gen.nextInt((max - min) + 1));
                        if (num2 == 0) {
                            num2 = (int) (min + gen.nextInt((max - min) + 1));
                        }
                        
                        total2 = num1 + num2;
                        
                        rollNum += 1;                                               
                        
                    } while(total2 != roundPoint && total2 != 7); // condition needed for the round to end
                    
                        if (total2 == roundPoint) { // if statement for a victory and increments wins
                            wins += 1;
                        } 
                        else if (total2 == 7) { // if statement for a loss and increments losses
                            losses += 1;
                        }
                    
                    
                  
                
            }
            
            
        }
        System.out.println("******Overall Wins and Losses****** \n");
        System.out.println("Wins: " + wins); // prints the total wins and losses
        System.out.println("Losses: " + losses);
    }
    
    
    
}
