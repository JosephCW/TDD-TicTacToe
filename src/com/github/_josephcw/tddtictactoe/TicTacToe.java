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
		// validate player played within the board
		validInput(x);
		validInput(y);
		lastPlayer = nextPlayer();
		setPiece(x, y, lastPlayer);
		if (isWin()) {
			return lastPlayer + " is the winner!";
		}
		return "No Winner";
	}

	private boolean isWin() {
		int playerTotal = lastPlayer * 3; // XXX or OOO
		for (int index = 0; index < SIZE; index++) {
			if(board[0][index] + board[1][index] + board[2][index] == playerTotal) {
				// Horizontal Line
				return true;
			} else if (board[index][0] + board[index][1] + board[index][2] == playerTotal) {
				// Vertical Line
				return true;
			}
		}
		return false;
	}

	private void validInput(int axis) {
		if(axis < 1 || axis > SIZE) {
			throw new RuntimeException("Input is outside of the board");
		}
	}
	
	private void setPiece(int x, int y, char lastPlayer) {
		if(board[x - 1][y - 1] != 'e') {
			throw new RuntimeException("Slot already occupied");
		} else {
			board[x - 1][y - 1] = lastPlayer;
		}
	}

	public char nextPlayer() {
		if(lastPlayer == 'O') {
			return 'X';
		}
		return 'O';
	}
}
