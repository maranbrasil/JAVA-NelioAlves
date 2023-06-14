package chess;

import static java.awt.Color.WHITE;
import static java.awt.Color.white;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChessMatch {
    private int turn;
    private Color currentPlayer;
    private Board board; // coloco um board, pq uma partida de xadrez precisa ter um tabuleiro.
    private boolean check; // verifica se está em situacao de check-mate

    private List<Piece> piecesOnTheBoard = new ArrayList<>();
    private List<Piece> capturedPieces = new ArrayList<>();
    public ChessMatch() { // quem tem que saber a dimensao de um tabuleiro de xadrez é a classe ChessMatch
        board = new Board(8,8);
        turn = 1; // no inicio da partida vale 1
        currentPlayer = Color.WHITE; // a primeira peca que joga é o branco
        check = false;
        initialSetup();
    }

    public int getTurn() {
        return turn;
    }

    public Color getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean getCheck() {
        return check;
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

    public boolean[][] possibleMoves(ChessPosition sourcePosition) {
        Position position = sourcePosition.toPosition(); //converte uma posicao de sourcePosition para uma posicaod e matriz normal (coluna 0a7 linha 0a7)
        validateSourcePosition(position); //já vilido a posicao logo após o usuario digitar a posicao de origem
        return board.piece(position).possibleMoves(); // movimentos possiveis dessa peca nessa posicao
    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition(); // conversao da posicao recebida no arg para posicao da matriz
        Position target = targetPosition.toPosition(); // conversao da posicao recebida no arg para posicao da matriz
        validateSourcePosition(source); // validar posicao de origem, se a posicao nao existir a operacao lanca um excecao.
        validateTargetPosition(source, target); // validar posicao de destino, se a posicao nao existir a operacao lanca um excecao.
        Piece capturedPiece = makeMove(source, target); // essa var recebe a resposta de uma operacao chamada makemove

        if (testCheck(currentPlayer)) { //testo se o jogar se colocou em cheque-mate, se sim desfaz o movimento
            undoMove(source, target, capturedPiece);
            throw new ChessException("You can`t put yourself in check");
        }

        check = (testCheck(opponent(currentPlayer))) ? true : false; // testa se o oponente ficou em cheque
        nextTurn();
        return (ChessPiece) capturedPiece;
    }

    private Piece makeMove(Position source, Position target) { // para fazer um movimento de pça:
        Piece p = board.removePiece(source); // primeiro removo a peça da posicao de origem
        Piece capturedPiece = board.removePiece(target); // removi um possivel peca da possicao de destino, agora posso colocar a minha peça no local
        board.placePiece(p, target); // coloco minha peça na posicao desejada
        if (capturedPiece != null) {
            piecesOnTheBoard.remove(capturedPiece);
            capturedPieces.add(capturedPiece);
        }
        return capturedPiece; // retorno a pç capturada.
    }

    private void undoMove(Position source, Position target, Piece capturedPiece) {
        Piece p = board.removePiece(target);
        board.placePiece(p, source);

        if (capturedPiece != null) { // se o capturedPiece for diferente de null ou seja, se capturedPiece tiver capturado algo, para nós voltarmos o movimento deve-se retirar a peça de peças capturadas.
            board.placePiece(capturedPiece, target);
            capturedPieces.remove(capturedPiece);
        }
    }

    private void validateSourcePosition(Position position) {
        if (!board.thereIsAPiece(position)) {
            throw new ChessException("There is no piece on source position");
        }
        if (currentPlayer != ((ChessPiece)board.piece(position)).getColor()) { // como o getColor é uma prop do ChessPiece, eu coloco um paretenses em boardpiece(position) e faço um downcasting de ChessPiece. ai sim posso ver a cor da peça.
            throw new ChessException("The chosen piece is not yours");
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

    private void nextTurn() { // esse metodo é chamado depois que eu executo uma jogada
        turn++; //soma um á cada jogada.
        currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private Color opponent (Color color) {
        return (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private ChessPiece king(Color color) { // verifica a cor do rei
        List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor() == color).collect( // lista que contém as peças que estão no tabuleiro. onde vou filtrar pela cor passada por parametro. Obs: x é do tipo piece e nao tem cor, e por isso fiz um DownCasting para que ela tenha a propriedade cor. To do Stream é colocado numa lista atraves do uso de .collect(Collectors.toList())
            Collectors.toList());
        for (Piece p : list) { // para cada peça(Piece) p, na minha lista list.
            if (p instanceof King) { // se p for uma instancia de King entao...
                return (ChessPiece)p;
            }
        }
        throw new IllegalStateException("There is no " + color + " king on the board");
    }

    private boolean testCheck(Color color) { // test se o rei está em cheque e recebe como argumento a cor.
        Position kingPosition = king(color).getChessPosition().toPosition();
        List<Piece> opponentPieces = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor() == opponent(color)).collect( // é igual ao metodo acima, porém com o método oponente.
            Collectors.toList());
        for (Piece p : opponentPieces) {
            boolean[][] mat = p.possibleMoves();
            if (mat[kingPosition.getRow()][kingPosition.getColumn()]) {
                return true;
            }
        }
        return false;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
        piecesOnTheBoard.add(piece); //toda peça que for instanciada pra ir pro tabuileiro deve ser colocada na lista de peças do tabuleiro.
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
