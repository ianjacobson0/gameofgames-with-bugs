import java.util.Scanner;


public class PlayGames {
  public static int playerWins = 0;
  public static int computerWins = 0;

  public static void main(String args[]) {
    boolean quit = false;
    Scanner s = new Scanner(System.in);

    GetInput getInput = new GetInput();

    while (!quit) {
      System.out.println("1. find the thimble");
      System.out.println("2. coin flip");
      System.out.println("3. guess the number");
      System.out.println("4. even or odd");
      System.out.println("5. find the red thread");
      System.out.println("6. quit");

      int input = getInput.getNumber();

      switch (input) {
        case 1:
          if (FindTheThimble.main() == 1)
            playerWins++;
          else
            computerWins++;
          break;
        case 2:
          CoinFlip coinFlip = new CoinFlip();

          while (true) {
            System.out.println("Enter a series best of number");

            int bestOf = getInput.getNumber();
            if (bestOf != -1 && !isEven(bestOf)) {
              coinFlip.setBestOf(bestOf);
              break;
            }
          }

          while (true) {
            System.out.println("Enter an H or T, to pick HEADS or TAILS...");
            char guess = getInput.getLetter();
            if (guess == 'H' || guess == 'T') {
                coinFlip.makeGuess(guess);

                int result = coinFlip.checkScore();
                if (result == 1) {
                  System.out.println("Player Wins the Series");
                  System.out.println("Game Over");
                  playerWins++;
                  break;
              } else if (result == 0) {
                System.out.println("Computer Wins the Series");
                System.out.println("Game Over");
                computerWins++;
                break;
              }
            }

          }
          break;
        case 3:
          if (GuessTheNumber.playGuessTheNumber() == 1) {
            playerWins++;
          } else {
            computerWins++;
          }
          break;
        case 4:
          if (EvenOrOdd.main() == 1) {
            playerWins++;
          } else {
            computerWins++;
          }
          break;
        case 5:
          int numSpools;
          while (true) {
            System.out.println("Enter number of spools to be pulled");
            numSpools = getInput.getNumber();
            if (numSpools > 0 && numSpools <= 10 )
              break;
          }

          RedSpool redSpool = new RedSpool();

          while (true) {
            //player guess
            System.out.println("Press enter to pick " + numSpools + " spools");
            s.nextLine();
            if (redSpool.makeGuess(numSpools)) {
              System.out.println("Red spool found");
              System.out.println("Player wins");
              playerWins++;
              break;
            }

            // computer guess
            if (redSpool.makeGuess(numSpools)) {
              System.out.println("Red spool found");
              System.out.println("Computer wins");
              computerWins++;
              break;
            }
          }
          break;
        case 6:
          // display scoreboard 
          System.out.println("Player Wins: " + playerWins + " Computer Wins: " + computerWins);
          if (playerWins > computerWins) {
            System.out.println("Player Wins");
          } else if (playerWins == computerWins) {
            System.out.println("Tie");
          } else {
            System.out.println("Computer Wins");
          }
          quit = true; // quit game
          break;  
        default:
          break;
      }
    }
  }

  public static boolean isEven(int x) {
    if (x % 2 == 0) 
      return true;
    else 
      return false;
  }
}
