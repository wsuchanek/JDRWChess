package production.DanChunn.Pieces;

import production.DanChunn.Game.Board;
import production.DanChunn.Pieces.Piece;
import production.DanChunn.Pieces.Piece.Class;
import production.DanChunn.util.Color;

public class Rook extends Piece {
    public Rook(Color pColor, Board board) {
        super(pColor, Class.Rook, board);
    }

    public int legalMove(int currX, int currY, int newX, int newY) {
        int dx = newX - currX;
        int dy = newY - currY;
        int i;
        if(Math.abs(dy) > 0 && dx == 0) {
            if(dy > 0) {
                for(i = currY + 1; i < newY; ++i) {
                    if(!this.board.isSpotEmpty(currX, i)) {
                        return 0;
                    }
                }
            }

            if(dy < 0) {
                for(i = currY - 1; i > newY; --i) {
                    if(!this.board.isSpotEmpty(currX, i)) {
                        return 0;
                    }
                }
            }

            if(this.board.isSpotEmpty(newX, newY)) {
                ++this.moveCount;
                return 1;
            }

            if(this.board.getSquare(newX, newY).getPiece().getColor() != this.pColor) {
                ++this.moveCount;
                return 2;
            }
        } else if(Math.abs(dx) > 0 && dy == 0) {
            if(dx > 0) {
                for(i = currX + 1; i < newX; ++i) {
                    if(!this.board.isSpotEmpty(i, currY)) {
                        return 0;
                    }
                }
            }

            if(dx < 0) {
                for(i = currX - 1; i > newX; --i) {
                    if(!this.board.isSpotEmpty(i, currY)) {
                        return 0;
                    }
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
