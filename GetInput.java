//game of games assignemnt
//Author: Colin
import java.util.InputMismatchException;
import java.util.Scanner;

public class GetInput{

    static Scanner scan  = new Scanner(System.in);
    //user number
    public static int amount;
    //user character
    public static char userLetter;

    public static int getNumber(){
        Scanner input = new Scanner(System.in);
        //flag1 controls the loop
        boolean flag1 = true;
        while (flag1 == true){
            System.out.println("Insert number:");
            try
            {
                amount = input.nextInt();
                //close the loop
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
        //flag2 controls the loop
        boolean flag2 = true;
        System.out.println("Please enter a letter");
        while(flag2 == true){
            userLetter = scan.next().charAt(0);
            if (Character.isLetter(userLetter) == true){
                //close the loop
                flag2 = false;
            }
            else{
                System.out.println("Invalid input, please enter a valid letter"); 
            }
        }
        return userLetter;
    }



  

    public static void main(String[] args){     
        int a = 0;
        getNumber();
        System.out.println("Amount:" +  amount);
        getLetter();
        System.out.println("User letter:" + userLetter);
    }
         
    


   
}
