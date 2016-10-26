package com.github._josephcw.tddtictactoe;

public class TicTacToe {
	private Character[][] board = {
			{'e', 'e', 'e'}, 
			{'e', 'e', 'e'},
			{'e', 'e', 'e'}
	};
	private char lastPlayer = 'O';
	private final int SIZE = 3;
	
	public String play(int x, int y) {
		validInput(x);
		validInput(y);
		lastPlayer = nextPlayer();
		setPiece(x, y, lastPlayer);
		if (isWin(x, y)) {
			return lastPlayer + " is the winner!";
		} else if (isDraw()) {
			return "Game Tied!";
		} else {
			return "No Winner";
		}
	}

	private boolean isDraw() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if(board[i][j] == 'e') {
					return false;
				}
			}
		}
		return true;
	}

	private boolean isWin(int x, int y) {
		int playerTotal = lastPlayer * SIZE; // XXX or OOO
		char horizontal, vertical, diagonal1, diagonal2;
		horizontal = vertical = diagonal1 = diagonal2 = '\0';
		for (int index = 0; index < SIZE; index++) {
			horizontal += board[index][y - 1];
			vertical += board[x - 1][index];
			diagonal1 += board[index][index];
			diagonal2 += board[index][(SIZE - 1) - index];
			
		}
		if (diagonal1 == playerTotal 
				|| diagonal2 == playerTotal
				|| horizontal == playerTotal
				|| vertical == playerTotal) { 
			return true;
		}
		return false;
	}

	private void validInput(int axis) {
		if (axis < 1 || axis > SIZE) {
			throw new RuntimeException("Input is outside of the board");
		}
	}
	
	private void setPiece(int x, int y, char lastPlayer) {
		if (board[x - 1][y - 1] != 'e') {
			throw new RuntimeException("Slot already occupied");
		} else {
			board[x - 1][y - 1] = lastPlayer;
		}
	}

	public char nextPlayer() {
		if (lastPlayer == 'O') {
			return 'X';
		}
		return 'O';
	}
}
