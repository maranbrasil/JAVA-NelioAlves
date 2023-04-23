package com.example.nelioalvesjava;

import chess.ChessMatch;

public class NelioAlvesJavaApplication {
	public static void main(String[] args) {
		// Board board = new Board(8,8); // instancio um board com 8linhas e 8 colunas.
		// rodo o programa pra ver se quebra algo.

		ChessMatch chessMatch = new ChessMatch();
		UI.printBoard(chessMatch.getPieces());
	}
}
