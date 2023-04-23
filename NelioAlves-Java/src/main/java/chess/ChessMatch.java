package chess;

import boardgame.Board;
import boardgame.Position;

public class ChessMatch {
    private Board board; // coloco um board, pq uma partida de xadrez precisa ter um tabuleiro.

    public ChessMatch() { // quem tem que saber a dimensao de um tabuleiro de xadrez é a classe ChessMatch
        board = new Board(8,8);
        initialSetup();
    }

    // esse método retorna um tipo Matriz de ChessPieces
    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()]; // faço isso pra que meu jogo conheca a camada de xadrez e nao a camada de tabuleiro.
        // percorre a matriz de peças do tabuleiro e fazer um downcasting
        for (int i=0; i<board.getRows(); i++) {
            for (int j=0; j<board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i,j); // board.piece é do tipo Piece, mas o meu tabuleiro nao pode pegar as referencias da daqueeeeela peça instanciada no começo, ai eu chamos board.piece, mas fazendo o downCasting dizendo que o tipo é (ChessPiece)
            }
        }
        return mat;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }
    private void initialSetup() {
        placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
    }
}
