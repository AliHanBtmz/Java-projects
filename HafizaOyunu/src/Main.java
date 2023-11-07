
import java.io.File;
import java.util.Scanner;


public class Main {
    private static Card[][] cards = new Card[4][4];

    //In this method, if there is a saved game, we restore it, otherwise it starts from the beginning.
    public static void uploadRecording() {
        Scanner scanner = new Scanner(System.in);
        File file = new File("kayıt.bin");

        if (file.exists()) {


            System.out.println("There is registration, do you want to continue ? (yes or no)");
            String cvp = scanner.nextLine();
            if (cvp.equals("yes")) {

                cards = gameRecord.uploadRecording();
                return;

            }
        }
        // Elements on the game board
        cards[0][0] = new Card('E');
        cards[0][1] = new Card('A');
        cards[0][2] = new Card('B');
        cards[0][3] = new Card('F');
        cards[1][0] = new Card('G');
        cards[1][1] = new Card('A');
        cards[1][2] = new Card('D');
        cards[1][3] = new Card('H');
        cards[2][0] = new Card('F');
        cards[2][1] = new Card('C');
        cards[2][2] = new Card('D');
        cards[2][3] = new Card('H');
        cards[3][0] = new Card('E');
        cards[3][1] = new Card('G');
        cards[3][2] = new Card('B');
        cards[3][3] = new Card('C');


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        uploadRecording();
        while (isGameOver() == false) {


            gameBoard();
            System.out.println("Do you want to exit ? (yes or no)---->  ");
            String exit = scanner.nextLine();
            if (exit.equals("yes")) {


                System.out.println("Do you want to save the game ? (yes or no)--->  ");
                String save = scanner.nextLine();

                if (save.equals("yes")) {

                    gameRecord.gameRecord(cards);


                } else {
                    System.out.println("Game not saved");
                }
                System.out.println("Exiting the game ");
                break;


            }

            guess();

        }

    }
    //Compare the predictions we will make with this method
    public static void guess() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("First Prediction (Enter i and j values with a space...): ");
        int i1 = scanner.nextInt();
        int j1 = scanner.nextInt();

        cards[i1][j1].setPrediction(true);
        gameBoard();

        System.out.print("Second Prediction (Enter i and j values with a space...): ");
        int i2 = scanner.nextInt();
        int j2 = scanner.nextInt();

        if (cards[i1][j1].getValue() == cards[i2][j2].getValue()) {
            System.out.println("Right Prediction. Congratulations!");
            cards[i2][j2].setPrediction(true);

        } else {
            System.out.println("Wrong Prediction...");
            cards[i1][j1].setPrediction(false);

        }


    }

    //This method checks whether the game is over or not.
    public static boolean isGameOver() {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (cards[i][j].isPrediction() == false) {
                    return false;

                }

            }
        }
        return true;

    }

    //This method prints the game board
    public static void gameBoard() {

        for (int i = 0; i < 4; i++) {
            System.out.println("____________________");
            for (int j = 0; j < 4; j++) {

                if (cards[i][j].isPrediction()) {
                    System.out.print(" |" + cards[i][j].getValue() + "| ");

                } else {
                    System.out.print(" | | ");

                }
            }
            System.out.println("");
        }
        System.out.println("____________________");


    }

}
