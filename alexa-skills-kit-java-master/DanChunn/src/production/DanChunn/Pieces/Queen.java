package production.DanChunn.Pieces;

import production.DanChunn.Game.Board;
import production.DanChunn.Pieces.Piece;
import production.DanChunn.Pieces.Piece.Class;
import production.DanChunn.util.Color;

public class Queen extends Piece {
    public Queen(Color pColor, Board board) {
        super(pColor, Class.Queen, board);
    }

    public int legalMove(int currX, int currY, int newX, int newY) {
        int dx = newX - currX;
        int dy = newY - currY;
        int i;
        if(Math.abs(dy) - Math.abs(dx) == 0) {
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
