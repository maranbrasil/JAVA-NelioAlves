package chess;

import boardgame.Board;
import boardgame.Position;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }


    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position); // numa variavel do tipo ChessPiece pego a posicao da peca.
        return p == null || p.getColor() != getColor(); // verifico se a posicao é igual a null ou quando tem um oponente
    }

    @Override
    public boolean[][] possibleMoves() { // todas as possibilidades valendo false
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0); // posicao auxiliar, paara eu trabalhar com ela no código abaixo.

        //movimento acima
        p.setValues(position.getRow() -1, position.getColumn()); // para mover para cima basta subrtrair 1 da linha. O metodo setValues recebe um row e um column e seta a peça para essa posicao.
        if (getBoard().positionExists(p) && canMove(p)) { // testo se a posicao existe e se meu rei pode ser movido para essa posicao.
            mat[p.getRow()][p.getColumn()] = true;// se sim, eu marco a linha e coluna com true
        }

        //movimento abaixo
        p.setValues(position.getRow() + 1, position.getColumn()); // para mover basta somo 1 da linha. O metodo setValues recebe um row e um column e seta a peça para essa posicao.
        if (getBoard().positionExists(p) && canMove(p)) { // testo se a posicao existe e se meu rei pode ser movido para essa posicao.
            mat[p.getRow()][p.getColumn()] = true;// se sim, eu marco a linha e coluna com true
        }

        //movimento esq
        p.setValues(position.getRow(), position.getColumn() - 1); // para mover  basta subrtrair 1 da coluna. O metodo setValues recebe um row e um column e seta a peça para essa posicao.
        if (getBoard().positionExists(p) && canMove(p)) { // testo se a posicao existe e se meu rei pode ser movido para essa posicao.
            mat[p.getRow()][p.getColumn()] = true;// se sim, eu marco a linha e coluna com true
        }

        //movimento direita
        p.setValues(position.getRow(), position.getColumn() + 1); // para mover basta somar 1 da coluna. O metodo setValues recebe um row e um column e seta a peça para essa posicao.
        if (getBoard().positionExists(p) && canMove(p)) { // testo se a posicao existe e se meu rei pode ser movido para essa posicao.
            mat[p.getRow()][p.getColumn()] = true;// se sim, eu marco a linha e coluna com true
        }

        //movimento diagonal superior direita
        p.setValues(position.getRow() -1, position.getColumn() + 1); // para mover basta subrtrair 1 da linha e somar 1 na coluna. O metodo setValues recebe um row e um column e seta a peça para essa posicao.
        if (getBoard().positionExists(p) && canMove(p)) { // testo se a posicao existe e se meu rei pode ser movido para essa posicao.
            mat[p.getRow()][p.getColumn()] = true;// se sim, eu marco a linha e coluna com true
        }

        //movimento diagonal superior esquerda
        p.setValues(position.getRow() -1, position.getColumn() - 1); // para mover basta subrtrair 1 da linha e subtrair 1 na coluna. O metodo setValues recebe um row e um column e seta a peça para essa posicao.
        if (getBoard().positionExists(p) && canMove(p)) { // testo se a posicao existe e se meu rei pode ser movido para essa posicao.
            mat[p.getRow()][p.getColumn()] = true;// se sim, eu marco a linha e coluna com true
        }

        //movimento diagonal inferior direita
        p.setValues(position.getRow() + 1, position.getColumn() + 1); // para mover basta somar 1 da linha e somar 1 na coluna. O metodo setValues recebe um row e um column e seta a peça para essa posicao.
        if (getBoard().positionExists(p) && canMove(p)) { // testo se a posicao existe e se meu rei pode ser movido para essa posicao.
            mat[p.getRow()][p.getColumn()] = true;// se sim, eu marco a linha e coluna com true
        }

        //movimento diagonal inferior esquerda
        p.setValues(position.getRow() +1, position.getColumn() - 1); // para mover basta subrtrair 1 da linha e subtrair 1 na coluna. O metodo setValues recebe um row e um column e seta a peça para essa posicao.
        if (getBoard().positionExists(p) && canMove(p)) { // testo se a posicao existe e se meu rei pode ser movido para essa posicao.
            mat[p.getRow()][p.getColumn()] = true;// se sim, eu marco a linha e coluna com true
        }
        return mat;
    }
}
