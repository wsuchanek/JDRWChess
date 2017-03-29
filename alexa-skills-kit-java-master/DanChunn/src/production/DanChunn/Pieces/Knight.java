package production.DanChunn.Pieces;


import production.DanChunn.Game.Board;
import production.DanChunn.Pieces.Piece;
import production.DanChunn.Pieces.Piece.Class;
import production.DanChunn.util.Color;

public class Knight extends Piece {
    public Knight(Color pColor, Board board) {
        super(pColor, Piece.Class.Knight, board);
    }

    public int legalMove(int currX, int currY, int newX, int newY) {
        int dx = newX - currX;
        int dy = newY - currY;
        if(this.pColor == Color.Black) {
            dx = -1 * dx;
        }

        if(Math.abs(dx) == 1 && Math.abs(dy) == 2 || Math.abs(dx) == 2 && Math.abs(dy) == 1) {
            if(this.board.isSpotEmpty(newX, newY)) {
                return 1;
            }

            if(!this.board.isSpotEmpty(newX, newY) && this.board.getSquare(newX, newY).getPiece().pColor != this.pColor) {
                ++this.moveCount;
                return 2;
            }
        }

        return 0;
    }
}
