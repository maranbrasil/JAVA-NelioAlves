package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {
    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    // crio somente o get, pois nao quero que a minha classe seja modificada, somente acessada.
    public Color getColor() {
        return color;
    }

    public ChessPosition getChessPosition() {
        return ChessPosition.fromPosition(position);
    }
    protected boolean isThereOpponentPiece(Position position) { // verifica se tem oponente na posicao almejada
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p.getColor() != color; // para concluir se a pe;ca p é uma peca adversaria eu verifico a cor dela se é diferente da cor da minha
    }
}
