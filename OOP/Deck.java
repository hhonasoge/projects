import java.util.*;
import java.awt.*;

public class Deck <T extends Card> {
	public ArrayList<T> cards;
	private int dealtIndex = 0;
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}

	public static int randomIntInRange(int min, int max) {
		return randomInt(max + 1 - min) + min;
	}
	public void setDeckOfCards(ArrayList<T> deck) {
		cards = deck;
	}
	public void shuffle() {
		for (int i = 0; i<cards.size(); i++) {
			int j = randomIntInRange()
		}
	}


}