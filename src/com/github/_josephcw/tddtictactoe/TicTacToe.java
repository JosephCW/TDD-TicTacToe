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
		if (isWin()) {
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

	private boolean isWin() {
		int playerTotal = lastPlayer * 3; // XXX or OOO
		char diag1 = '\0';
		char diag2 = '\0';
		for (int index = 0; index < SIZE; index++) {
			diag1 += board[index][index];
			diag2 += board[index][(SIZE - 1) - index];
			if(board[0][index] + board[1][index] + board[2][index] == playerTotal) {
				// Horizontal Line
				return true;
			} else if (board[index][0] + board[index][1] + board[index][2] == playerTotal) {
				// Vertical Line
				return true;
			}
		}
		if (diag1 == playerTotal || diag2 == playerTotal) { 
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
