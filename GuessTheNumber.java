/*guess the number for GoG assignment
Author: Colin
Version: contains bugs
IMPORTANT NOTE: some of what was said over slack contradicts the orignal use case. In those instances, I went with what was said on slack, as it was more recent.
*/
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class GuessTheNumber extends GetInput{

    //user number
    public static int amount;
    //upper and lower bounds for the range, which is intitially all positve integers
    public static int lowerBound = 0;
    public static double upperBound = Double.POSITIVE_INFINITY;
    
    
    

    public static int getNumber(){
        Scanner input = new Scanner(System.in);
        //controls loop
        boolean flag1 = true;
        while (flag1 == true){
            System.out.println("Enter a number in range " + lowerBound + " to " + upperBound);
            try{
                amount = input.nextInt();
                //closes loop
                flag1 = false;
            } 
            catch (Exception e){
                input.nextLine();
                //wrong kind of input string message
                System.out.println("Enter an integer input");
            }
        }
        return amount;
    }
    public static int playGuessTheNumber(){
        Random random = new Random();
        //player is prompted to enter a number to define range
        getNumber();
        //computer picks random number in the range
        int numberToGuess = random.nextInt(amount);
        // for test version: 
        System.out.println(numberToGuess);
        upperBound = amount;
        boolean gameLoopFlag = true;
        int guessCounter = 0;
        int numberofGuesses = (int) Math.ceil(amount/2);
        //loop starts
        while(gameLoopFlag == true){
            //player is prompted to make a guess
            getNumber();
            if(amount == numberToGuess){
                System.out.println("Congratulations you won! You correctly guessed that the number was " + numberToGuess);
                //closes loop
                gameLoopFlag = false;
                return 0;
                //return user to main menu with updated score (user score++)

        }
        else if (guessCounter + 1 == numberofGuesses){
            //use case had a different ending message, but Mateo told me to use this one via slack
            System.out.println("Game Over, you lost");
            //closes loop
            gameLoopFlag = false;
            //return user to main menu with updated score (computer score++)
            return 1;

        }
        else{
            
            if(amount < lowerBound){
                System.out.println("The number is out of range");
            }
            else if (amount != numberToGuess){
                int attemptsRemaining = numberofGuesses - guessCounter;
                System.out.println("Your guess was incorrect, " + amount + " was not the number. Attempts left:" + attemptsRemaining);
            }
            
        }

     }
     return 0;
    }   
}
