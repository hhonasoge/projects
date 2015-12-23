public class childClass extends Card {
	public childClass(Suit suit, int faceValue) {
		super(suit, faceValue);
	}
	public int value(){
		return 2;
	}
	public static void main(String[] args) {
		childClass[] child = (childClass[]) new Card[3];
		// child.test = "harsha";
		// System.out.println(child.test);
		// System.out.println(child.name);
		// parentClass parent = new parentClass("parent");
		// System.out.println(parent.name);
	}
}