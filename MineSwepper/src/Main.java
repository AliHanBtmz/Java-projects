import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {


        MineSwepper mineSwepper = new MineSwepper(4,4);  //Here we determine the minefield size when creating the object
        mineSwepper.run();
    }
}