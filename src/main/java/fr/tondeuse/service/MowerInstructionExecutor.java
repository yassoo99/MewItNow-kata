package fr.tondeuse.service;

import fr.tondeuse.model.Lawn;
import fr.tondeuse.model.MowerPosition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MowerInstructionExecutor {
	private MowerPosition currentPosition;
	private Lawn lawn;
	private String instructions;

	/**
	 * Exécute les instructions spécifiées pour déplacer la tondeuse et renvoie sa
	 * position finale.
	 *
	 * @return La position finale de la tondeuse après avoir exécuté toutes les
	 *         instructions.
	 */
	public MowerPosition executeInstructionsAndReturnPosition() {
		for (char instruction : instructions.toCharArray()) {
			execute(instruction);
		}
		return currentPosition;
	}

	/**
	 * Exécute une instruction spécifique pour déplacer la tondeuse.
	 *
	 * @param instruction L'instruction à exécuter ('D' pour tourner à droite, 'G'
	 *                    pour tourner à gauche, 'A' pour avancer).
	 */
	private void execute(char instruction) {
		if (instruction == 'D' || instruction == 'G') {
			turn(instruction);
		} else if (instruction == 'A') {
			move();
		}
	}

	/**
	 * Méthode qui sert à tourner la tondeuse vers la guauche ou la droite en
	 * fonction de l'instruction spécifiée
	 * 
	 * @param instruction
	 */
	private void turn(char instruction) {

		boolean isRight = (instruction == 'D');
		switch (currentPosition.getOrientation()) {
		case 'N':
			currentPosition.setOrientation(isRight ? 'E' : 'W');
			break;
		case 'E':
			currentPosition.setOrientation(isRight ? 'S' : 'N');
			break;
		case 'S':
			currentPosition.setOrientation(isRight ? 'W' : 'E');
			break;
		case 'W':
			currentPosition.setOrientation(isRight ? 'N' : 'S');
			break;
		}
	}

	/**
	 * Méthode de déplacement de la tondeuse vers l'avant en fonction de son
	 * orientation actuelle. On vérifie avant de d'avancer la position par rapport
	 * aux limite de la pelouse Si on a pas encore atteint la limite on avant de 1
	 * sinon on ne bouge pas
	 */
	private void move() {
		int currentWidth = currentPosition.getCurrentWidthPosition();
		int currentLength = currentPosition.getCurrentLengthPosition();
		switch (currentPosition.getOrientation()) {
		case 'N':
			if (lawn.isWithinLimit(currentWidth, currentLength + 1))
				currentPosition.setCurrentLengthPosition(currentLength + 1);
			break;
		case 'E':
			if (lawn.isWithinLimit(currentWidth + 1, currentLength))
				currentPosition.setCurrentWidthPosition(currentWidth + 1);
			break;
		case 'S':
			if (lawn.isWithinLimit(currentWidth, currentLength - 1))
				currentPosition.setCurrentLengthPosition(currentLength - 1);
			break;
		case 'W':
			if (lawn.isWithinLimit(currentWidth - 1, currentLength))
				currentPosition.setCurrentWidthPosition(currentWidth - 1);
			break;
		}
	}
}
