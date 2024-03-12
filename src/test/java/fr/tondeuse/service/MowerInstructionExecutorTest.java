package fr.tondeuse.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.tondeuse.model.Lawn;
import fr.tondeuse.model.MowerPosition;

import static org.junit.jupiter.api.Assertions.*;

public class MowerInstructionExecutorTest {

	private MowerInstructionExecutor tested;
	private Lawn lawn;

	@BeforeEach
	public void setUp() {
		lawn = new Lawn(5, 5);
		MowerPosition initialPosition = new MowerPosition(1, 2, 'N');
		String instructions = "GAGAGAGAA";
		tested = new MowerInstructionExecutor(initialPosition, lawn, instructions);

	}

	@Test
	public void testExecuteInstructionsAndReturnPosition() {
		MowerPosition finalPosition = tested.executeInstructionsAndReturnPosition();
		assertNotNull(finalPosition);
		assertEquals(new MowerPosition(1, 3, 'N'), finalPosition);
	}

}
