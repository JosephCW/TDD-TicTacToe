package com.github._josephcw.tddtictactoe;

public class TicTacToe {
	private Character[][] board = {
			{'e', 'e', 'e'}, 
			{'e', 'e', 'e'},
			{'e', 'e', 'e'}
	};
	private String lastPlayer = "O";
	
	public void play(int x, int y) {
		// validate player played within the board
		validInput(x);
		validInput(y);
		setPiece(x, y);
		lastPlayer = nextPlayer();
	}

	private void validInput(int axis) {
		if(axis < 1 || axis > axis) {
			throw new RuntimeException("Input is outside of the board");
		}
	}
	
	private void setPiece(int x, int y) {
		if(board[x-1][y-1] != 'e') {
			throw new RuntimeException("Slot already occupied");
		} else {
			board[x-1][y-1] = 'X';
		}
	}

	public String nextPlayer() {
		if(lastPlayer.equals("O")) {
			return "X";
		}
		return "O";
	}
}
