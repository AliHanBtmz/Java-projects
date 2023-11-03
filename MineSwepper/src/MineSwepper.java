import java.util.Random;
import java.util.Scanner;

public class MineSwepper {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    int rowNumber;
    int colNumber;
    String[][] mineMap;
    String[][] gameMap;
    int numeberOfmines;
    int a;
    int b;
    int count;
    boolean isTrue = true;

    public MineSwepper(int row, int column) {
        this.rowNumber = row;
        this.colNumber = column;
        this.gameMap = new String[row][column];
        this.mineMap = new String[row][column];
        this.numeberOfmines = row * column / 4;


    }

    public void mineMap() {
        for (int i = 0; i < mineMap.length; i++) {
            for (int j = 0; j < mineMap[i].length; j++) {
                mineMap[i][j] = "-";
                gameMap[i][j] = "-";
            }

        }
    }

    //In this method, we specify the positions where the mines will appear randomly.
    public void randomNumber() {
        for (int i = 0; i < numeberOfmines; i++) {

            int row = random.nextInt(this.rowNumber);
            int column = random.nextInt(this.colNumber);

            if (!this.mineMap[row][column].equals("*")) {
                this.mineMap[row][column] = "*";
            } else {
                i--;
            }
        }
    }

    //In this method it prints the minefield
    public void printMineMap() {
        System.out.println("Location of Mines");
        randomNumber();
        for (int i = 0; i < this.rowNumber; i++) {
            for (int j = 0; j < this.colNumber; j++) {
                if (!this.mineMap[i][j].equals("*")) {
                    this.mineMap[i][j] = "-";
                }
                System.out.print(this.mineMap[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("==================================");
        System.out.println("Welcome to Minesweeper Game !");

    }

    //In this method, we print the game map where the mines are hidden.
    public void printGameMap() {
        for (int i = 0; i < this.rowNumber; i++) {
            for (int j = 0; j < this.colNumber; j++) {
                this.gameMap[i][j] = "-";
                System.out.print(this.gameMap[i][j] + " ");
            }
            System.out.println();

        }
    }
    // In this method, we choose the point we want from the minefield.
    public void indexSelect() {
        isTrue = false;
        while (!isTrue) {

            System.out.print("Enter Row : ");
            a = scanner.nextInt();
            System.out.print("Enter Column : ");
            b = scanner.nextInt();
            if (a >= rowNumber || b >= colNumber) {
                System.out.println("You made a selection outside the map boundaries, enter again. !");
                continue;
            }
            if (mineMap[a][b].equals("*")) {
                System.out.println("Game Over!");
                break;

            }
            control();

            if (finish()) {
                System.out.println("Congratulations you won :)))))");
                break;
            }
        }

    }
    // This method checks whether there are mines in the place we selected.
    public void control() {
        count = 0;
        for (int i = (a - 1); i <= (a + 1); i++) {
            for (int j = (b - 1); j <= (b + 1); j++) {
                if (i < 0 || j < 0 || i >= this.rowNumber || j >= this.colNumber) {
                    continue;
                }

                if (this.mineMap[i][j].equals("*")) {
                    count++;
                }

            }
        }
        this.gameMap[a][b] = String.valueOf(count);
        this.mineMap[a][b] = String.valueOf(count);

        for (int i = 0; i < this.rowNumber; i++) {
            for (int j = 0; j < this.colNumber; j++) {
                System.out.print(this.gameMap[i][j] + " ");
            }
            System.out.println();
        }

    }
    //This method finishes the game if we get all the points correctly without selecting any mines.
    public boolean finish() {
        for (int i = 0; i < this.rowNumber; i++) {
            for (int j = 0; j < this.colNumber; j++) {

                if (this.mineMap[i][j].equals("-")) {
                    return false;
                }
            }
        }
        return true;
    }

    public void run() {

        mineMap();
        printMineMap();
        printGameMap();
        indexSelect();
    }
}

