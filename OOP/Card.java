public abstract class Card {
	public Suit suit;
	public int faceValue;
	private boolean available = true;
	public Card(Suit suit, int faceValue) {
		this.suit = suit;
		if (faceValue>0 && faceValue < 14) {
			this.faceValue = faceValue;
		}
	}
	public abstract int value();
	public Suit getSuit() {
		return suit;
	}
	public void markUnavailable() {
		available = false;
	}
	
	public void markAvailable() {
		available = true;
	}
	public int getfaceValue() {
		return faceValue;
	}
	public void print() {
		String[] faceValues = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		System.out.println(faceValues[faceValue - 1]);
		switch(suit) {
			case Club:
				System.out.println("Club");
				break;
			case Spade:
				System.out.println("Spade");
				break;
			case Heart:
				System.out.println("Heart");
				break;
			case Diamond:
				System.out.println("Diamond");
				break;
		}
	}
	public static void main(String[] args) {
		// Card firstCard = new Card(Suit.Club, 12);
		// firstCard.print();
	}

}