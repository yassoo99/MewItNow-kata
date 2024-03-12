package fr.tondeuse.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Lawn {

	private int width;
	private int length;

	/**
	 * Vérifie si les coordonnées spécifiées se trouvent à l'intérieur des limites
	 * de la pelouse.
	 *
	 * @param xPosition La coordonnée x à vérifier.
	 * @param yPosition La coordonnée y à vérifier.
	 * @return true si les coordonnées sont à l'intérieur des limites de la pelouse,
	 *         sinon false.
	 */
	public boolean isWithinLimit(int xPosition, int yPosition) {
		return xPosition >= 0 && xPosition <= width && yPosition >= 0 && yPosition <= length;
	}

}
