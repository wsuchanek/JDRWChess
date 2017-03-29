package production.DanChunn.Pieces;

import production.DanChunn.Game.Board;
import production.DanChunn.Pieces.Piece;
import production.DanChunn.Pieces.Rook;
import production.DanChunn.Pieces.Piece.Class;
import production.DanChunn.util.Color;

public class King extends Piece {
    public King(Color pColor, Board board) {
        super(pColor, Class.King, board);
    }

    public int legalMove(int currX, int currY, int newX, int newY) {
        boolean legal = true;
        boolean check = false;
        int dx = newX - currX;
        int dy = newY - currY;
        if(Math.abs(dx) <= 1 && Math.abs(dy) <= 1) {
            if(this.board.isSpotEmpty(newX, newY)) {
                ++this.moveCount;
                return 1;
            }

            if(this.board.getSquare(newX, newY).getPiece().pColor != this.pColor) {
                ++this.moveCount;
                return 2;
            }
        } else if(Math.abs(dx) == 0 && Math.abs(dy) == 2 && this.moveCount == 0) {
            Piece p;
            if(dy > 0) {
                if(this.board.isSpotEmpty(newX, newY - 1) && this.board.isSpotEmpty(newX, newY)) {
                    p = this.board.getSquare(newX, newY + 1).getPiece();
                    if(p == null) {
                        return 0;
                    }

                    if(p instanceof Rook && p.getColor() == this.pColor && p.getMoveCount() == 0) {
                        return 11;
                    }
                }
            } else if(this.board.isSpotEmpty(newX, newY + 1) && this.board.isSpotEmpty(newX, newY) && this.board.isSpotEmpty(newX, newY - 1)) {
                p = this.board.getSquare(newX, newY - 2).getPiece();
                if(p == null) {
                    return 0;
                }

                if(p instanceof Rook && p.getColor() == this.pColor && p.getMoveCount() == 0) {
                    return 12;
                }
            }
        }

        return 0;
    }
}
