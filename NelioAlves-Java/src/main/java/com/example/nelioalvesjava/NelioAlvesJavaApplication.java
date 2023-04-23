package com.example.nelioalvesjava;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import java.util.Scanner;

public class NelioAlvesJavaApplication {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();

		while(true) { //coloquei true, pq nao temos um metodo de checkmate pra encerrar a partida.
			UI.printBoard(chessMatch.getPieces()); // imprimir tabuleiro na tela
			System.out.println(); // salto um linha
			System.out.print("Source: "); // usuario digitar a posicao de origem
			ChessPosition source = UI.readChessPosition(sc);

			System.out.println();
			System.out.print("Target: "); // usuario indicar a posicao de destino
			ChessPosition target = UI.readChessPosition(sc);

			ChessPiece capturedPiece = chessMatch.performChessMove(source, target); // efetua o movimento da peça da orgiem para o destino
		}

	}
}
