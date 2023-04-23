package chess;

import boardgame.Board;

public class Rook extends ChessPiece{
    public Rook(Board board, Color color) {
        super(board, color);
    }
    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() { // todas as possibilidades valendo false
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        return mat;
    }
}
