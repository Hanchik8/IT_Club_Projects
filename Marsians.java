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
            System.out.println("О нет! Все ящики почувствовали что их пытаются найти! Теперь они разбежались по разным местам :(");
            System.out.println("Теперь придётся искать их снова -_-");
            System.out.println();
         }

         // Вводим значения для проверки
         System.out.println("Введите позицию ящиков для угадывания:");
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
         System.out.println("Вы угадали все 3 позиции!");
      } else if ((ifGuessIsRight && ifGuessIsRight1) ||
            (ifGuessIsRight && ifGuessIsRight2) ||
            (ifGuessIsRight1 && ifGuessIsRight2)) {
         System.out.println("Вы угадали 2 позиции!");
      } else if (ifGuessIsRight || ifGuessIsRight1 || ifGuessIsRight2) {
         System.out.println("Вы угадали 1 позицию.");
      } else {
         System.out.println("Вы ничего не угадали! Попробуйте снова.");
      }
   }
}
