package production.DanChunn.Game;

import production.DanChunn.Game.Player;
import production.DanChunn.Game.Square;
import production.DanChunn.Pieces.Bishop;
import production.DanChunn.Pieces.King;
import production.DanChunn.Pieces.Knight;
import production.DanChunn.Pieces.Pawn;
import production.DanChunn.Pieces.Piece;
import production.DanChunn.Pieces.Queen;
import production.DanChunn.Pieces.Rook;
import production.DanChunn.util.Color;

public class Board {
    Square[][] board;
    char[] files = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
    public Player[] players;

    public Board(Player[] players) {
        this.players = players;
        this.createBoard();
    }

    public void createBoard() {
        this.board = new Square[8][8];

        for(int i = 0; i < 8; ++i) {
            for(int j = 0; j < 8; ++j) {
                this.board[i][j] = new Square(i, this.files[j]);
            }
        }

    }

    public void addPieces(Player player) {
        Color playerC = player.getColor();
        Pawn tempP;
        int i;
        Rook var5;
        Knight var6;
        Bishop var7;
        Queen var8;
        King var9;
        if(playerC == Color.Black) {
            for(i = 0; i < 8; ++i) {
                tempP = new Pawn(Color.Black, this);
                this.board[6][i].setPiece(tempP);
            }

            var5 = new Rook(Color.Black, this);
            this.board[7][0].setPiece(var5);
            var5 = new Rook(Color.Black, this);
            this.board[7][7].setPiece(var5);
            var6 = new Knight(Color.Black, this);
            this.board[7][1].setPiece(var6);
            var6 = new Knight(Color.Black, this);
            this.board[7][6].setPiece(var6);
            var7 = new Bishop(Color.Black, this);
            this.board[7][2].setPiece(var7);
            var7 = new Bishop(Color.Black, this);
            this.board[7][5].setPiece(var7);
            var8 = new Queen(Color.Black, this);
            this.board[7][3].setPiece(var8);
            var9 = new King(Color.Black, this);
            player.setKingRef(var9);
            this.board[7][4].setPiece(var9);
        } else {
            for(i = 0; i < 8; ++i) {
                tempP = new Pawn(Color.White, this);
                this.board[1][i].setPiece(tempP);
            }

            var5 = new Rook(Color.White, this);
            this.board[0][0].setPiece(var5);
            var5 = new Rook(Color.White, this);
            this.board[0][7].setPiece(var5);
            var6 = new Knight(Color.White, this);
            this.board[0][1].setPiece(var6);
            var6 = new Knight(Color.White, this);
            this.board[0][6].setPiece(var6);
            var7 = new Bishop(Color.White, this);
            this.board[0][2].setPiece(var7);
            var7 = new Bishop(Color.White, this);
            this.board[0][5].setPiece(var7);
            var8 = new Queen(Color.White, this);
            this.board[0][3].setPiece(var8);
            var9 = new King(Color.White, this);
            player.setKingRef(var9);
            this.board[0][4].setPiece(var9);
        }

    }

    public void printBoard() {
        int i;
        for(i = 7; i > -1; --i) {
            for(int j = 0; j < 8; ++j) {
                Piece tempP = this.board[i][j].getPiece();
                if(tempP == null) {
                    if(this.board[i][j].sqrColor == Color.White) {
                        System.out.print("   ");
                    } else {
                        System.out.print(" ##");
                    }
                }

                if(tempP instanceof Pawn) {
                    if(tempP.getColor() == Color.Black) {
                        System.out.print(" bp");
                    } else {
                        System.out.print(" wp");
                    }
                } else if(tempP instanceof Rook) {
                    if(tempP.getColor() == Color.Black) {
                        System.out.print(" bR");
                    } else {
                        System.out.print(" wR");
                    }
                } else if(tempP instanceof Knight) {
                    if(tempP.getColor() == Color.Black) {
                        System.out.print(" bN");
                    } else {
                        System.out.print(" wN");
                    }
                } else if(tempP instanceof Bishop) {
                    if(tempP.getColor() == Color.Black) {
                        System.out.print(" bB");
                    } else {
                        System.out.print(" wB");
                    }
                } else if(tempP instanceof Queen) {
                    if(tempP.getColor() == Color.Black) {
                        System.out.print(" bQ");
                    } else {
                        System.out.print(" wQ");
                    }
                } else if(tempP instanceof King) {
                    if(tempP.getColor() == Color.Black) {
                        System.out.print(" bK");
                    } else {
                        System.out.print(" wK");
                    }
                }
            }

            System.out.println(" " + (i + 1));
        }

        for(i = 0; i < 8; ++i) {
            System.out.print("  " + this.files[i]);
        }

        System.out.println();
    }

    public boolean isSpotEmpty(int x, int y) {
        return x >= 0 && x <= 7?(y >= 0 && y <= 7?this.board[x][y].getPiece() == null:true):true;
    }

    public boolean outOfRange(int x, int y) {
        return x >= 0 && x <= 7?y < 0 || y > 7:true;
    }

    public Square getSquare(int x, int y) {
        return this.board[x][y];
    }
}
