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
	
	public boolean isWithinLimit(int x, int y) {
        return x >= 0 && x <= width && y >= 0 && y <= length;
    }

}
