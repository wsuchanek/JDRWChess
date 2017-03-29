package production.DanChunn.Pieces;

import production.DanChunn.Game.Board;
import production.DanChunn.Game.Square;
import production.DanChunn.util.Color;

public abstract class Piece {
    public Color pColor;
    public Piece.Class pClass;
    int moveCount;
    public Square currPos;
    public Board board;

    protected Piece(Color pColor, Piece.Class pClass, Board board) {
        this.pColor = pColor;
        this.pClass = pClass;
        this.board = board;
    }

    public abstract int legalMove(int var1, int var2, int var3, int var4);

    public Color getColor() {
        return this.pColor;
    }

    public Piece.Class getPieceClass() {
        return this.pClass;
    }

    public void setPosition(Square sq) {
        this.currPos = sq;
    }

    public Square getPosition() {
        return this.currPos;
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    public static enum Class {
        Pawn,
        Rook,
        Knight,
        Bishop,
        King,
        Queen;

        private Class() {
        }
    }
}
