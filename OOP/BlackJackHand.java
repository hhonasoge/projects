import java.util.*;

public class BlackJackHand extends Hand<BlackJackCard> {
	public int score() {
		ArrayList<Integer> scores = possibleScores();
		int minOver = Integer.MAX_VALUE;
		int maxUnder = Integer.MIN_VALUE;
		for (int score : scores) {
			if (score<=21 && score>maxUnder) {
				maxUnder = score;
			}
			if (score > 21 && score<minOver) {
				minOver = score;
			}
		}
		return maxUnder!=Integer.MIN_VALUE ? maxUnder : minOver;
	}
	private ArrayList<Integer> possibleScores() {
		ArrayList<Integer> scores = new ArrayList<Integer>();
		for (BlackJackCard card : cards) {
			addCardToList(card, scores);
		}
		return scores;
	}
	private void addCardToList(BlackJackCard card, ArrayList<Integer> scores) {
		if (scores.size()==0) {
			scores.add(0);
		}
		int scoresLength = scores.size();
		for (int i=0; i<scoresLength; i++) {
			int score = scores.get(i);
			scores.set(i, score + card.minValue());
			if (card.isAce()) {
				scores.add(score + card.maxValue());
			}
		}
	}
}