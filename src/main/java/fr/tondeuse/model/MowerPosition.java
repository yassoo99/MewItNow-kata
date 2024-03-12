package fr.tondeuse.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MowerPosition {

	private int currentWidthPosition;
	private int currentLengthPosition;
	private char orientation;

	/**
	 * Méthode toString qui affiche les différentrs information de la class
	 * MowerPosition
	 */
	@Override
	public String toString() {
		return currentWidthPosition + " " + currentLengthPosition + " " + orientation;
	}

}
