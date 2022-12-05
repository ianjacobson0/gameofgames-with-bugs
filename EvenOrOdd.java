/**
 * Even Odd game
 *
 * @author Nassar
 * @version 12/1/2022
 */
import java.util.*;
public class EvenOrOdd {
    private static int score1 = 0;
    private static int score2 = 0;
    public static int main() {
        System.out.println("Even or Odd");
        String player1choice = "E"; 
        String player2choice = "O";
        
        System.out.println("player 1 is assigned to Even");
        System.out.println("player 2 is assigned to Odd");
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        
        System.out.println("player 1, choose a number between 1-5");
        int choice1 = input1.nextInt();
        System.out.println("player 2, choose a number between 1-5");
        int choice2 = input2.nextInt();
        check(choice1, choice2);
        int sum = choice1 + choice2;
        EorO(sum);
        if (score1 > 0)
            return 1;
        else    
            return 0;
    }
        
    public static void check(int choice1, int choice2){
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
         if(choice1 <= 5 && choice1 >= 1 && choice2 <= 5 && choice2 >= 1){
                System.out.println("player's 1 choice: " + choice1);
                System.out.println("player's 2 choice: " + choice2);
                //flag1 = true;
            }
            
         else if(choice1 > 5 || choice1 < 1 ){
                System.out.println("player1, please re-enter an input within range");
                System.out.println("player 1, choose a number between 1-5");
                int choice3 = input1.nextInt();
                check(choice3, choice2);
                //flag1 = false;
            }
            
         else if(choice2 > 5 || choice2 < 1 ){
                System.out.println("player2, please re-enter an input within range");
                System.out.println("player 2, choose a number between 1-5");
                int choice4 = input1.nextInt();
                check(choice1, choice4);
                //flag1 = false;
            }
         
        
    }
       
        public static void EorO(int sum){
            score1 = 0;
            score2 = 0;
        if(sum % 2 == 0){
            System.out.println("player 1 wins!");
            score1++;
        }
        else{
            System.out.println("player 2 wins!");
            score2++ ;
        }
        
        System.out.println("score: player1: " + score1 + "  player2: " + score2);
        
    }
}


