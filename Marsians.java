import java.util.Random;
import java.util.Scanner;

public class Marsians {
     Scanner scanner = new Scanner(System.in);
   public static void main(String[] args) {
      Marsians obj = new Marsians();
      //Creates random box positions
      similary_check();
      int Checking_for_guessing_position = obj.scanner.nextInt();
      int Checking_for_guessing_position1 = obj.scanner.nextInt();
      int Checking_for_guessing_position2 = obj.scanner.nextInt();
      




   }
   public static void similary_check() {
      Random rand = new Random();
      int randomPosisionOfBoxes = 1 + rand.nextInt(6); 
      int randomPosisionOfBoxes1 = 1 + rand.nextInt(6); 
      int randomPosisionOfBoxes2 = 1 + rand.nextInt(6);
   
      while (randomPosisionOfBoxes == randomPosisionOfBoxes1 || 
             randomPosisionOfBoxes2 == randomPosisionOfBoxes1 || 
             randomPosisionOfBoxes == randomPosisionOfBoxes2) {
   
          if (randomPosisionOfBoxes == randomPosisionOfBoxes1) {
              randomPosisionOfBoxes1 = 1 + rand.nextInt(6);
          }
   
          if (randomPosisionOfBoxes2 == randomPosisionOfBoxes1 || 
          randomPosisionOfBoxes2 == randomPosisionOfBoxes) {
              randomPosisionOfBoxes2 = 1 + rand.nextInt(6);
          }
   
          if (randomPosisionOfBoxes == randomPosisionOfBoxes2) {
              randomPosisionOfBoxes = 1 + rand.nextInt(6);
          }
      }
   }
}

