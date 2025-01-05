import java.util.Scanner;

public class It_Sphere {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // TimeOfLessons
        System.out.println("Enter the lesson number (1-10):");
        int hours = 9;
        int minutes = 0;
        int lesson = sc.nextInt();
        
        while (lesson > 10 || lesson < 1) {
            System.out.println("Try again.");
            lesson = sc.nextInt();
        }
        
        while (lesson > 0) {
            if (lesson % 2 == 0) {
                minutes += 50;
                lesson--;
            } else if (lesson == 1) {
                lesson--;
                minutes += 45;
            } else if (lesson % 2 == 1) {
                hours++;
                lesson--;
            }
        }
        hours += minutes / 60;
        minutes = minutes % 60;
        System.out.println(String.format("Time after lessons: %02d:%02d", hours, minutes));

        // King
        System.out.println("Enter positions for King (X Y) and Victim (X Y):");
        int KingX = sc.nextInt();
        int KingY = sc.nextInt();
        int VictimX = sc.nextInt();
        int VictimY = sc.nextInt();
        
        if ((Math.abs(KingX - VictimX) == 1 && Math.abs(KingY - VictimY) == 1) || 
            (Math.abs(KingX - VictimX) == 1 && Math.abs(KingY - VictimY) == 0) || 
            (Math.abs(KingX - VictimX) == 0 && Math.abs(KingY - VictimY) == 1)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        // Ottepelь
        System.out.println("Enter the number of days:");
        int n = sc.nextInt();
        int[] days = new int[n];
        int streak = 0;
        int remeberOfStreak = 0;
        
        System.out.println("Enter the days:");
        for (int i = 0; i < n; i++) {
            days[i] = sc.nextInt();
        }
        
        for (int i = 0; i < n; i++) {
            if (days[i] > 0) {
                streak++;
            } else {
                remeberOfStreak = streak;
                streak = 0;
            }
        }
        System.out.println("Longest streak: " + remeberOfStreak);

        // Uravnenye
        sc.nextLine(); // to consume the leftover newline character
        System.out.println("Enter the equation:");
        String equation = sc.nextLine();

        int positionOfX = 0;
        int positionOfminus = 0;
        int positionOfplus = 0;
        int firstNumber = 0;
        int lastNumber = 0;
        int answer = 0;
        char x = 'x';
        
        for (char c : equation.toCharArray()) {
            if (Character.isDigit(c)) {
                int value = Character.getNumericValue(c);
                firstNumber = value;
                break;
            }
        }
        
        for (char c : equation.toCharArray()) {
            if (Character.isDigit(c)) {
                int value = Character.getNumericValue(c);
                lastNumber = value;
            }
        }

        for (int i = 0; i < equation.length(); i++) {
            if (equation.charAt(i) == '-') {
                positionOfminus = i;
            }
            if (equation.charAt(i) == '+') {
                positionOfplus = i;
            }
            if (equation.charAt(i) == x) {
                positionOfX = i;
            }
        }

        if (positionOfplus != 0) {
            answer = lastNumber - firstNumber;
        }
        if (positionOfminus != 0) {
            if (positionOfX == 2) {
                answer = -(lastNumber - firstNumber);
            } else {
                answer = lastNumber + firstNumber;
            }
        }
        System.out.println("Answer: " + answer);

        // Sudoku
        System.out.println("Enter the size of the Sudoku grid:");
        int n2 = sc.nextInt() * sc.nextInt();
        int[][] matrix = new int[n2][n2];

        System.out.println("Enter the Sudoku grid:");
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < n2; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n2; i++) {
            if (!isUnique(matrix[i])) {
                System.out.println("Incorrect");
                return;
            }
        }

        for (int j = 0; j < n2; j++) {
            int[] column = new int[n2];
            for (int i = 0; i < n2; i++) {
                column[i] = matrix[i][j];
            }
            if (!isUnique(column)) {
                System.out.println("Incorrect");
                return;
            }
        }

        for (int blockRow = 0; blockRow < n2; blockRow += n2) {
            for (int blockCol = 0; blockCol < n2; blockCol += n2) {
                int[] block = new int[n2];
                int index = 0;
                for (int i = 0; i < n2; i++) {
                    for (int j = 0; j < n2; j++) {
                        block[index++] = matrix[blockRow + i][blockCol + j];
                    }
                }
                if (!isUnique(block)) {
                    System.out.println("Incorrect");
                    return;
                }
            }
        }

        System.out.println("Correct");

        // Points
        System.out.println("Enter the number of points:");
        int pointCount = sc.nextInt();
        int[][] points = new int[pointCount][2];

        System.out.println("Enter the points (X Y):");
        for (int i = 0; i < pointCount; i++) {
            points[i][0] = sc.nextInt(); // X
            points[i][1] = sc.nextInt(); // Y
        }

        double minDistance = Double.MAX_VALUE;
        double maxDistance = Double.MIN_VALUE;
        int minPoint = 0;
        int minPoint2 = 0;
        int maxPoint = 0;
        int maxPoint2 = 0;

        for (int i = 0; i < pointCount; i++) {
            for (int j = i + 1; j < pointCount; j++) {
                double distance = Distance(points[i], points[j]);

                if (distance < minDistance) {
                    minDistance = distance;
                    minPoint = i + 1;
                    minPoint2 = j + 1;
                }

                if (distance > maxDistance) {
                    maxDistance = distance;
                    maxPoint = i + 1;
                    maxPoint2 = j + 1;
                }
            }
        }

        System.out.println("Closest points: " + minPoint + " " + minPoint2);
        System.out.println("Farthest points: " + maxPoint + " " + maxPoint2);

        // Slava_ILI_Stan
        System.out.println("Enter the initial value for Slava and Ollie game:");
        long gameValue = sc.nextLong();
        boolean isSlava = true;
        
        while (gameValue > 1) {
            if (isSlava) {
                gameValue = (gameValue + 8) / 9;
            } else {
                gameValue = (gameValue + 1) / 2;
            }
            isSlava = !isSlava;
        }

        System.out.println(isSlava ? "Ollie wins." : "Slava wins.");
    }

    private static boolean isUnique(int[] array) {
        int n = array.length;
        boolean[] seen = new boolean[n + 1];
        for (int num : array) {
            if (num < 1 || num > n || seen[num]) {
                return false;
            }
            seen[num] = true;
        }
        return true;
    }

    // method for Euclidean distance
    public static double Distance(int[] point1, int[] point2) {
        long dx = (long) point1[0] - point2[0];
        long dy = (long) point1[1] - point2[1];
        return Math.sqrt(dx * dx + dy * dy);
    }
}
