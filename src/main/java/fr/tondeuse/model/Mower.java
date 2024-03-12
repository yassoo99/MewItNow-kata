package fr.tondeuse.model;

import fr.tondeuse.service.MowerInstructionExecutor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mower {

	private MowerPosition currentPosition;
	private MowerInstructionExecutor instructionExecutor;

	public Mower(MowerPosition currentPosition, Lawn lawn, String instructions) {
		this.currentPosition = currentPosition;
		this.instructionExecutor = new MowerInstructionExecutor(currentPosition, lawn, instructions);
	}

	public MowerPosition executeInstructionsAndReturnPosition() {
		return instructionExecutor.executeInstructionsAndReturnPosition();
	}

}
