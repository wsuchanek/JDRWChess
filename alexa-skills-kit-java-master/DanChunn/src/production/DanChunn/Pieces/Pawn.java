package production.DanChunn.Pieces;

import production.DanChunn.Game.Board;
import production.DanChunn.Pieces.Piece;
import production.DanChunn.Pieces.Piece.Class;
import production.DanChunn.util.Color;

public class Pawn extends Piece {
    boolean enPassent = false;

    public Pawn(Color pColor, Board board) {
        super(pColor, Class.Pawn, board);
    }

    public int legalMove(int currX, int currY, int newX, int newY) {
        int dx = newX - currX;
        int dy = newY - currY;
        boolean isBlack = false;
        if(this.pColor == Color.Black) {
            dx = -1 * dx;
            isBlack = true;
        }

        if(dy == 0 && dx == 2 && this.moveCount == 0) {
            if(this.board.isSpotEmpty(newX, newY)) {
                if(!isBlack) {
                    if(this.board.isSpotEmpty(newX - 1, newY)) {
                        this.setEnPassent();
                        ++this.moveCount;
                        return 1;
                    }
                } else if(this.board.isSpotEmpty(newX + 1, newY)) {
                    this.setEnPassent();
                    ++this.moveCount;
                    return 1;
                }
            }
        } else if(dy == 0 && dx == 1) {
            if(this.board.isSpotEmpty(newX, newY)) {
                ++this.moveCount;
                return 1;
            }
        } else if((dy == 1 || dy == -1) && dx == 1) {
            if(!this.board.isSpotEmpty(newX, newY)) {
                if(this.board.getSquare(newX, newY).getPiece().getColor() != this.pColor) {
                    ++this.moveCount;
                    return 2;
                }
            } else {
                Piece p;
                if(this.pColor == Color.Black) {
                    if(!this.board.isSpotEmpty(newX + 1, newY)) {
                        p = this.board.getSquare(newX + 1, newY).getPiece();
                        if(p instanceof Pawn) {
                            if(((Pawn)p).isEnPassent()) {
                                return 21;
                            }

                            return 0;
                        }
                    }
                } else if(!this.board.isSpotEmpty(newX - 1, newY)) {
                    p = this.board.getSquare(newX - 1, newY).getPiece();
                    if(p instanceof Pawn) {
                        if(((Pawn)p).isEnPassent()) {
                            return 22;
                        }

                        return 0;
                    }
                }
            }
        }

        return 0;
    }

    public void incMoveCount() {
        ++this.moveCount;
    }

    public void setEnPassent() {
        this.enPassent = true;
    }

    public void remEnPassent() {
        this.enPassent = false;
    }

    public boolean isEnPassent() {
        return this.enPassent;
    }
}
