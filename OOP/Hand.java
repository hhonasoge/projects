import java.util.*;

public class Hand<T extends Card> {
	public ArrayList<T> cards = new ArrayList<T>();
	public void addCard(T card) {
		cards.add(card);
	}
	public int score(){
		int score = 0;
		for (T card : cards){
			score+=card.value();
		}
		return score;
	}
	public void print() {
		for (T card: cards) {
			card.print();
		}
	}
}