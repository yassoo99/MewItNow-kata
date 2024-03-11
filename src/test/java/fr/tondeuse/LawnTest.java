package fr.tondeuse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.tondeuse.model.Lawn;

import static org.junit.jupiter.api.Assertions.*;

class LawnTest {
	private Lawn lawn;

	@BeforeEach
	void setUp() {
		lawn = new Lawn(5, 5);
	}

	@Test
	void givenValidPosition_whenIsWithinLimit_thenReturnTrue() {
		assertTrue(lawn.isWithinLimit(0, 0));
		assertTrue(lawn.isWithinLimit(5, 5));
		assertTrue(lawn.isWithinLimit(2, 3));
	}

	@Test
	void givenInvalidPosition_whenIsWithinLimit_thenReturnFalse() {
		assertFalse(lawn.isWithinLimit(-1, 0));
		assertFalse(lawn.isWithinLimit(0, -1));
		assertFalse(lawn.isWithinLimit(6, 5));
		assertFalse(lawn.isWithinLimit(5, 6));
	}

}