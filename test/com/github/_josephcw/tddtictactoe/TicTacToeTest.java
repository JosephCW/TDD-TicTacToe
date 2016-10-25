package com.github._josephcw.tddtictactoe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TicTacToeTest {
	@Rule
	public ExpectedException e = ExpectedException.none();
	
	private TicTacToe ticTacToe;
	
	@Before
	public final void before() {
		ticTacToe = new TicTacToe();
	}
	
	@Test
	public void whenXOutsideBoardLimitsThenRuntimeException() {
		e.expect(RuntimeException.class);
		ticTacToe.play(4, 1);
	}
	
	@Test
	public void whenYOutsideBoardLimitsThenRuntimeException() {
		e.expect(RuntimeException.class);
		ticTacToe.play(1, 4);
	}
	
	@Test
	public void slotOccupiedAtLocationThenRuntimeException() {
		ticTacToe.play(1, 3);
		e.expect(RuntimeException.class);
		ticTacToe.play(1, 3);
	}
	
	@Test
	public void givenFirstPlayerOnPlaySetX() {
		assertEquals('X', ticTacToe.nextPlayer());
	}
	
	@Test
	public void secondTurnNextPlayerIsO() {
		ticTacToe.play(1, 1);
		assertEquals('O', ticTacToe.nextPlayer());
	}
	
	@Test
	public void thirdTurnNextPlayerIsX() {
		ticTacToe.play(1, 1);
		ticTacToe.play(1, 2);
		assertEquals('X', ticTacToe.nextPlayer());
	}
	
	@Test
	public void oneTurnNoWinner() {
		String status = ticTacToe.play(1, 1);
		assertEquals("No Winner", status);
	}
	
	@Test
	public void horizontalWin() {
		ticTacToe.play(1, 1); // X
		ticTacToe.play(2, 2); // O
		ticTacToe.play(2, 1); // X
		ticTacToe.play(2, 3); // O
		String status = ticTacToe.play(3, 1);
		assertEquals("X is the winner!", status);
	}
	
	@Test
	public void verticalWin() {
		ticTacToe.play(1, 1); // X
		ticTacToe.play(2, 1); // O
		ticTacToe.play(1, 2); // X
		ticTacToe.play(2, 2); // O
		String status = ticTacToe.play(1, 3);
		assertEquals("X is the winner!", status);
	}
	
	@Test
	public void whenPlayTopBottomDiagonalLineThenWin() {
		ticTacToe.play(1, 1);
		ticTacToe.play(1, 3);
		ticTacToe.play(2, 2);
		ticTacToe.play(2, 1);
		String status = ticTacToe.play(3, 3);
		assertEquals("X is the winner!", status);
	}
	
	@Test
	public void whenPlayBottomTopDiagonalLineThenWin() {
		ticTacToe.play(1, 3);
		ticTacToe.play(1, 1);
		ticTacToe.play(2, 2);
		ticTacToe.play(1, 2);
		String status = ticTacToe.play(3, 1);
		assertEquals("X is the winner!", status);
	}
	
	@Test
	public void whenAllSpotsFilledThenTie() {
		ticTacToe.play(1, 1); //X
		ticTacToe.play(1, 2); //Y
		ticTacToe.play(1, 3); //X
		ticTacToe.play(2, 1); //Y
		ticTacToe.play(2, 2); //X
		ticTacToe.play(3, 1); //O
		ticTacToe.play(2, 3); //X
		ticTacToe.play(3, 3); //O
		String status = ticTacToe.play(3, 2); //X
		assertEquals("Game Tied!", status);
	}
}
