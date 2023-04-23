package com.example.nelioalvesjava;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class NelioAlvesJavaApplication {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		List< ChessPiece> captured = new ArrayList<>();

		while(true) { //coloquei true, pq nao temos um metodo de checkmate pra encerrar a partida.
			try {
				UI.clearScreen(); // lipa a tela do terminal para nao aparecer varios boards
				UI.printMatch(chessMatch, captured); // imprimir tabuleiro na tela e tbm a lista de pecas comidas
				System.out.println(); // salto um linha
				System.out.print("Source: "); // usuario digitar a posicao de origem
				ChessPosition source = UI.readChessPosition(sc);

				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMoves); // criado uma sobrecarga do metodo printBoard

				System.out.println();
				System.out.print("Target: "); // usuario indicar a posicao de destino
				ChessPosition target = UI.readChessPosition(sc);

				ChessPiece capturedPiece = chessMatch.performChessMove(source, target); // efetua o movimento da peça da orgiem para o destino Sempre que uma peca for capturada, eu acrecento na lista de pecas capturadas
				if (capturedPiece != null) {
					captured.add(capturedPiece);
				}
			} catch (ChessException e) {
				System.out.println(e.getMessage()); // mostra o erro
				sc.nextLine(); // aguarda o usuario digitar enter
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage()); // mostra o erro
				sc.nextLine(); // aguarda o usuario digitar enter
			}
		}
	}
}
