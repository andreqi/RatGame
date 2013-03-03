package ndr.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class RatGameTest {

	@Test
	public void testRatGame() {
		RatGame game = new RatGame("1234");
		assertEquals(game.tryNumber("1234"), new TryResult(4, 0));
		assertEquals(game.tryNumber("4321"), new TryResult(0, 4));
		assertEquals(game.tryNumber("5678"), new TryResult(0, 0));
		assertEquals(game.tryNumber("1243"), new TryResult(2, 2));
	}

}
