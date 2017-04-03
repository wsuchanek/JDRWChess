package production.DanChunn.Game;

import production.DanChunn.Chess.Chess;
import production.DanChunn.Pieces.Piece;

import java.util.ArrayList;
/**
 * Created by jotsandhu on 4/2/17.
 */
public  class AI {
    public AI(){
    };
    public static int makeRandMove(ArrayList<int[]> inList, Board myBoard, Player myPlayer, Chess myChess) {
        /*
        InList: is a list of all the locations of all the pieces for the computer player
        returns sucess integer from attempt move function
         */
        int[] start = new int[2];
        int[] end = new int[2];
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
                        //System.out.println("SUCESSSSSSSS");
                        //System.out.println("AEndY: " + end[0] + " AEndX: " + end[1]);

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
