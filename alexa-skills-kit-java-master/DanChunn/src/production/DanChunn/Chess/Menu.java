package production.DanChunn.Chess;
import java.util.Scanner;
/**
 * Created by Ryan on 4/3/2017.
 */

/**
 * @author Ryan
 * The Menu Class is a simple UI for the user to interact with, the interface
 * gives the user an option to start a new game, continue a game and close the
 * application.
 */
public class Menu {

    public static void main(String[] args) {
        boolean inputCheck = true;
        while (inputCheck) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to Chess");
            System.out.println("-----------------");
            System.out.println("Start Game    [1]");
            System.out.println("Continue Game [2]");
            System.out.println("Quit Game     [3]");
            System.out.println("-----------------");

            int input = scanner.nextInt();
            if (input < 3) {
                inputCheck = false;
            }
            processInput(input);
        }
    }

    /**
     * The processInput function will take an input from the user and with
     * If statements determine what action the user wants to take.
     * @param input
     */
    public static void processInput(int input) {
        if (input == 1) {
            Chess game = new Chess();
            game.start(0);
        }
        if (input == 2) {
            Chess game = new Chess();
            game.start(1);
            return;
            /* run continued game */
        }
        if (input == 3) {
            return;
        }
    }
}