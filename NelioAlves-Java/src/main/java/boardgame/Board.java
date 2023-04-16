package boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces; // tem uma MATRIZ de peças;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns]; // a minha matriz de peças vai ser instanciada com PIECE na quantidade de linhas e colunas informada
     }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }
}
