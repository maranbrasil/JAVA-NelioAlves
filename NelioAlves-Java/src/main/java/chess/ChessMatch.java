package chess;

import boardgame.Board;
import boardgame.Piece;
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

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition(); // conversao da posicao recebida no arg para posicao da matriz
        Position target = targetPosition.toPosition(); // conversao da posicao recebida no arg para posicao da matriz
        validateSourcePosition(source); // validar posicao de origem, se a posicao nao existir a operacao lanca um excecao.
        validateTargetPosition(source, target); // validar posicao de destino, se a posicao nao existir a operacao lanca um excecao.
        Piece capturedPiece = makeMove(source, target); // essa var recebe a resposta de uma operacao chamada makemove
        return (ChessPiece) capturedPiece;
    }

    private Piece makeMove(Position source, Position target) { // para fazer um movimento de pça:
        Piece p = board.removePiece(source); // primeiro removo a peça da posicao de origem
        Piece capturedPiece = board.removePiece(target); // removi um possivel peca da possicao de destino, agora posso colocar a minha peça no local
        board.placePiece(p, target); // coloco minha peça na posicao desejada
        return capturedPiece; // retorno a pç capturada.
    }

    private void validateSourcePosition(Position position) {
        if (!board.thereIsAPiece(position)) {
            throw new ChessException("There is no piece on source position");
        }
        if (!board.piece(position).isThereAnyPossibleMove()) { // valido se a pç tem algum movimento possivel, e se nao tiver um movimento possivel lancó exceçao
            throw new ChessException("There is no possible moves to this piece");
        }
    }

    private void validateTargetPosition(Position source, Position target) { // basta eu testar se o movimento possivel está contemplado como um possibleMove considerando source and target.
        if (!board.piece(source).possibleMove(target)) { // no tabuleiro, verifica se a peca na posicao source... se não tiver movimento possivel dá excecao
            throw new ChessException("The chosen piece can't move to target position");
        }
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
