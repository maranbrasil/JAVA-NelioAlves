package boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces; // tem uma MATRIZ de peças;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns]; // a minha matriz de peças vai ser instanciada com PIECE na quantidade de linhas e colunas informada
     }

    public int getRows() {
        return rows;
    }


    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column) {
        if (!positionExists(row, column)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[row][column]; // retorn uma matriz pieces na linha row e na coluna column
    }

    // é uma sobrecarga do método acima, mas agora recebendo um position. E retorna a peça pela posição.
    public Piece piece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)){
            throw new BoardException("There is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }
    public Piece removePiece(Position position) {
        if (!positionExists(position)) { // verifica se a posicao informada existe.
            throw new BoardException("Position not on the board");
        }
        if (piece(position) == null) { // verifica se na posicao informada existe uma peça alocada, se nao existir retorna nada.
            return null;
        }
        Piece aux = piece(position); // uma variavel aux do tipo Piece é criada e recebe a peça na nova posiçao que eu quero colocar a nova peça.
        aux.position = null; // coloco que a posicao da dessa peça agora é nula, ou seja a peça foi retirada do tabuleiro.
        pieces[position.getRow()][position.getColumn()] = null; // essa matriz de peças recebe nulo, ou seja nao tem mais peça nessa posicao da matriz
        return aux; // retorna a peça que foi retirada daquela posicao.
    }
    private boolean positionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }
    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return piece(position) != null;
    }
}
