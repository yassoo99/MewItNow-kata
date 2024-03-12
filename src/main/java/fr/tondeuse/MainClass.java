package fr.tondeuse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.tondeuse.model.Lawn;
import fr.tondeuse.model.Mower;
import fr.tondeuse.model.MowerPosition;

public class MainClass {

	public static void main(String[] args) {
		List<Mower> mowers = loadMowersFromFile("input.txt");
		if (mowers != null) {
			mowers.forEach(mower -> {
				MowerPosition p = mower.executeInstructionsAndReturnPosition();
				System.out.println(p.toString());
			});
		} else {
			System.err.println("Erreur lors de la lecture du fichier");
		}
	}

	/**
	 * Méthode de traitement du fichier input.txt qui contien les instructions des
	 * mouvements de la tondeuse, ainsi que les limites de la pelouse
	 * 
	 * @param fileUrl : le chemin du fichier input.txt
	 * @return List<Mower> : une liste de tondeuse
	 */
	public static List<Mower> loadMowersFromFile(String fileUrl) {
		List<Mower> mowers = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(fileUrl))) {
			String line = reader.readLine();
			if (line != null) {
				String[] lawnLimit = line.split(" ");
				int maxX = Integer.parseInt(lawnLimit[0]);
				int maxY = Integer.parseInt(lawnLimit[1]);

				Lawn lawn = new Lawn(maxX, maxY);

				while ((line = reader.readLine()) != null) {
					String[] mowerInfo = line.split(" ");
					int x = Integer.parseInt(mowerInfo[0]);
					int y = Integer.parseInt(mowerInfo[1]);
					char orientation = mowerInfo[2].charAt(0);

					MowerPosition mp = new MowerPosition(x, y, orientation);

					String instructions = reader.readLine();

					Mower mower = new Mower(mp, lawn, instructions);
					mowers.add(mower);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		return mowers;

	}

}
