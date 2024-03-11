package fr.tondeuse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.tondeuse.model.Lawn;
import fr.tondeuse.model.Mower;
import fr.tondeuse.model.MowerPosition;

public class MainClass {

	public static void main(String[] args) {

		List<Mower> mowers = new ArrayList<>();

		try {
			String filePath = MainClass.class.getClassLoader().getResource("input.txt").getFile();

			File file = new File(filePath);
			Scanner scanner = new Scanner(file);

			int maxX = scanner.nextInt();
			int maxY = scanner.nextInt();

			Lawn lawn = new Lawn(maxX, maxY);

			scanner.nextLine();

			while (scanner.hasNext()) {

				int x = scanner.nextInt();
				int y = scanner.nextInt();
				char orientation = scanner.next().charAt(0);
				scanner.nextLine();
				MowerPosition mp = new MowerPosition(x, y, orientation);

				String instructions = scanner.nextLine();

				Mower mower = new Mower(mp, lawn, instructions);
				mowers.add(mower);
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		mowers.forEach(mower -> {
			MowerPosition p = mower.executeInstructionsAndReturnPosition();
			System.out.println(p.toString());
		});

	}

}
