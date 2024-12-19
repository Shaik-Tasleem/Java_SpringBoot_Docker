package enums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

enum Rank{
	 ACE, TWO, THREE, FOUR, FIVE, SIX,
	 SEVEN, EIGHT, NINE, TEN, JACK, 
	 QUEEN, KING
}
enum Suit{
	HEARTS, DIAMONDS, CLUBS, SPADES
}
class gett{
	private  Rank rank ;
	private Suit suit;
	public gett(Rank rank,Suit suit) {
		this.rank=rank;
		this.suit=suit;
	}
	@Override
	public String toString() {
		return "gett [rank=" + rank + ", suit=" + suit + "]";
	}
	
	
}
public class deck {
 public static void main(String[] args) {
	 List<gett> deck = new ArrayList<>();
	 for(Rank rank:Rank.values()) {
		 for(Suit suit:Suit.values()) {
			 deck.add(new gett(rank,suit));
		 }
		 
	 }
	 System.out.println("original deck");
	 deck.forEach(System.out::println);
	 Collections.shuffle(deck);
	 System.out.println("after shuffling");
	 deck.forEach(System.out::println);
}
}
     