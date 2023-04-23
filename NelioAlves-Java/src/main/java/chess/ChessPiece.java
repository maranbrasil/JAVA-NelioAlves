package chess;

import boardgame.Board;
import boardgame.Piece;

public class ChessPiece extends Piece {
    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    // crio somente o get, pois nao quero que a minha classe seja modificada, somente acessada.
    public Color getColor() {
        return color;
    }
}
