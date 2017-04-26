package production.DanChunn.Chess;
import model.TextToSpeech;

import java.util.Scanner;
/**
 * Created by Ryan on 4/3/2017.
 */
public class Menu {

    public static void main(String[] args) {
        TextToSpeech tts = new TextToSpeech();
        tts.setVoice("dfki-poppy-hsmm");

        // TTS say something that we actually are typing into the first variable

        boolean inputCheck = true;
        SpeechRecognition myRec = new SpeechRecognition();
        while (inputCheck) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to Chess");
            tts.speak("Welcome to Chess", 2.0f, false, true);
            System.out.println("-----------------");
            System.out.println("Start Game  [1]");
            tts.speak("Start Game say 1!", 2.0f, false, true);
            System.out.println("Continue Game   [2]");
            tts.speak("Continue Game say 2", 2.0f, false, true);
            System.out.println("Quit Game   [3]");
            tts.speak("Quit Game say 3", 2.0f, false, true);
            System.out.println("-----------------");

            //int input = scanner.nextInt();
            int input = 0;
            try {
                input = Integer.parseInt(myRec.getResponse());
            } catch (Exception e){
                input = 4;
            }
            if (input < 3) {
                inputCheck = false;
            }
            processInput(input);
        }
    }

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