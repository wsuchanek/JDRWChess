package production.DanChunn.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.io.File;

/**
 * Created by willsuchanek on 4/3/17.
 */
public class LastMoveQueueTest {
    //This test makes sure the queue never has anything more than 5 items in it
    @Test
    public void onlySize5Test(){
        LastMoveQueue moves = new LastMoveQueue();
        moves.enqueue("a1 a2");
        moves.enqueue("b1 b2");
        moves.enqueue("c1 c2");
        moves.enqueue("d1 d2");
        moves.enqueue("e1 e2");
        moves.enqueue("f1 f2");
        Assert.assertEquals(6,moves.size());
    }
    //Properly returns the 5 most recent moves
    @Test
    public void lastFiveTest(){
        LastMoveQueue moves = new LastMoveQueue();
        String move1 = "a1 a2";
        String move2 = "b1 b2";
        String move3 = "c1 c2";
        String move4 = "d1 d2";
        String move5 = "e1 e2";
        String move6 = "f1 f2";
        Assert.assertEquals(null,moves.printLastFiveMoves());

        moves.enqueue(move1);

        //Tests it works with only 1 item in list
        List<String> testList1 = new ArrayList<String>();
        testList1.add(move1);
        Assert.assertEquals(testList1,moves.printLastFiveMoves());

        moves.enqueue(move2);
        moves.enqueue(move3);
        moves.enqueue(move4);
        moves.enqueue(move5);
        moves.enqueue(move6);


        List<String> testList2 = new ArrayList<String>();
        testList2.add(move6);
        testList2.add(move5);
        testList2.add(move4);
        testList2.add(move3);
        testList2.add(move2);
        Assert.assertEquals(testList2,moves.printLastFiveMoves());
    }

    @Test
    public void saveGameTest(){
        LastMoveQueue moves = new LastMoveQueue();
        String move1 = "a1 a2";
        String move2 = "b1 b2";
        String move3 = "c1 c2";
        String move4 = "d1 d2";
        String move5 = "e1 e2";
        String move6 = "f1 f2";
        moves.enqueue(move1);
        moves.enqueue(move2);
        moves.enqueue(move3);
        moves.enqueue(move4);
        moves.enqueue(move5);
        moves.enqueue(move6);

        String moveFile = moves.saveGameFile();

        String testString = "a1 a2\nb1 b2\nc1 c2\n" +
                "d1 d2\ne1 e2\n" +
                "f1 f2\n";
        Assert.assertEquals(testString,moveFile);




    }
}
