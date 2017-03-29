package production.DanChunn.Pieces;

import production.DanChunn.Game.Board;
import production.DanChunn.Pieces.Piece;
import production.DanChunn.Pieces.Piece.Class;
import production.DanChunn.util.Color;

public class Bishop extends Piece {
    public Bishop(Color pColor, Board board) {
        super(pColor, Class.Bishop, board);
    }

    public int legalMove(int currX, int currY, int newX, int newY) {
        int dx = newX - currX;
        int dy = newY - currY;
        if(Math.abs(dy) - Math.abs(dx) == 0) {
            int i;
            int j;
            if(dx > 0 && dy > 0) {
                i = currX + 1;

                for(j = currY + 1; i < newX || j < newY; ++j) {
                    if(!this.board.isSpotEmpty(i, j)) {
                        return 0;
                    }

                    ++i;
                }
            }

            if(dx > 0 && dy < 0) {
                i = currX + 1;

                for(j = currY - 1; i < newX || j > newY; --j) {
                    if(!this.board.isSpotEmpty(i, j)) {
                        return 0;
                    }

                    ++i;
                }
            }

            if(dx < 0 && dy > 0) {
                i = currX - 1;

                for(j = currY + 1; i > newX || j < newY; ++j) {
                    if(!this.board.isSpotEmpty(i, j)) {
                        return 0;
                    }

                    --i;
                }
            }

            if(dx < 0 && dy < 0) {
                i = currX - 1;

                for(j = currY - 1; i > newX || j > newY; --j) {
                    if(!this.board.isSpotEmpty(i, j)) {
                        return 0;
                    }

                    --i;
                }
            }

            if(this.board.isSpotEmpty(newX, newY)) {
                ++this.moveCount;
                return 1;
            }

            if(this.board.getSquare(newX, newY).getPiece().pColor != this.pColor) {
                ++this.moveCount;
                return 2;
            }
        }

        return 0;
    }
}
