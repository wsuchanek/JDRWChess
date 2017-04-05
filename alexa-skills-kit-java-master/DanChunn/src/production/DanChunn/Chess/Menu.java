package production.DanChunn.Chess;
import java.util.Scanner;
/**
 * Created by Ryan on 4/3/2017.
 */
public class Menu {

    public static void main(String[] args) {
        boolean inputCheck = true;
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to Chess");
            System.out.println("-----------------");
            System.out.println("Start Game    [1]");
            System.out.println("Continue Game [2]");
            System.out.println("Quit Game     [3]");
            System.out.println("-----------------");

            int input = scanner.nextInt();

            if (input == 1){
                Chess game = new Chess();
                game.start();
                inputCheck = false;
            }
            if (input == 2){
                return;
            /* run continued game */
            }
            if (input == 3){
                return;
            }
        }
    }
}