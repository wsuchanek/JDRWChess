
package production.DanChunn.Chess;

import production.DanChunn.Game.Board;
import production.DanChunn.Game.Square;
import production.DanChunn.Pieces.Piece;
import production.DanChunn.Pieces.Piece.Class;
import java.util.List;
import production.DanChunn.util.Color;

public class Check {
    public Check() {
    }

    public static boolean scanCheck(int x, int y, Color color, Board board) {
        if(board.outOfRange(x, y)) {
            return true;
        } else {
            Piece p;
            int i;
            int j;
            if(board.isSpotEmpty(x + 1, y + 1)) {
                i = x + 1;

                for(j = y + 1; i < 8 && j < 8; ++j) {
                    if(!board.isSpotEmpty(i, j)) {
                        p = board.getSquare(i, j).getPiece();
                        if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != color) {
                            return true;
                        }
                        break;
                    }

                    ++i;
                }
            } else {
                p = board.getSquare(x + 1, y + 1).getPiece();
                if(p.pColor != color) {
                    if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != color) {
                        return true;
                    }

                    if(color == Color.White) {
                        if(p.pClass == Class.Pawn || p.pClass == Class.King && p.pColor != color) {
                            return true;
                        }
                    } else if(p.pClass == Class.King && p.pColor != color) {
                        return true;
                    }
                }
            }

            if(board.isSpotEmpty(x + 1, y - 1)) {
                i = x + 1;

                for(j = y - 1; i < 8 && j > 0; --j) {
                    if(!board.isSpotEmpty(i, j)) {
                        p = board.getSquare(i, j).getPiece();
                        if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != color) {
                            return true;
                        }
                        break;
                    }

                    ++i;
                }
            } else {
                p = board.getSquare(x + 1, y - 1).getPiece();
                if(p.pColor != color) {
                    if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != color) {
                        return true;
                    }

                    if(color == Color.White) {
                        if(p.pClass == Class.Pawn || p.pClass == Class.King && p.pColor != color) {
                            return true;
                        }
                    } else if(p.pClass == Class.King && p.pColor != color) {
                        return true;
                    }
                }
            }

            if(board.isSpotEmpty(x - 1, y + 1)) {
                i = x - 1;

                for(j = y + 1; i > 0 && j < 8; ++j) {
                    if(!board.isSpotEmpty(i, j)) {
                        p = board.getSquare(i, j).getPiece();
                        if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != color) {
                            return true;
                        }
                        break;
                    }

                    --i;
                }
            } else {
                p = board.getSquare(x - 1, y + 1).getPiece();
                if(p.pColor != color) {
                    if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != color) {
                        return true;
                    }

                    if(color == Color.Black) {
                        if(p.pClass == Class.Pawn || p.pClass == Class.King && p.pColor != color) {
                            return true;
                        }
                    } else if(p.pClass == Class.King && p.pColor != color) {
                        return true;
                    }
                }
            }

            if(board.isSpotEmpty(x - 1, y - 1)) {
                i = x - 1;

                for(j = y - 1; i > 0 && j > 0; --j) {
                    if(!board.isSpotEmpty(i, j)) {
                        p = board.getSquare(i, j).getPiece();
                        if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != color) {
                            return true;
                        }
                        break;
                    }

                    --i;
                }
            } else {
                p = board.getSquare(x - 1, y - 1).getPiece();
                if(p.pColor != color) {
                    if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != color) {
                        return true;
                    }

                    if(color == Color.Black) {
                        if(p.pClass == Class.Pawn || p.pClass == Class.King && p.pColor != color) {
                            return true;
                        }
                    } else if(p.pClass == Class.King && p.pColor != color) {
                        return true;
                    }
                }
            }

            for(i = y + 1; i < 8; ++i) {
                if(!board.isSpotEmpty(x, i)) {
                    p = board.getSquare(x, i).getPiece();
                    if((p.pClass == Class.Queen || p.pClass == Class.Rook) && p.pColor != color) {
                        return true;
                    }

                    if(i == y + 1 && p.pClass == Class.King && p.pColor != color) {
                        return true;
                    }
                    break;
                }
            }

            for(i = y - 1; i > 0; --i) {
                if(!board.isSpotEmpty(x, i)) {
                    p = board.getSquare(x, i).getPiece();
                    if((p.pClass == Class.Queen || p.pClass == Class.Rook) && p.pColor != color) {
                        return true;
                    }

                    if(i == y - 1 && p.pClass == Class.King && p.pColor != color) {
                        return true;
                    }
                    break;
                }
            }

            for(i = x + 1; i < 8; ++i) {
                if(!board.isSpotEmpty(i, y)) {
                    p = board.getSquare(i, y).getPiece();
                    if((p.pClass == Class.Queen || p.pClass == Class.Rook) && p.pColor != color) {
                        return true;
                    }

                    if(i == x + 1 && p.pClass == Class.King && p.pColor != color) {
                        return true;
                    }
                    break;
                }
            }

            for(i = x - 1; i > 0; --i) {
                if(!board.isSpotEmpty(i, y)) {
                    p = board.getSquare(i, y).getPiece();
                    if((p.pClass == Class.Queen || p.pClass == Class.Rook) && p.pColor != color) {
                        return true;
                    }

                    if(i == x - 1 && p.pClass == Class.King && p.pColor != color) {
                        return true;
                    }
                    break;
                }
            }

            if(!board.isSpotEmpty(x + 2, y + 1)) {
                p = board.getSquare(x + 2, y + 1).getPiece();
                if(p != null && p.pClass == Class.Knight && p.pColor != color) {
                    return true;
                }
            }

            if(!board.isSpotEmpty(x + 2, y - 1)) {
                p = board.getSquare(x + 2, y - 1).getPiece();
                if(p != null && p.pClass == Class.Knight && p.pColor != color) {
                    return true;
                }
            }

            if(!board.isSpotEmpty(x - 2, y + 1)) {
                p = board.getSquare(x - 2, y + 1).getPiece();
                if(p != null && p.pClass == Class.Knight && p.pColor != color) {
                    return true;
                }
            }

            if(!board.isSpotEmpty(x - 2, y - 1)) {
                p = board.getSquare(x - 2, y - 1).getPiece();
                if(p != null && p.pClass == Class.Knight && p.pColor != color) {
                    return true;
                }
            }

            if(!board.isSpotEmpty(x + 1, y + 2)) {
                p = board.getSquare(x + 1, y + 2).getPiece();
                if(p != null && p.pClass == Class.Knight && p.pColor != color) {
                    return true;
                }
            }

            if(!board.isSpotEmpty(x - 1, y + 2)) {
                p = board.getSquare(x - 1, y + 2).getPiece();
                if(p != null && p.pClass == Class.Knight && p.pColor != color) {
                    return true;
                }
            }

            if(!board.isSpotEmpty(x + 1, y - 2)) {
                p = board.getSquare(x + 1, y - 2).getPiece();
                if(p != null && p.pClass == Class.Knight && p.pColor != color) {
                    return true;
                }
            }

            if(!board.isSpotEmpty(x - 1, y - 2)) {
                p = board.getSquare(x - 1, y - 2).getPiece();
                if(p != null && p.pClass == Class.Knight && p.pColor != color) {
                    return true;
                }
            }

            return false;
        }
    }

    public static boolean scanCheckKingSaved(int x, int y, Color color, Board board) {
        if(board.outOfRange(x, y)) {
            return true;
        } else {
            Piece p;
            int i;
            int j;
            if(board.isSpotEmpty(x + 1, y + 1)) {
                i = x + 1;

                for(j = y + 1; i < 8 && j < 8; ++j) {
                    if(!board.isSpotEmpty(i, j)) {
                        p = board.getSquare(i, j).getPiece();
                        if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != color) {
                            return true;
                        }
                        break;
                    }

                    ++i;
                }
            } else {
                p = board.getSquare(x + 1, y + 1).getPiece();
                if(p.pColor == color) {
                    if(p.pClass == Class.King) {
                        i = x + 2;

                        for(j = y + 2; i < 8 && j < 8; ++j) {
                            if(!board.isSpotEmpty(i, j)) {
                                p = board.getSquare(i, j).getPiece();
                                if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != color) {
                                    return true;
                                }
                                break;
                            }

                            ++i;
                        }
                    }
                } else {
                    if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != color) {
                        return true;
                    }

                    if(color == Color.White) {
                        if(p.pClass == Class.Pawn || p.pClass == Class.King && p.pColor != color) {
                            return true;
                        }
                    } else if(p.pClass == Class.King && p.pColor != color) {
                        return true;
                    }
                }
            }

            if(board.isSpotEmpty(x + 1, y - 1)) {
                i = x + 1;

                for(j = y - 1; i < 8 && j > 0; --j) {
                    if(!board.isSpotEmpty(i, j)) {
                        p = board.getSquare(i, j).getPiece();
                        if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != color) {
                            return true;
                        }
                        break;
                    }

                    ++i;
                }
            } else {
                p = board.getSquare(x + 1, y - 1).getPiece();
                if(p.pColor == color) {
                    i = x + 2;

                    for(j = y - 2; i < 8 && j > 0; --j) {
                        if(!board.isSpotEmpty(i, j)) {
                            p = board.getSquare(i, j).getPiece();
                            if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != color) {
                                return true;
                            }
                            break;
                        }

                        ++i;
                    }
                } else {
                    if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != color) {
                        return true;
                    }

                    if(color == Color.White) {
                        if(p.pClass == Class.Pawn || p.pClass == Class.King && p.pColor != color) {
                            return true;
                        }
                    } else if(p.pClass == Class.King && p.pColor != color) {
                        return true;
                    }
                }
            }

            if(board.isSpotEmpty(x - 1, y + 1)) {
                i = x - 1;

                for(j = y + 1; i > 0 && j < 8; ++j) {
                    if(!board.isSpotEmpty(i, j)) {
                        p = board.getSquare(i, j).getPiece();
                        if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != color) {
                            return true;
                        }
                        break;
                    }

                    --i;
                }
            } else {
                p = board.getSquare(x - 1, y + 1).getPiece();
                if(p.pColor == color) {
                    i = x - 2;

                    for(j = y + 2; i > 0 && j < 8; ++j) {
                        if(!board.isSpotEmpty(i, j)) {
                            p = board.getSquare(i, j).getPiece();
                            if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != color) {
                                return true;
                            }
                            break;
                        }

                        --i;
                    }
                } else {
                    if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != color) {
                        return true;
                    }

                    if(color == Color.Black) {
                        if(p.pClass == Class.Pawn || p.pClass == Class.King && p.pColor != color) {
                            return true;
                        }
                    } else if(p.pClass == Class.King && p.pColor != color) {
                        return true;
                    }
                }
            }

            if(board.isSpotEmpty(x - 1, y - 1)) {
                i = x - 1;

                for(j = y - 1; i > 0 && j > 0; --j) {
                    if(!board.isSpotEmpty(i, j)) {
                        p = board.getSquare(i, j).getPiece();
                        if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != color) {
                            return true;
                        }
                        break;
                    }

                    --i;
                }
            } else {
                p = board.getSquare(x - 1, y - 1).getPiece();
                if(p.pColor == color) {
                    i = x - 2;

                    for(j = y - 2; i > 0 && j > 0; --j) {
                        if(!board.isSpotEmpty(i, j)) {
                            p = board.getSquare(i, j).getPiece();
                            if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != color) {
                                return true;
                            }
                            break;
                        }

                        --i;
                    }
                } else {
                    if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != color) {
                        return true;
                    }

                    if(color == Color.Black) {
                        if(p.pClass == Class.Pawn || p.pClass == Class.King && p.pColor != color) {
                            return true;
                        }
                    } else if(p.pClass == Class.King && p.pColor != color) {
                        return true;
                    }
                }
            }

            for(i = y + 1; i < 8; ++i) {
                if(!board.isSpotEmpty(x, i)) {
                    p = board.getSquare(x, i).getPiece();
                    if((p.pClass == Class.Queen || p.pClass == Class.Rook) && p.pColor != color) {
                        return true;
                    }

                    if(i != y + 1) {
                        break;
                    }

                    if(p.pClass == Class.King && p.pColor != color) {
                        return true;
                    }

                    if(p.pClass != Class.King || p.pColor != color) {
                        break;
                    }
                }
            }

            for(i = y - 1; i > 0; --i) {
                if(!board.isSpotEmpty(x, i)) {
                    p = board.getSquare(x, i).getPiece();
                    if((p.pClass == Class.Queen || p.pClass == Class.Rook) && p.pColor != color) {
                        return true;
                    }

                    if(i != y - 1) {
                        break;
                    }

                    if(p.pClass == Class.King && p.pColor != color) {
                        return true;
                    }

                    if(p.pClass != Class.King || p.pColor != color) {
                        break;
                    }
                }
            }

            for(i = x + 1; i < 8; ++i) {
                if(!board.isSpotEmpty(i, y)) {
                    p = board.getSquare(i, y).getPiece();
                    if((p.pClass == Class.Queen || p.pClass == Class.Rook) && p.pColor != color) {
                        return true;
                    }

                    if(i != x + 1) {
                        break;
                    }

                    if(p.pClass == Class.King && p.pColor != color) {
                        return true;
                    }

                    if(p.pClass != Class.King || p.pColor != color) {
                        break;
                    }
                }
            }

            for(i = x - 1; i > 0; --i) {
                if(!board.isSpotEmpty(i, y)) {
                    p = board.getSquare(i, y).getPiece();
                    if((p.pClass == Class.Queen || p.pClass == Class.Rook) && p.pColor != color) {
                        return true;
                    }

                    if(i != x - 1) {
                        break;
                    }

                    if(p.pClass == Class.King && p.pColor != color) {
                        return true;
                    }

                    if(p.pClass != Class.King || p.pColor != color) {
                        break;
                    }
                }
            }

            if(!board.isSpotEmpty(x + 2, y + 1)) {
                p = board.getSquare(x + 2, y + 1).getPiece();
                if(p != null && p.pClass == Class.Knight && p.pColor != color) {
                    return true;
                }
            }

            if(!board.isSpotEmpty(x + 2, y - 1)) {
                p = board.getSquare(x + 2, y - 1).getPiece();
                if(p != null && p.pClass == Class.Knight && p.pColor != color) {
                    return true;
                }
            }

            if(!board.isSpotEmpty(x - 2, y + 1)) {
                p = board.getSquare(x - 2, y + 1).getPiece();
                if(p != null && p.pClass == Class.Knight && p.pColor != color) {
                    return true;
                }
            }

            if(!board.isSpotEmpty(x - 2, y - 1)) {
                p = board.getSquare(x - 2, y - 1).getPiece();
                if(p != null && p.pClass == Class.Knight && p.pColor != color) {
                    return true;
                }
            }

            if(!board.isSpotEmpty(x + 1, y + 2)) {
                p = board.getSquare(x + 1, y + 2).getPiece();
                if(p != null && p.pClass == Class.Knight && p.pColor != color) {
                    return true;
                }
            }

            if(!board.isSpotEmpty(x - 1, y + 2)) {
                p = board.getSquare(x - 1, y + 2).getPiece();
                if(p != null && p.pClass == Class.Knight && p.pColor != color) {
                    return true;
                }
            }

            if(!board.isSpotEmpty(x + 1, y - 2)) {
                p = board.getSquare(x + 1, y - 2).getPiece();
                if(p != null && p.pClass == Class.Knight && p.pColor != color) {
                    return true;
                }
            }

            if(!board.isSpotEmpty(x - 1, y - 2)) {
                p = board.getSquare(x - 1, y - 2).getPiece();
                if(p != null && p.pClass == Class.Knight && p.pColor != color) {
                    return true;
                }
            }

            return false;
        }
    }

    public static boolean scanCheckBlocked(int x, int y, Color color, Board board) {
        if(board.outOfRange(x, y)) {
            return true;
        } else {
            Piece p;
            int i;
            int j;
            if(board.isSpotEmpty(x + 1, y + 1)) {
                i = x + 1;

                for(j = y + 1; i < 8 && j < 8; ++j) {
                    if(!board.isSpotEmpty(i, j)) {
                        p = board.getSquare(i, j).getPiece();
                        if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != color) {
                            return true;
                        }
                        break;
                    }

                    ++i;
                }
            } else {
                p = board.getSquare(x + 1, y + 1).getPiece();
                if(p.pColor != color) {
                    if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != color) {
                        return true;
                    }

                    if(color == Color.White && p.pClass == Class.Pawn && p.pColor != color) {
                        return true;
                    }
                }
            }

            if(board.isSpotEmpty(x + 1, y - 1)) {
                i = x + 1;

                for(j = y - 1; i < 8 && j > 0; --j) {
                    if(!board.isSpotEmpty(i, j)) {
                        p = board.getSquare(i, j).getPiece();
                        if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != color) {
                            return true;
                        }
                        break;
                    }

                    ++i;
                }
            } else {
                p = board.getSquare(x + 1, y - 1).getPiece();
                if(p.pColor != color) {
                    if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != color) {
                        return true;
                    }

                    if(color == Color.White && p.pClass == Class.Pawn && p.pColor != color) {
                        return true;
                    }
                }
            }

            if(board.isSpotEmpty(x - 1, y + 1)) {
                i = x - 1;

                for(j = y + 1; i > 0 && j < 8; ++j) {
                    if(!board.isSpotEmpty(i, j)) {
                        p = board.getSquare(i, j).getPiece();
                        if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != color) {
                            return true;
                        }
                        break;
                    }

                    --i;
                }
            } else {
                p = board.getSquare(x - 1, y + 1).getPiece();
                if(p.pColor != color) {
                    if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != color) {
                        return true;
                    }

                    if(color == Color.Black && p.pClass == Class.Pawn && p.pColor != color) {
                        return true;
                    }
                }
            }

            if(board.isSpotEmpty(x - 1, y - 1)) {
                i = x - 1;

                for(j = y - 1; i > 0 && j > 0; --j) {
                    if(!board.isSpotEmpty(i, j)) {
                        p = board.getSquare(i, j).getPiece();
                        if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != color) {
                            return true;
                        }
                        break;
                    }

                    --i;
                }
            } else {
                p = board.getSquare(x - 1, y - 1).getPiece();
                if(p.pColor != color) {
                    if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != color) {
                        return true;
                    }

                    if(color == Color.Black && p.pClass == Class.Pawn && p.pColor != color) {
                        return true;
                    }
                }
            }

            for(i = y + 1; i < 8; ++i) {
                if(!board.isSpotEmpty(x, i)) {
                    p = board.getSquare(x, i).getPiece();
                    if((p.pClass == Class.Queen || p.pClass == Class.Rook) && p.pColor != color) {
                        return true;
                    }
                    break;
                }
            }

            for(i = y - 1; i > 0; --i) {
                if(!board.isSpotEmpty(x, i)) {
                    p = board.getSquare(x, i).getPiece();
                    if((p.pClass == Class.Queen || p.pClass == Class.Rook) && p.pColor != color) {
                        return true;
                    }
                    break;
                }
            }

            for(i = x + 1; i < 8; ++i) {
                if(!board.isSpotEmpty(i, y)) {
                    p = board.getSquare(i, y).getPiece();
                    if((p.pClass == Class.Queen || p.pClass == Class.Rook) && p.pColor != color) {
                        return true;
                    }
                    break;
                }
            }

            for(i = x - 1; i > 0; --i) {
                if(!board.isSpotEmpty(i, y)) {
                    p = board.getSquare(i, y).getPiece();
                    if((p.pClass == Class.Queen || p.pClass == Class.Rook) && p.pColor != color) {
                        return true;
                    }
                    break;
                }
            }

            if(!board.isSpotEmpty(x + 2, y + 1)) {
                p = board.getSquare(x + 2, y + 1).getPiece();
                if(p != null && p.pClass == Class.Knight && p.pColor != color) {
                    return true;
                }
            }

            if(!board.isSpotEmpty(x + 2, y - 1)) {
                p = board.getSquare(x + 2, y - 1).getPiece();
                if(p != null && p.pClass == Class.Knight && p.pColor != color) {
                    return true;
                }
            }

            if(!board.isSpotEmpty(x - 2, y + 1)) {
                p = board.getSquare(x - 2, y + 1).getPiece();
                if(p != null && p.pClass == Class.Knight && p.pColor != color) {
                    return true;
                }
            }

            if(!board.isSpotEmpty(x - 2, y - 1)) {
                p = board.getSquare(x - 2, y - 1).getPiece();
                if(p != null && p.pClass == Class.Knight && p.pColor != color) {
                    return true;
                }
            }

            if(!board.isSpotEmpty(x + 1, y + 2)) {
                p = board.getSquare(x + 1, y + 2).getPiece();
                if(p != null && p.pClass == Class.Knight && p.pColor != color) {
                    return true;
                }
            }

            if(!board.isSpotEmpty(x - 1, y + 2)) {
                p = board.getSquare(x - 1, y + 2).getPiece();
                if(p != null && p.pClass == Class.Knight && p.pColor != color) {
                    return true;
                }
            }

            if(!board.isSpotEmpty(x + 1, y - 2)) {
                p = board.getSquare(x + 1, y - 2).getPiece();
                if(p != null && p.pClass == Class.Knight && p.pColor != color) {
                    return true;
                }
            }

            if(!board.isSpotEmpty(x - 1, y - 2)) {
                p = board.getSquare(x - 1, y - 2).getPiece();
                if(p != null && p.pClass == Class.Knight && p.pColor != color) {
                    return true;
                }
            }

            return false;
        }
    }

    public static int scanCheckKing(Piece q, Board board, short[] safe, Piece[] danger, List<Piece> knights) {
        int x = q.getPosition().getRank();
        int y = q.getPosition().getFile();
        int key = 0;
        Piece p;
        int i;
        int j;
        if(board.isSpotEmpty(x + 1, y + 1)) {
            i = x + 1;

            for(j = y + 1; i < 8 && j < 8; ++j) {
                if(!board.isSpotEmpty(i, j)) {
                    p = board.getSquare(i, j).getPiece();
                    if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != q.pColor) {
                        danger[2] = p;
                        safe[2] = 0;
                        ++key;
                    } else {
                        safe[2] = 1;
                    }
                    break;
                }

                ++i;
            }
        } else {
            p = board.getSquare(x + 1, y + 1).getPiece();
            if(p.pColor == q.pColor) {
                safe[2] = 0;
            } else if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != q.pColor) {
                danger[2] = p;
                safe[2] = 0;
                ++key;
            } else if(q.pColor == Color.White) {
                if(p.pClass == Class.Pawn || p.pClass == Class.King && p.pColor != q.pColor) {
                    danger[2] = p;
                    safe[2] = 0;
                    ++key;
                }
            } else if(p.pClass == Class.King && p.pColor != q.pColor) {
                danger[2] = p;
                safe[2] = 0;
                ++key;
            }

            i = x;
            j = y;
        }

        if(i == 8 || j == 8) {
            safe[2] = 1;
        }

        if(board.isSpotEmpty(x + 1, y - 1)) {
            i = x + 1;

            for(j = y - 1; i < 8 && j > -1; --j) {
                if(!board.isSpotEmpty(i, j)) {
                    p = board.getSquare(i, j).getPiece();
                    if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != q.pColor) {
                        danger[0] = p;
                        safe[0] = 0;
                        ++key;
                    } else {
                        safe[0] = 1;
                    }
                    break;
                }

                ++i;
            }
        } else {
            p = board.getSquare(x + 1, y - 1).getPiece();
            if(p.pColor == q.pColor) {
                safe[0] = 0;
            } else if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != q.pColor) {
                danger[0] = p;
                safe[0] = 0;
                ++key;
            } else if(q.pColor == Color.White) {
                if(p.pClass == Class.Pawn || p.pClass == Class.King && p.pColor != q.pColor) {
                    danger[0] = p;
                    safe[0] = 0;
                    ++key;
                }
            } else if(p.pClass == Class.King && p.pColor != q.pColor) {
                danger[0] = p;
                safe[0] = 0;
                ++key;
            }

            i = x;
            j = y;
        }

        if(i == 8 || j == -1) {
            safe[0] = 1;
        }

        if(board.isSpotEmpty(x - 1, y + 1)) {
            i = x - 1;

            for(j = y + 1; i > -1 && j < 8; ++j) {
                if(!board.isSpotEmpty(i, j)) {
                    p = board.getSquare(i, j).getPiece();
                    if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != q.pColor) {
                        danger[7] = p;
                        safe[7] = 0;
                        ++key;
                    } else {
                        safe[7] = 1;
                    }
                    break;
                }

                --i;
            }
        } else {
            p = board.getSquare(x - 1, y + 1).getPiece();
            if(p.pColor == q.pColor) {
                safe[5] = 0;
            } else if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != q.pColor) {
                danger[7] = p;
                safe[7] = 0;
                ++key;
            } else if(q.pColor == Color.Black) {
                if(p.pClass == Class.Pawn || p.pClass == Class.King && p.pColor != q.pColor) {
                    danger[7] = p;
                    safe[7] = 0;
                    ++key;
                }
            } else if(p.pClass == Class.King && p.pColor != q.pColor) {
                danger[7] = p;
                safe[7] = 0;
                ++key;
            }

            i = x;
            j = y;
        }

        if(i == -1 || j == 8) {
            safe[5] = 1;
        }

        if(board.isSpotEmpty(x - 1, y - 1)) {
            i = x - 1;

            for(j = y - 1; i > -1 && j > -1; --j) {
                if(!board.isSpotEmpty(i, j)) {
                    p = board.getSquare(i, j).getPiece();
                    if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != q.pColor) {
                        danger[5] = p;
                        safe[5] = 0;
                        ++key;
                    } else {
                        safe[5] = 1;
                    }
                    break;
                }

                --i;
            }
        } else {
            p = board.getSquare(x - 1, y - 1).getPiece();
            if(p.pColor == q.pColor) {
                safe[5] = 0;
            } else if((p.pClass == Class.Bishop || p.pClass == Class.Queen) && p.pColor != q.pColor) {
                danger[5] = p;
                safe[5] = 0;
                ++key;
            } else if(q.pColor == Color.Black) {
                if(p.pClass == Class.Pawn || p.pClass == Class.King && p.pColor != q.pColor) {
                    danger[5] = p;
                    safe[5] = 0;
                    ++key;
                }
            } else if(p.pClass == Class.King && p.pColor != q.pColor) {
                danger[5] = p;
                safe[5] = 0;
                ++key;
            }

            i = x;
            j = y;
        }

        if(i == -1 || j == -1) {
            safe[5] = 1;
        }

        for(i = y + 1; i < 8; ++i) {
            if(!board.isSpotEmpty(x, i)) {
                p = board.getSquare(x, i).getPiece();
                if((p.pClass == Class.Queen || p.pClass == Class.Rook) && p.pColor != q.pColor) {
                    danger[4] = p;
                    safe[4] = 0;
                    ++key;
                } else if(p.pColor != q.pColor) {
                    if(i == y + 1 && p.pClass == Class.King && p.pColor != q.pColor) {
                        danger[4] = p;
                        safe[4] = 0;
                        ++key;
                    }
                } else if(i == y + 1) {
                    safe[4] = 0;
                } else {
                    safe[4] = 1;
                }
                break;
            }
        }

        if(i == 8) {
            safe[4] = 1;
        }

        for(i = y - 1; i > -1; --i) {
            if(!board.isSpotEmpty(x, i)) {
                p = board.getSquare(x, i).getPiece();
                if((p.pClass == Class.Queen || p.pClass == Class.Rook) && p.pColor != q.pColor) {
                    danger[3] = p;
                    safe[3] = 0;
                    ++key;
                } else if(p.pColor != q.pColor) {
                    if(i == y - 1 && p.pClass == Class.King && p.pColor != q.pColor) {
                        danger[3] = p;
                        safe[3] = 0;
                        ++key;
                    }
                } else if(i == y - 1) {
                    safe[3] = 0;
                } else {
                    safe[3] = 1;
                }
                break;
            }
        }

        if(i == -1) {
            safe[3] = 1;
        }

        for(i = x + 1; i < 8; ++i) {
            if(!board.isSpotEmpty(i, y)) {
                p = board.getSquare(i, y).getPiece();
                if((p.pClass == Class.Queen || p.pClass == Class.Rook) && p.pColor != q.pColor) {
                    danger[1] = p;
                    safe[1] = 0;
                    ++key;
                } else if(p.pColor != q.pColor) {
                    if(i == x + 1 && p.pClass == Class.King && p.pColor != q.pColor) {
                        danger[1] = p;
                        safe[1] = 0;
                        ++key;
                    }
                } else if(i == x + 1) {
                    safe[1] = 0;
                } else {
                    safe[1] = 1;
                }
                break;
            }
        }

        if(i == 8) {
            safe[1] = 1;
        }

        for(i = x - 1; i > -1; --i) {
            if(!board.isSpotEmpty(i, y)) {
                p = board.getSquare(i, y).getPiece();
                if((p.pClass == Class.Queen || p.pClass == Class.Rook) && p.pColor != q.pColor) {
                    danger[6] = p;
                    safe[6] = 0;
                    ++key;
                } else if(p.pColor != q.pColor) {
                    if(i == x - 1 && p.pClass == Class.King && p.pColor != q.pColor) {
                        danger[6] = p;
                        safe[6] = 0;
                        ++key;
                    }
                } else if(i == x - 1) {
                    safe[6] = 0;
                } else {
                    safe[6] = 1;
                }
                break;
            }
        }

        if(i == -1) {
            safe[6] = 1;
        }

        if(!board.isSpotEmpty(x + 2, y + 1)) {
            p = board.getSquare(x + 2, y + 1).getPiece();
            if(p != null && p.pClass == Class.Knight && p.pColor != q.pColor) {
                knights.add(p);
                ++key;
            }
        }

        if(!board.isSpotEmpty(x + 2, y - 1)) {
            p = board.getSquare(x + 2, y - 1).getPiece();
            if(p != null && p.pClass == Class.Knight && p.pColor != q.pColor) {
                knights.add(p);
                ++key;
            }
        }

        if(!board.isSpotEmpty(x - 2, y + 1)) {
            p = board.getSquare(x - 2, y + 1).getPiece();
            if(p != null && p.pClass == Class.Knight && p.pColor != q.pColor) {
                knights.add(p);
                ++key;
            }
        }

        if(!board.isSpotEmpty(x - 2, y - 1)) {
            p = board.getSquare(x - 2, y - 1).getPiece();
            if(p != null && p.pClass == Class.Knight && p.pColor != q.pColor) {
                knights.add(p);
                ++key;
            }
        }

        if(!board.isSpotEmpty(x + 1, y + 2)) {
            p = board.getSquare(x + 1, y + 2).getPiece();
            if(p != null && p.pClass == Class.Knight && p.pColor != q.pColor) {
                knights.add(p);
                ++key;
            }
        }

        if(!board.isSpotEmpty(x - 1, y + 2)) {
            p = board.getSquare(x - 1, y + 2).getPiece();
            if(p != null && p.pClass == Class.Knight && p.pColor != q.pColor) {
                knights.add(p);
                ++key;
            }
        }

        if(!board.isSpotEmpty(x + 1, y - 2)) {
            p = board.getSquare(x + 1, y - 2).getPiece();
            if(p != null && p.pClass == Class.Knight && p.pColor != q.pColor) {
                knights.add(p);
                ++key;
            }
        }

        if(!board.isSpotEmpty(x - 1, y - 2)) {
            p = board.getSquare(x - 1, y - 2).getPiece();
            if(p != null && p.pClass == Class.Knight && p.pColor != q.pColor) {
                knights.add(p);
                ++key;
            }
        }

        return key;
    }

    public static Piece canBlock(Square start, Color pColor, Square end, Piece p, int type) {
        if(scanCheck(start.getRank(), start.getFile(), pColor, p.board)) {
            return null;
        } else {
            int sRank = start.getRank();
            int sFile = start.getFile();
            int eRank = end.getRank();
            int eFile = end.getFile();
            int i;
            int j;
            switch(type) {
                case 0:
                    i = sRank;

                    for(j = sFile; i > eRank && j < sFile; ++j) {
                        if(scanCheckBlocked(i, j, pColor, p.board)) {
                            return null;
                        }

                        --i;
                    }

                    return p;
                case 1:
                    for(i = sRank; i > eRank; --i) {
                        if(scanCheckBlocked(i, sFile, pColor, p.board)) {
                            return null;
                        }
                    }

                    return p;
                case 2:
                    i = sRank;

                    for(j = sFile; i > eRank && j > sFile; --j) {
                        if(scanCheckBlocked(i, j, pColor, p.board)) {
                            return null;
                        }

                        --i;
                    }

                    return p;
                case 3:
                    for(i = sFile; i < eFile; ++i) {
                        if(scanCheckBlocked(sRank, i, pColor, p.board)) {
                            return null;
                        }
                    }

                    return p;
                case 4:
                    for(i = sFile; i > eFile; --i) {
                        if(scanCheckBlocked(sRank, i, pColor, p.board)) {
                            return null;
                        }
                    }

                    return p;
                case 5:
                    i = sRank;

                    for(j = sFile; i < eRank && j < eFile; ++j) {
                        if(scanCheckBlocked(i, j, pColor, p.board)) {
                            return null;
                        }

                        ++i;
                    }

                    return p;
                case 6:
                    for(i = sRank; i < eRank; ++i) {
                        if(scanCheckBlocked(i, sFile, pColor, p.board)) {
                            return null;
                        }
                    }

                    return p;
                case 7:
                    i = sRank;

                    for(j = sFile; i < eRank && j > eFile; --j) {
                        if(scanCheckBlocked(i, j, pColor, p.board)) {
                            return null;
                        }

                        ++i;
                    }
            }

            return p;
        }
    }
}
