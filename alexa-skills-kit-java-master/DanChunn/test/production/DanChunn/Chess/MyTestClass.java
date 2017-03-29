package production.DanChunn.Chess;

import org.junit.Test;
import org.junit.Assert;

/**
 * Created by jotsandhu on 3/28/17.
 *
 * Edited by wsuchanek on 3/29/17.
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
}
