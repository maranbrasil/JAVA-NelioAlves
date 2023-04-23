package boardgame;

public abstract class Piece {
    protected Position position;
    // a peça sabe a posicao que ela está no tabuleiro, portanto tenho que acessar a peça a um tabuleiro.
    private Board board;

    // crio um construtor sem a posiçao, pois a peça quando instanciada ainda nao foi colocada no tabuleiro ainda.
    public Piece(Board board) {
        this.board = board;
        position = null; // se eu nao puser nada o Java ja coloca null por padrao.
    }

    // nao coloco metodo sett, pois nao quero que ele seja modificado. e tbm altero para metodo protected pra somente itens dessa classe poderem alterá-lo
    protected Board getBoard() {
        return board;
    }

    public abstract boolean[][] possibleMoves();

    public boolean possibleMove(Position position) {
        return possibleMoves()[position.getRow()][position.getColumn()]; // é um metodo concreto que é relacionado a um metodo abstrato, eu peço para o metodo possibleMoves de cada peça indicar os possiveis locais
    }

    public boolean isThereAnyPossibleMove() { //verifica se a pç está travada.
        boolean[][] mat = possibleMoves(); // uma variavel auxiliar da matriz de movimentos possiveis
        for (int i=0; i<mat.length; i++) {
            for (int j=0; j<mat.length; j++) {
                if (mat[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
