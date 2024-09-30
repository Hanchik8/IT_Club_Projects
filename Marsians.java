import java.util.Random;
import java.util.Scanner;

public class Marsians {
   // Поля класса (глобальные переменные), доступные во всех методах класса
   int randomPosisionOfBoxes;
   int randomPosisionOfBoxes1;
   int randomPosisionOfBoxes2;

   Scanner scanner = new Scanner(System.in);

   public static void main(String[] args) {
      Marsians obj = new Marsians();

      obj.similary_check();
      for (int i = 1;; i++) {
         // Создаем случайные позиции боксов
         if (i % 6 == 0) {
            obj.similary_check();
            System.out.println();
            System.out.println("Oh no! All the boxes felt that they were trying to find them! Now they fled to different places :(");
            System.out.println("Now I'll have to look for them again -_-");
            System.out.println();
         }

         // Вводим значения для проверки
         System.out.println("Enter the position of the boxes for guessing:");
         int Checking_for_guessing_position = obj.scanner.nextInt();
         int Checking_for_guessing_position1 = obj.scanner.nextInt();
         int Checking_for_guessing_position2 = obj.scanner.nextInt();
         
         // Проверяем, угаданы ли позиции
         boolean ifGuessIsRight = (Checking_for_guessing_position == obj.randomPosisionOfBoxes) ||
               (Checking_for_guessing_position == obj.randomPosisionOfBoxes1) ||
               (Checking_for_guessing_position == obj.randomPosisionOfBoxes2);
               
         boolean ifGuessIsRight1 = (Checking_for_guessing_position1 == obj.randomPosisionOfBoxes) ||
               (Checking_for_guessing_position1 == obj.randomPosisionOfBoxes1) ||
               (Checking_for_guessing_position1 == obj.randomPosisionOfBoxes2);

         boolean ifGuessIsRight2 = (Checking_for_guessing_position2 == obj.randomPosisionOfBoxes) ||
               (Checking_for_guessing_position2 == obj.randomPosisionOfBoxes1) ||
               (Checking_for_guessing_position2 == obj.randomPosisionOfBoxes2);

         // Выводим результат
         obj.announcment_about_tries(ifGuessIsRight, ifGuessIsRight1, ifGuessIsRight2);

         if (ifGuessIsRight && ifGuessIsRight1 && ifGuessIsRight2) {
            break;
         }
      }
   }

   // Метод для создания случайных позиций боксов
   public void similary_check() {
      Random rand = new Random();

      // Генерация случайных positions
      randomPosisionOfBoxes = 1 + rand.nextInt(6);
      randomPosisionOfBoxes1 = 1 + rand.nextInt(6);
      randomPosisionOfBoxes2 = 1 + rand.nextInt(6);

      // Проверка на уникальность значений
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

   public void announcment_about_tries(boolean ifGuessIsRight, boolean ifGuessIsRight1, boolean ifGuessIsRight2) {
      if (ifGuessIsRight && ifGuessIsRight1 && ifGuessIsRight2) {
         System.out.println("You guessed all 3 positions!");
      } else if ((ifGuessIsRight && ifGuessIsRight1) ||
            (ifGuessIsRight && ifGuessIsRight2) ||
            (ifGuessIsRight1 && ifGuessIsRight2)) {
         System.out.println("You guessed 2 positions!");
      } else if (ifGuessIsRight || ifGuessIsRight1 || ifGuessIsRight2) {
         System.out.println("You guessed 1 position.");
      } else {
         System.out.println("You didn't guess anything! Try again.");
      }
   }
}
