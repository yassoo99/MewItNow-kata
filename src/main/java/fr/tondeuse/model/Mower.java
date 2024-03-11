package fr.tondeuse.model;

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
	private Lawn lawn;
	private String instructions;
	
	public MowerPosition executeInstructionsAndReturnPosition() {
		for (char instruction : instructions.toCharArray()) {
			execute(instruction);
		}
		return currentPosition;
	}
	
    private void execute(char instruction) {
        if (instruction == 'D' || instruction == 'G' ) {
        	turn(instruction);
        }  else if (instruction == 'A') {
            move();
        }
    }

    private void turn(char instruction) {
    	
    	boolean isRight = (instruction == 'D');
        switch (currentPosition.getOrientation()) {  
        	case 'N':
                currentPosition.setOrientation(isRight ? 'E':'W');
                break;
            case 'E':
            	currentPosition.setOrientation(isRight ? 'S':'N');
                break;
            case 'S':
            	currentPosition.setOrientation(isRight ? 'W':'E');
                break;
            case 'W':
            	currentPosition.setOrientation(isRight ? 'N':'S');
                break;
        }
    }

    private void move() {
    	int cw = currentPosition.getCurrentWidthPosition();
    	int cl = currentPosition.getCurrentLengthPosition();
        switch (currentPosition.getOrientation()) {
            case 'N':
                if (lawn.isWithinLimit(cw, cl + 1)) currentPosition.setCurrentLengthPosition(cl+1);
                break;
            case 'E':
                if (lawn.isWithinLimit(cw + 1, cl)) currentPosition.setCurrentWidthPosition(cw + 1);
                break;
            case 'S':
                if (lawn.isWithinLimit(cw, cl - 1)) currentPosition.setCurrentLengthPosition(cl-1);
                break;
            case 'W':
                if (lawn.isWithinLimit(cw - 1, cl)) currentPosition.setCurrentWidthPosition(cw - 1);
                break;
        }
    }

}
