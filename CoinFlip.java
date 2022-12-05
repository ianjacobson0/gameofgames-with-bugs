import java.util.Random;

public class CoinFlip {
  private int bestOf;
  private int w = 0;
  private int l = 0;

  public void setBestOf(int x) {
    bestOf = x;
  }

  public void makeGuess(char g) {
    char result;

    Random r = new Random();
    float rNum = r.nextFloat();
    if (rNum < 0.5) {
      result = 'H';
      System.out.println("HEADS");
    }
    else {
      result = 'T';
      System.out.println("TAILS");
    }

    if (g == result) {
    } else {
      l++;
    }

  }

  // return 1 if playe wins
  // returns 0 if computer wins
  // returns 2 if nobody wins
  public int checkScore() {
    int winningScore = (bestOf / 2) + 1;
    if (w >= winningScore)
      return 1;
    if (l >= winningScore)
      return 0;
    else
      return 2;
  }
}