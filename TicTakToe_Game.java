import java.util.Scanner;

public class TicTakToe_Game {
    static char[][] map;
    static final int SIZE_MAP = 3;
    static final char EMPTY_FIELD = '-';
    static final char X_FIELD = 'x';
    static final char O_FIELD = 'o';
    static Scanner s = new Scanner(System.in);

    public static void printMap() {
        for (int i = 0; i <= SIZE_MAP; i++) {
            System.out.print(i + " ");
        }
        System.out.print("X");
        System.out.println();
        for (int i = 0; i < SIZE_MAP; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE_MAP; j++) {
                System.out.print(map[i][j] + " ");
                ;
            }
            System.out.println();
        }
        System.out.println("Y");
    }

    public static void init() {
        map = new char[SIZE_MAP][SIZE_MAP];
        for (int i = 0; i < SIZE_MAP; i++) {
            for (int j = 0; j < SIZE_MAP; j++) {
                map[i][j] = EMPTY_FIELD;
            }
        }
        s = new Scanner(System.in);
    }

    public static void humanTurn() {
        System.out.println("Введите координаты своего хода X Y");
        int x, y;
        boolean correctKoordinate = true;
        do {
            x = s.nextInt() - 1;
            y = s.nextInt() - 1;
            if (x < 0 || x > 2 || y < 0 || y > 2) {
                System.out.println("Таких координатов не существует");
            } else if (map[y][x] != EMPTY_FIELD) {
                System.out.println("Это поле было помечено, выберите другое");
            } else {
                correctKoordinate = false;
            }
        } while (correctKoordinate);
        map[y][x] = X_FIELD;
        x += 1;
        y += 1;
        System.out.println("Вы ввели " + x + " " + y);
    }

    public static void anotherHumanTurn() {
        System.out.println("Введите координаты своего хода X Y");
        int x, y;
        boolean correctKoordinate = true;
        do {
            x = s.nextInt() - 1;
            y = s.nextInt() - 1;
            if (x < 0 || x > 2 || y < 0 || y > 2) {
                System.out.println("Таких координатов не существует");
            } else if (map[y][x] != EMPTY_FIELD) {
                System.out.println("Это поле было помечено, выберите другое");
            } else {
                correctKoordinate = false;
            }
        } while (correctKoordinate);
        map[y][x] = O_FIELD;
        x += 1;
        y += 1;
        System.out.println("Вы ввели " + x + " " + y);
    }

    public static void computerTurn() {
        int x, y;
        boolean correctKoordinate = true;
        do {
            x = 1 + (int) (Math.random() * 2);
            y = 1 + (int) (Math.random() * 2);
            if (x < 0 || x > 2 || y < 0 || y > 2) {
            } else if (map[y][x] != EMPTY_FIELD) {
            } else {
                correctKoordinate = false;
            }
        } while (correctKoordinate);
        map[y][x] = O_FIELD;
    }

    public static boolean checkWin(char playerField) {
        /*
         * 0 1 2
         * 0 - - -
         * 1 - - -
         * 2 - - -
         */
        if (map[0][0] == playerField && map[1][1] == playerField && map[2][2] == playerField) {
            return true;
        } else if (map[2][0] == playerField && map[1][1] == playerField && map[0][2] == playerField) {
            return true;
        } else if (map[0][0] == playerField && map[0][1] == playerField && map[0][2] == playerField) {
            return true;
        } else if (map[0][0] == playerField && map[1][0] == playerField && map[2][0] == playerField) {
            return true;
        } else if (map[1][0] == playerField && map[1][1] == playerField && map[1][2] == playerField) {
            return true;
        } else if (map[2][0] == playerField && map[2][1] == playerField && map[2][2] == playerField) {
            return true;
        } else if (map[0][1] == playerField && map[1][1] == playerField && map[2][1] == playerField) {
            return true;
        } else if (map[0][2] == playerField && map[1][2] == playerField && map[2][2] == playerField) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkDraft() {
        for (int i = 0; i < SIZE_MAP; i++) {
            for (int j = 0; j < SIZE_MAP; j++) {
                if (map[i][j] == EMPTY_FIELD) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("С кем вы хотите сыграть?");
        System.out.println("Введите 1 чтобы сыграть против компьютера");
        System.out.println("Введите 2 чтобы сыграть вмсте с другим человеком");
        int choose = s.nextInt();
        switch (choose) {
            case 1:
                init();
                while (true) {
                    printMap();
                    humanTurn();
                    if (checkDraft()) {
                        System.out.println("Ничья");
                        printMap();
                        break;
                    }
                    if (checkWin(X_FIELD)) {
                        System.out.println("Крестики победили");
                        printMap();
                        break;
                    }
                    printMap();
                    System.out.println("Ход компьютера");
                    computerTurn();
                    if (checkDraft()) {
                        System.out.println("Ничья");
                        printMap();
                        break;
                    }
                    if (checkWin(O_FIELD)) {
                        System.out.println("Нолики победили");
                        printMap();
                        break;
                    }
                }
                break;
            case 2:
                init();
                while (true) {
                    printMap();
                    humanTurn();
                    printMap();
                    if (checkDraft()) {
                        System.out.println("Ничья");
                        printMap();
                        break;
                    }
                    if (checkWin(X_FIELD)) {
                        System.out.println("Крестики победили");
                        printMap();
                        break;
                    }
                    anotherHumanTurn();
                    if (checkDraft()) {
                        System.out.println("Ничья");
                        printMap();
                        break;
                    }
                    if (checkWin(O_FIELD)) {
                        System.out.println("Нолики победили");
                        printMap();
                        break;
                    }
                }
                break;

            default:
                System.out.println("Такого выбора не существует");
                break;
        }
    }
}