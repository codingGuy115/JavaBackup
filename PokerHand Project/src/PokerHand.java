
public class PokerHand 
{
	
	/*
	 * This field represents the cards in a player's hand
	 */
	private Card[] hand = new Card[5];
	
	
	
	/*
	 * TODO Create a constructor which takes no arguments and initializes
	 * the hand (our hand always has five cards) to an Ace of hearts, 
	 * King of hearts, Queen of hearts, Jack of hearts, and 10 of hearts.  
	 * This is a royal flush
	 *
	 */
	public PokerHand()
	{
		
		Card AH = new Card('H', "A", 14);
		hand[0] = AH;
		
		Card KH = new Card('H', "K", 13);
		hand[1] = KH;
		
		Card QH = new Card('H', "Q", 12);
		hand[2] = QH;
		
		Card JH = new Card('H', "J", 11);
		hand[3] = JH;
		
		Card tenH = new Card('H', "10", 10);
		hand[4] = tenH;
		
		
	
	}

	
	/* 
	 * TODO Create a constructor which takes an array of 5 Cards 
	 * as an argument and initializes the hand to the five cards 
	 * passed.
	 * 
	 */
	public PokerHand(Card[] cards)
	{
		for (int i = 0; i < 5; i++)
		{
			hand[i] = cards[i];
		}
	}
	
	
	
	/**
	 * This method sortHandByValue will put your cards in order
	 * from smallest to largest.  It is private and can only be
	 * called in this class.  It may prove useful for you.
	 */
	private void sortHandByValue()
	{
		for(int i = 0; i < hand.length; i++)
		{
			int index = i;
			int minVal = hand[i].getValue();
			for(int j = i+1; j < hand.length; j++)
			{
				if(hand[j].getValue()< minVal)
				{
					index = j;
					minVal = hand[j].getValue();
				}
			}
			Card temp = hand[i];
			hand[i] = hand[index];
			hand[index] = temp;
		}
	}
	
	
	/*
	 * TODO write a method called getBestHand (sorting will help)
	 * this method will take no arguments and will return a String 
	 * identifying the best hand which can be made.  The possible hands 
	 * and return values are as follows. These are in order of precedence
	 * (the ones at the top are the best hands).
	 * return "Royal Flush" if all cards in the hand are the same
	 * 	  suit and the card ranks are A, K, Q, J, 10
	 * return "Straight Flush" if all cards are in the same suit
	 *    and the cards are all in consecutive order by value
	 *    ex.  7H, 8H, 9H, 10H, JH
	 * return "Four of a Kind" if there are four matching cards in hand
	 * 	  ex.  9D, 9H, 9S, 9C, 10D
	 * return "Flush" if all cards are the same suit.  Rank does
	 *    not matter.  Ex.  3S, 7S, 10S, KS, AS
	 * return "Straight" if all cards are in consecutive order
	 *    by value, but not the same suit.  Ex. 4H, 5C, 6H, 7D, 8S
	 * return "Full House" if there are a set of three matching
	 *    ranks and a separate set of two matching ranks.  
	 *    Ex. 4H, 4C, JD, JH, JS
	 * return "Three of a Kind" if there are three cards with the same
	 *    rank.  Ex 5C, 9H, QC, QH, QD
	 * return "Two Pair" if there are two pairs of cards with matching ranks
	 *    Ex.  5H, 5D, 10H, 10C, KC
	 * return "Pair" if there are two matching ranks.  
	 *    Ex. 3D, 5D, 5H, KC, AH
	 * return "High (rank of highest card)" if none of the others apply
	 * 	  Ex.  3D, 6H, 10S, JD, QD would return "High Q"
	 */
	
	public String getBestHand()
	{
		//ROYAL FLUSH
		//royal flush check- all cards same suit and valueTotal == 60
		boolean executeHigh = true;
		
		String result = "";
		sortHandByValue();
		Card currentCard;
		int valueTotal = 0;
		String suitTotal = "";
		
		for (int i = 0; i < 5; i++)
		{
			valueTotal += hand[i].getValue();
			suitTotal += hand[i].getSuit();
		}
		boolean allSameSuit = true;
		//variable to store suit (char) from first card
		char suitCheck = hand[0].getSuit();
		for (int i = 0; i<5; i++)
		{
			if (hand[i].getSuit() != suitCheck)
			{
				allSameSuit = false;
			}
		}
		//the final test to see whether the values added up to 60 and they are all the same suit
		if (valueTotal == 60 && allSameSuit)
		{
			result = "Royal Flush";
			executeHigh = false;
			return result;
		}
		
		//STRAIGHT FLUSH
		//return "Straight Flush" if all cards are in the same suit and the cards are all in consecutive order by value ex.  7H, 8H, 9H, 10H, JH
		//checking suit condition
		allSameSuit = true;
		for (int i = 0; i<5; i++)
		{
			if (hand[i].getSuit() != suitCheck)
			{
				allSameSuit = false;
			}
		}
		//checking to make sure the VALUES are all in consecutive order
		int valueCheck = hand[0].getValue();
		boolean allConsecutiveValue = true;
		for (int i = 1; i<5; i++)
		{
			valueCheck ++;
			if (hand[i].getValue() != valueCheck)
			{
				allConsecutiveValue = false;
			}
		}
		//final test
		if (allSameSuit && allConsecutiveValue)
		{
			result = "Straight Flush";
			executeHigh = false;
			return result;
		}
		
		//FOUR OF A KIND
		/*
		 * return "Four of a Kind" if there are four matching cards in hand
	 * 	  ex.  9D, 9H, 9S, 9C, 10D
		 */
		//has to be in order, either from index 0-3 or index 1-4
		
		
		
		
		valueCheck = hand[0].getValue();
		int sameVal1 = 0;
		int sameVal2 = 0;
		boolean allSame = true;
		
		for (int i = 0; i<5; i++)
		{
			if (hand[i].getValue() != valueCheck)
			{
				allSame = false;
			}
		}
		//index 0-3
		if (allSame)
		{
			System.out.println("all the same");
		}
		else
		{
			for (int i = 1; i<5; i++)
			{
				if (hand[i].getValue() == valueCheck)
				{
					sameVal1 ++;
				}
				
			}
			
			valueCheck = hand[1].getValue();
			for (int i = 1; i<5; i++)
			{
				if (hand[i].getValue() == valueCheck)
				{
					sameVal2 ++;
				}
		
			}
			
			if (sameVal1 == 4 || sameVal2 == 4)
			{
				result = "Four of a Kind";
				return result;
			}
		}
		
		
		
		//FLUSH
		//cards must all be the same suit
		allSameSuit = true;
		suitCheck = hand[0].getSuit();
		for (int i = 0; i<5; i++)
		{
			if (hand[i].getSuit() != suitCheck)
			{
				allSameSuit = false;
			}
		}
		if (allSameSuit)
		{
			result = "Flush";
			executeHigh = false;
			return result;
		}
		
		//STRAIGHT
		//cards are in consecutive order by value, nothing else matters
		
		allConsecutiveValue = true;
		valueCheck = hand[0].getValue();
		for (int i = 1; i<5; i++)
		{
			valueCheck ++;
			if (hand[i].getValue() != valueCheck)
			{
				allConsecutiveValue = false;
			}
		}
		if (allConsecutiveValue)
		{
			result = "Straight";
			executeHigh = false;
			return result;
		}
		
		//FULL HOUSE
		/*
		 *  return "Full House" if there are a set of three matching
	 *    ranks and a separate set of two matching ranks.  
	 *    Ex. 4H, 4C, JD, JH, JS
		 */
		int firstValue = hand[0].getValue();
		int thirdValue = hand[2].getValue();
		int fourthValue = hand[3].getValue();
		
		boolean first2Same = false;
		boolean last3Same = false;
		
		boolean first3Same = false;
		boolean last2Same = false;
		
		//first test, first 2 must be same and last 3 must be same, but different values (hand[1].getValue == firstValue)
		if (hand[1].getValue() == firstValue)
		{
			first2Same = true;
		}
		if (hand[3].getValue() == thirdValue && hand[4].getValue() == thirdValue)
		{
			last3Same = true;
		}
		
		//second test, first 3 must be same and last 2 must be same, but different values (hand[1].getValue == firstValue)
		if (hand[1].getValue() == firstValue && hand[2].getValue() == firstValue)
		{
			first3Same = true;
		}
		if (hand[4].getValue() == fourthValue)
		{
			last2Same = true;
		}
		
		//variable to make sure first and third values are different, as well as first and fourth
		boolean fHousePossible = true;
		if (firstValue == thirdValue)
		{
			fHousePossible = false;
		}
		if (firstValue == fourthValue)
		{
			fHousePossible = false;
		}
		
		//final test to see if full house should be returned
		if (! fHousePossible)
		{
			
		}
		else
		{
			if (first2Same && last3Same)
			{
				result = "Full House";
				return result;
			}
			else if(first3Same && last2Same)
			{
				result = "Full House";
				return result;
			}
		}
		
		//THREE OF A KIND
		/*
		 * return "Three of a Kind" if there are three cards with the same
	 *    rank.  Ex 5C, 9H, QC, QH, QD
		 */
		//has to be in order, either from index 0-2, index 1-3, index 2-4
		
		valueCheck = hand[0].getValue();
		sameVal1 = 0;
		sameVal2 = 0;
		int sameVal3 = 0;
		allSame = true;
		
		for (int i = 0; i<5; i++)
		{
			if (hand[i].getValue() != valueCheck)
			{
				allSame = false;
			}
		}
		
		if (allSame)
		{
			
		}
		else
		{
			//index 0-2
			for (int i = 0; i<5; i++)
			{
				if (hand[i].getValue() == valueCheck)
				{
					sameVal1 ++;
				}
				
			}
			
			//index 1-3
			valueCheck = hand[1].getValue();
			for (int i = 1; i<5; i++)
			{
				if (hand[i].getValue() == valueCheck)
				{
					sameVal2 ++;
				}
		
			}
			
			//index 2-4
			valueCheck = hand[2].getValue();
			for (int i = 2; i<5; i++)
			{
				if (hand[i].getValue() == valueCheck)
				{
					sameVal3 ++;
				}
		
			}
			
			int total = sameVal1 + sameVal2 + sameVal3;
			if (total == 5 || total == 6 || total == 7)
			{
				
				result = "Three of a Kind";
				return result;
			}
		}
		
		
		
		//TWO PAIR
		/*
		 * return "Two Pair" if there are two pairs of cards with matching ranks
	 *    Ex.  5H, 5D, 10H, 10C, KC
		 */
		int uPairs = 0;
		boolean allSameValue = true;
		valueCheck = hand[0].getValue();
		for (int i = 0; i<5; i++)
		{
			if (hand[i].getValue() == valueCheck)
			{
				allSameValue = false;
			}
			
		}
		if (allSameValue)
		{
			
		}
		else
		{
			for (int i = 0; i<4; i++)
			{
				for (int j = i+1; j<5; j++)
				{
					if (hand[i].getValue() == hand[j].getValue())
					{
						uPairs ++;
						if (i +2 <= 4)
						{
							i += 2;
							j +=1;
						}
					}
				}
			}
			if (uPairs == 2)
			{
				result = "Two Pair";
				executeHigh = false;
				return result;
			}
		}
		
		//PAIR
		/*
		 *return "Pair" if there are two matching ranks.  
	 *    Ex. 3D, 5D, 5H, KC, AH 
		 */
		boolean pair = false;
		boolean contChecking = true;
		//checking the first three possibilities
		for (int i = 0; i<3; i++)
		{
			if (pair)
			{
				contChecking = false;
			}
			if (contChecking && hand[i].getValue() == hand[i + 1].getValue() && hand[i+1].getValue() != hand[i+2].getValue())
			{
				pair = true;
			}
		}
		if (pair)
		{
			result = "Pair";
			executeHigh = false;
			return result;
		}
		else
		{
			if (hand[3].getValue() == hand[4].getValue())
			{
				pair = true;
				
			}
			if (pair)
			{
				result = "Pair";
				executeHigh = false;
				return result;
			}
		}
		
		//HIGH
		/*
		 *return "High (rank of highest card)" if none of the others apply
	 * 	  Ex.  3D, 6H, 10S, JD, QD would return "High Q" 
		 */
		
		if (executeHigh)
		{
			result = "High " + hand[4].getRank();
			return result;
		}
		else
		{
			return null;
		}
	}
	
	
	/*
	 * TODO write a toString method which returns a string containing
	 * the rank and suit of every card in the hand, separated by a comma
	 * Ex.  3D, 4D, 4D, 8S, KH
	 */
	public String toString()
	{
		String result = "";
		sortHandByValue();
		Card currentCard;
		
		for (int i = 0; i < 5; i++)
		{
			currentCard = hand[i];
			result += currentCard.getRank() + currentCard.getSuit() + ", ";
		}
		return result;
	}
	
	
	/*
	 * TODO Write a method called discard.  The goal of this method is 
	 * to choose cards to discard and replace with new cards.  The 
	 * method should take two arguments, 
	 * the first will be an int array which will store the indexes of 
	 * hand which are to be replaced, and the second is a Card array 
	 * which will contain the new cards to be placed into hand.
	 * Ex.  hand contains 4H,4D,4C,JS,KC  
	 * 		given int[] arr = {3,4};
	 * 		and Card[] cards = {4S,AD} //using shorthand to demonstrate
	 * 		after discard(arr,cards);
	 * 		hand would now contain 4H,4D,4C,4S,AD
	 * 
	 */
	public void discard(int[] intArr, Card[] newCards)
	{
		sortHandByValue();
		
		for (int i = 0; i < 2; i++)
		{
			hand[intArr[i]] = newCards[i];
		}
	}
	
	
	
	
	
	
}
