//Author: Ryan Le
//version 1.0

import java.util.*;
import java.io.*;


public class FindTheThimble extends GetInput {

	public static int amount;
	public static char userLetter;

	public static int getNumber(){
        Scanner input = new Scanner(System.in);
        boolean flag1 = true;
        while (flag1 == true){
            System.out.println("Insert number:");
            try
            {
                amount = input.nextInt();
                flag1 = false;
            } 
            catch (Exception e){
                input.nextLine();
                System.out.println("Enter an integer input");
            }
        }
        return amount; 
    }

    public static char getLetter(){
        boolean flag2 = true;
        System.out.println("Please enter L or R:");
        while(flag2 == true){
            userLetter = scan.next().charAt(0);
            if (Character.isLetter(userLetter) == true){
                flag2 = false;
            }
            else{
                System.out.println("Invalid input, please enter a valid letter"); 
            }
        }
        return userLetter;
    }
	
    public static boolean checkLetter(char letter) {
	    if (letter == 'L' || letter == 'R') {
		    return true;
	    }
	    else {
		    return false;
	    }
		}
    //Method to execute the game 
    public static void findThimble(int best, int correct, int incorrect, int cmpcorrect, int cmpincorrect, int check, char[] choice, int randInt, int cmpRand) {
    	int i = 0;

    	char guess;
	char hide;

	int splitWin = (best/2)+1;
	int splitLost = best/2;
	    //loop the best of number
	while (i<best) {
		System.out.println("Guess Left or Right. Enter L or R: ");
		guess = Character.toUpperCase(getLetter());
		while(checkLetter(guess) == false) {
			guess = Character.toUpperCase(getLetter());
		}

		if(guess == (choice[randInt])) {
			System.out.println("You're correct");
			correct++;
			if (correct == splitWin) {	//check score with half of best of number
				System.out.println("Congratulations you won Find the Thimble!");
				check = 1;	//save score to return
				break;
			}
		}
		else {
			System.out.println("You're incorrect");
			incorrect++;
			if(incorrect == splitLost) {
				System.out.println("Game over. The computer won. Better luck next time!");
				break;
			}

		}
		System.out.print("Choose Left or Right to hide the thimble. Enter L or R: ");
		hide = Character.toUpperCase(getLetter());
		while(checkLetter(hide) == false) {
			hide = Character.toUpperCase(getLetter());
		}
		System.out.println("Computer guessing: " + choice[cmpRand]);	//print out computer's guess
		if (choice[cmpRand] == hide) {
			System.out.println("Computer is correct!");
			cmpcorrect++;
			if(cmpcorrect == splitWin) {
				System.out.println("Game over. The computer won. Better luck next time!");
				break;
			}
		}
		else {
			System.out.println("Computer is incorrect!");
			cmpincorrect++;
		}
		i++;
	}

    }
	//check if input is odd or even
    public static boolean checkOdd(int n) {
    	if (n%2 == 0) {
    		return false;
    	}
    	else {
    		return true;
    	}
    }


	//Main method to be called in PlayGames
	public static int main () {
		//GetInput input = new GetInput();
		int correct = 0;
		int incorrect = 0;
		int cmpcorrect = 0;
		int cmpincorrect = 0;
		int check = 0;

		
		char[] choice = {'L', 'R'};
		Random rand = new Random();
		int randInt = rand.nextInt(2); //generating random numbers to use in computer guesses from array of character
		int cmpRand = rand.nextInt(2);

		System.out.println("Find The Thimble");
		System.out.println("Enter the best out of number, must be an odd number: ");
		getNumber();
		int best = amount;

		
		if(best%2 == 0) {
			while (checkOdd(best) == false) {
				System.out.println("Please re-enter!");
				best = getNumber();
			}
			findThimble(best, correct, incorrect, cmpcorrect, cmpincorrect, check, choice, randInt, cmpRand);
		}
		else {
			findThimble(best, correct, incorrect, cmpcorrect, cmpincorrect, check, choice, randInt, cmpRand);	
		}
		if (check == 1) {
			return 1;
			}
		else {
			return 0;
		}
	}
}
