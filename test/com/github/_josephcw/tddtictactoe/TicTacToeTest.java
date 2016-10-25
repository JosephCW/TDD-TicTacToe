package com.github._josephcw.tddtictactoe;

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
}
