public class BlackJackCard extends Card {
	public BlackJackCard(Suit suit, int faceValue) {
		super(suit, faceValue);
	}
	public int value() {
		if (isAce()) {
			return 1;
		} else if (faceValue>10 && faceValue < 14) {
			return 10;
		} else {
			return faceValue;
		}
	}
	public int maxValue() {
		if (isAce()) {
			return 11;
		}
		return faceValue;
	}
	public int minValue() {
		return faceValue;
	}
	public boolean isAce() {
		return this.getfaceValue() == 1;
	}
}