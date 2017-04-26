package production.DanChunn.Game;

import model.TextToSpeech;
import production.DanChunn.Chess.Chess;
import production.DanChunn.Chess.SpeechRecognition;
import production.DanChunn.Pieces.Piece;
import production.DanChunn.util.LastMoveQueue;

import java.util.ArrayList;
/**
 * Created by jotsandhu on 4/2/17.
 */

/**
 * @author jotsandhu
 */
public  class AI {
    public AI(){
    }

    /**
     *
     * @param inList    List of all pieces on the board and their locations
     * @param myBoard   The board class being used for this Chess class
     * @param myPlayer  The current player who's turn it is
     * @param myChess   The current Chess class that is running
     * @param Queue a Queue of the previous moves that have been made
     * @return      returns success value for the Chess class to check whether a piece has been captured or the king is in check
     * @post    A move has been made and the board has been updated with the new piece location.
     */
    public static int makeRandMove(ArrayList<int[]> inList, Board myBoard, Player myPlayer, Chess myChess, LastMoveQueue Queue) {
        /*
        InList: is a list of all the locations of all the pieces for the computer player
        returns sucess integer from attempt move function
         */
        TextToSpeech tts = new TextToSpeech();
        tts.setVoice("dfki-poppy-hsmm");

        int[] start = new int[2];
        int[] end = new int[2];
        String alphabet = "abcdefgh";

        int[] out = new int[4]; //this array holds the values to be written out to the loading text file
        int success1 = -1;
        while (success1 == -1) {
            int randSpot = (int) (Math.random() * inList.size());
            start = inList.get(randSpot);
            while (myBoard.outOfRange(start[0], start[1])) {
                randSpot = (int) (Math.random() * inList.size());
                start = inList.get(randSpot);
            }


            //start[0] = 7;
            //start[1] = 1;
            //System.out.println("start X: " + start[0] + " start Y: " + start[1]);
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; ++j) {
                    end[0] = i;
                    end[1] = j;
                    //if( i ==6)
                    //System.out.println("number 6");
                    try {
                        success1 = myChess.attemptMove(start, end, myPlayer);
                        out[0] = start[0];
                        out[1] = start[1];
                        out[2] = end[0];
                        out[3] = end[1];

                        Queue.addMoves(out);
                        String output = alphabet.substring(out[1],out[1]+1) + Integer.toString(out[0]+1) + " " + alphabet.substring(out[3],out[3]+1) + Integer.toString(out[2]+1);

                        //System.out.println("SUCESSSSSSSS");
                        //System.out.println("AEndY: " + end[0] + " AEndX: " + end[1]);
                        System.out.println(output);
                        tts.speak("Blacks move: " + output , 2.0f, false, true);


                        return success1;
                    } catch (IllegalArgumentException var13) {
                        //continue;
                    }
                    //System.out.println("went around loop");
                }


            }
            success1 = -1;

        }
        return -1;
    }
}
