package production.DanChunn.Chess;

import org.junit.Test;
import org.junit.Assert;
import production.DanChunn.Game.Board;
import production.DanChunn.Game.Player;
import production.DanChunn.Pieces.King;
import production.DanChunn.Pieces.Piece;
import production.DanChunn.util.Color;

/**
 * Created by jotsandhu on 3/28/17.
 *
 * Edited by wsuchanek on 3/29/17.
 *
 * Edited by rdebolt on 2/29/17
 */
public class MyTestClass {

    @Test
    public void testSomething(){
        Chess myChess = new Chess();

        String move1 = "e1";
        int[] spot1 = new int[2]; //for the position e1
        spot1[0] = 0;
        spot1[1] = 4;

        String move2 = "g3";
        int[] spot2 = new int[2]; // for the position g3
        spot2[0] = 2;
        spot2[1] = 6;
        Assert.assertEquals(spot1, myChess.translatePos(move1));
        Assert.assertEquals(spot2, myChess.translatePos(move2));
    }

    @Test
    public void willTestTest(){
        Chess willChess = new Chess();
        Assert.assertEquals(2, willChess.players.length);
    }

    @Test
    public void RTest (){
        Chess Rchess = new Chess();
        Assert.assertEquals(false, Rchess.board.isSpotEmpty(2,2));
    }
}
