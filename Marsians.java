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

      // Создаем случайные позиции боксов
      obj.similary_check();

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
      if (ifGuessIsRight && ifGuessIsRight1 && ifGuessIsRight2) {
         System.out.println("Угадал все!");
      } else if ((ifGuessIsRight && ifGuessIsRight1) ||
                 (ifGuessIsRight && ifGuessIsRight2) ||
                 (ifGuessIsRight1 && ifGuessIsRight2)) {
         System.out.println("Угадал 2 позиции!");
      } else if (ifGuessIsRight ||
            ifGuessIsRight1 ||
            ifGuessIsRight2) {
               System.out.println("Угадал 1 позицию");}
         else {
            System.out.println("Ничего не угадал! А жаль...");
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
}
