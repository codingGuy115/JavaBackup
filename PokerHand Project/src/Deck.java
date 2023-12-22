import java.util.Collections;

public class Deck 
{
	
	/*
	 * TODO create a Card array field which represents the cards
	 * in the deck.   Also create an int field called nextToDeal
	 * which will identify the next index to deal. This field will
	 * start at 0 and will be incremented each time a card is "dealt".
	 * when nextToDeal = the length of cards, there are no cards left
	 * to deal
	 * 
	 */
	private Card[] cards = new Card[52];
	private int nextToDeal = 0;
	
	/*
	 * TODO create a deck constructor which requires no arguments.
	 * The constructor will generate a standard deck of playing
	 * cards. The values of the playing cards will be from 2-14 where
	 * a rank of "2" has a value of 2 and a rank of "A" has a value 
	 * of 14.
	 * 
	 * I suggest creating arrays for all possible values, ranks, and
	 * suits.   You can then use two nested for loops to create the deck
	 * 
	 */
	/*
	 * private char suit;
	private String rank;
	private int value;
	 */
	char[] suits = {'S', 'C', 'D', 'H'};
	String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
	int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
	
	int counter = 0;
	
	public Deck()
	{
		for (int i = 0; i<4; i++)
		{
			for (int j = 0; j<13; j++)
			{
				cards[counter] = new Card(suits[i], rank[j], values[j]);
				counter ++;
			}
		}
	}
	
	
	/*
	 * TODO create a method called shuffle which will arrange all cards
	 * in the array cards in a random order and reset nextToDeal to zero.
	 * 
	 */
	public void shuffle()
	{
		Card temp;
		int newIndex = 0;
		
		for (int i = 0; i<52; i++)
		{
			temp = cards[i];
			newIndex = (int)(Math.random() *52 + 0);
			cards[i] = cards[newIndex];
			cards[newIndex] = temp;
				
		}
		
		
		nextToDeal = 0;
	}
	
	/*
	 * TODO create a method called deal which takes no arguments. 
	 * it should return the card at nextToDeal and increment the field
	 * nextToDeal.  If there are no cards left to deal, return null.
	 */
	public Card deal()
	{
		if (nextToDeal == 5)
		{
			return null;
		}
		else
		{
			nextToDeal += 1;
			return cards[nextToDeal];
		}

	}
	
}
