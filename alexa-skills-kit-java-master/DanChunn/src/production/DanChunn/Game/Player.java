package production.DanChunn.Game;

import production.DanChunn.Pieces.Piece;
import java.util.ArrayList;
import java.util.List;
import production.DanChunn.util.Color;

public class Player {
    Color player;
    int PawnsL;
    int RooksL;
    int BishopsL;
    int KnightsL;
    int QueenL;
    int KingL;
    List<String> prevMoves;
    Piece KingPos;
    boolean inCheck;
    boolean enPassent;

    public Player(Color color) {
        this.player = color;
        this.PawnsL = 8;
        this.RooksL = this.BishopsL = this.KnightsL = 2;
        this.QueenL = this.KingL = 1;
        this.inCheck = false;
        this.enPassent = false;
        this.prevMoves = new ArrayList();
    }

    public Color getColor() {
        return this.player;
    }

    public void addMove(String move) {
        this.prevMoves.add(move);
    }

    public void setKingRef(Piece king) {
        this.KingPos = king;
    }

    public Piece getKingRef() {
        return this.KingPos;
    }

    public String getLastMove() {
        return (String)this.prevMoves.get(this.prevMoves.size() - 1);
    }

    public void remLastMove() {
        this.prevMoves.remove(this.prevMoves.size() - 1);
    }

    public void inCheck() {
        this.inCheck = true;
    }

    public void notCheck() {
        this.inCheck = false;
    }

    public boolean isInCheck() {
        return this.inCheck;
    }
}
