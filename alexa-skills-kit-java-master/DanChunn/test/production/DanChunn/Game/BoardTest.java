package production.DanChunn.Game;

import org.junit.Test;
import production.DanChunn.util.Color;

import java.util.ArrayList;

/**
 * Created by willsuchanek on 4/3/17.
 */
public class BoardTest {
    @Test
    public void createBoardTest(){
        Player p1 = new Player(Color.Black);
        Player p2 = new Player(Color.White);
        Player[] players = new Player[2];
        players[0] = p1;
        players[1] = p2;

        Board myBoard = new Board(players);
        myBoard.createBoard();
        myBoard.printBoard();
    }
}
