import java.util.Random;

public class RedSpool {
  int totalSpools = 30;

  public boolean makeGuess(int x) {
    Random rand = new Random();
    double xFloat = (double) x;
    double probability = xFloat / (float) totalSpools;
    if (rand.nextFloat() < probability) {
      return false;
    } else if (totalSpools <= 0) {
      System.out.println("Here");
      return true;
    }
    totalSpools -= x;
    return false;
  }
}