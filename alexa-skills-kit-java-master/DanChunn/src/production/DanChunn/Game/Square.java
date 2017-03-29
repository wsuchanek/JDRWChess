package production.DanChunn.Game;
import production.DanChunn.Game.Position;
import production.DanChunn.Pieces.Piece;
import production.DanChunn.util.Color;

public class Square {
    Position fileRank;
    Piece currPiece;
    Color sqrColor;

    public Square(int rank, char file) {
        this.createPosition(rank, file);
        this.setColor();
        this.currPiece = null;
    }

    private void createPosition(int rank, char file) {
        byte ifile = 0;
        switch(file) {
            case 'a':
                ifile = 0;
                break;
            case 'b':
                ifile = 1;
                break;
            case 'c':
                ifile = 2;
                break;
            case 'd':
                ifile = 3;
                break;
            case 'e':
                ifile = 4;
                break;
            case 'f':
                ifile = 5;
                break;
            case 'g':
                ifile = 6;
                break;
            case 'h':
                ifile = 7;
        }

        this.fileRank = new Position(rank, ifile);
    }

    private void setColor() {
        int rank = this.fileRank.getRank();
        int file = this.fileRank.getFile();
        if((rank + file) % 2 == 0) {
            this.sqrColor = Color.White;
        } else {
            this.sqrColor = Color.Black;
        }

    }

    public void setPiece(Piece newPiece) {
        this.currPiece = newPiece;
        newPiece.setPosition(this);
    }

    public Piece getPiece() {
        return this.currPiece;
    }

    public Piece removePiece() {
        Piece temp = this.currPiece;
        this.currPiece = null;
        temp.setPosition((Square)null);
        return temp;
    }

    public int getRank() {
        return this.fileRank.getRank();
    }

    public int getFile() {
        return this.fileRank.getFile();
    }
}
