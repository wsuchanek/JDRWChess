package production.DanChunn.Chess;
import java.io.InputStream;
import java.util.Scanner;
import production.DanChunn.Chess.Chess;
/**
 * Created by Ryan on 4/3/2017.
 */
public class Menu {

    public void menus(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Chess");
        System.out.println("----------------");
        System.out.println("Start Game    [1]");
        System.out.println("Continue Game [2]");
        System.out.println("Quit Game     [3]");
        System.out.println("----------------");

        int input = scanner.nextInt();

        if (input == 1){
            Chess game = new Chess();
            game.start();
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