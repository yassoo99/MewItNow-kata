package fr.tondeuse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import fr.tondeuse.model.Lawn;
import fr.tondeuse.model.Mower;
import fr.tondeuse.model.MowerPosition;

class MowerTest {
	private Lawn lawn;
	private Mower mower1;
	private Mower mower2;


	@BeforeEach
	void setUp() {
		lawn = new Lawn(5, 5);
		MowerPosition mowerPosition1 = new MowerPosition(1, 2, 'N');
		mower1 = new Mower(mowerPosition1, lawn, "GAGAGAGAA");
		
		MowerPosition mowerPosition2 = new MowerPosition(3, 3, 'E');
		mower2 = new Mower(mowerPosition2, lawn, "AADAADADDA");
	}
	
	@Test
	void test() {
		MowerPosition finalPosition1 = mower1.executeInstructionsAndReturnPosition();
		
		MowerPosition finalPosition2 = mower2.executeInstructionsAndReturnPosition();

		assertNotNull(finalPosition1);
		assertEquals(new MowerPosition(1, 3, 'N'), finalPosition1);
		
		assertNotNull(finalPosition2);
		assertEquals(new MowerPosition(5, 1, 'E'), finalPosition2);
		
		
		
	}

}