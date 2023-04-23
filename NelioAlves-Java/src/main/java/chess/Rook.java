package chess;

import boardgame.Board;
import boardgame.Position;

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
        Position p = new Position(0, 0); // inicio uma variavel do tipo position
        // verificar posiçoes da torre para cima
        p.setValues(position.getRow() - 1, position.getColumn()); // getRow() -1 é a linha acima da pos da minha peça, e position.getColum, pq pra mover pra cima a coluna é a mesma.
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) { //enqunto existir uma posicao no tabuleiro e nao tiver uma peça na posicao o while continua executando.
            mat[p.getRow()][p.getColumn()] = true; // coloco que para aquela posiçao é possible colocar a peça ali.
            p.setRow(p.getRow() - 1); // e enquanto nao satisfizer o cond do while eu subo uma [posicao da pça e verifico de novo.
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) { // se a posicao existir e a peça alocada ali for do oponente eu marco como possivel (true) a alocacao da minha peça ali.
            mat[p.getRow()][p.getColumn()] = true; // coloco que para aquela posiçao é possible colocar a peça ali.
        }

        // verificar posicoes a esquerda
        p.setValues(position.getRow(), position.getColumn() - 1); // getColumn() -1 é a linha a esq da pos da minha peça, e position.getRow nao altera pq pra mover pra esquerda a linha é a mesma.
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) { //enqunto existir uma posicao no tabuleiro e nao tiver uma peça na posicao o while continua executando.
            mat[p.getRow()][p.getColumn()] = true; // coloco que para aquela posiçao é possible colocar a peça ali.
            p.setColumn(p.getColumn() - 1); // e enquanto nao satisfizer o cond do while eu subtraio uma posicao de coluna da pça e verifico de novo.
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) { // se a posicao existir e a peça alocada ali for do oponente eu marco como possivel (true) a alocacao da minha peça ali.
            mat[p.getRow()][p.getColumn()] = true; // coloco que para aquela posiçao é possible colocar a peça ali.
        }

        // verificar posicoes a direita
        p.setValues(position.getRow(), position.getColumn() + 1); // getColumn() -1 é a linha a dir da pos da minha peça, e position.getRow nao altera pq pra mover pra direita a linha é a mesma.
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) { // enqunto existir uma posicao no tabuleiro e nao tiver uma peça na posicao o while continua executando.
            mat[p.getRow()][p.getColumn()] = true; // coloco que para aquela posiçao é possible colocar a peça ali.
            p.setColumn(p.getColumn() + 1); // e enquanto nao satisfizer o cond do while eu somo uma posicao de coluna da pça e verifico de novo.
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) { // se a posicao existir e a peça alocada ali for do oponente eu marco como possivel (true) a alocacao da minha peça ali.
            mat[p.getRow()][p.getColumn()] = true; // coloco que para aquela posiçao é possible colocar a peça ali.
        }

        // verificar posicoes para baixo
        p.setValues(position.getRow() + 1, position.getColumn()); // getRow() +1 é a linha abaixo da pos da minha peça, e position.getColum, pq pra mover pra baixo a coluna é a mesma.
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) { //enqunto existir uma posicao no tabuleiro e nao tiver uma peça na posicao o while continua executando.
            mat[p.getRow()][p.getColumn()] = true; // coloco que para aquela posiçao é possible colocar a peça ali.
            p.setRow(p.getRow() + 1); // e enquanto nao satisfizer o cond do while eu desco uma posicao da pça e verifico de novo.
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) { // se a posicao existir e a peça alocada ali for do oponente eu marco como possivel (true) a alocacao da minha peça ali.
            mat[p.getRow()][p.getColumn()] = true; // coloco que para aquela posiçao é possible colocar a peça ali.
        }
        return mat;
    }
}
