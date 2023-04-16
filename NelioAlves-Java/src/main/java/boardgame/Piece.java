package boardgame;

public class Piece {
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

}
