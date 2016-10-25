package com.github._josephcw.tddtictactoe;

public class TicTacToe {
	private Character[][] board = {
			{'e', 'e', 'e'}, 
			{'e', 'e', 'e'},
			{'e', 'e', 'e'}
	};
	
	public void play(int x, int y) {
		// validate player played within the board
		if(x < 1 || x > 3) {
			throw new RuntimeException("X is outide of the board");
		} else if(y < 1 || y > 3) {
			throw new RuntimeException("Y is outside of the board");
		}
		
		// validate piece doesn't already exist.
		if(board[x-1][y-1] != 'e') {
			throw new RuntimeException("Slot already occupied");
		} else {
			board[x-1][y-1] = 'X';
		}
		
	}
}
