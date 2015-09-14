public class Card {
	private Suit suit;
	private int faceValue;
	public Card(Suit suit, int faceValue) {
		this.suit = suit;
		if (faceValue>0 && faceValue < 14) {
			this.faceValue = faceValue;
		}
	}
	public Suit getSuit() {
		return suit;
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
		Card firstCard = new Card(Suit.Club, 12);
		firstCard.print();
	}

}