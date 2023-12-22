
public class MultipleSelect extends TestQuestion 
{

	private String[] answerChoices;
	
	
	/**
	 * Write a constructor for MultipleSelect which takes
	 * a string for the text, an array of Strings for answer choices
	 * and a string for the correct answer.  The answer should be formatted
	 * such that the corresponding letter for each correct answer choice
	 * is in the String.  So if A, B, and E are correct selections for a
	 * question, the answer can be "ABE", "BAE", "EBA", "EAB", or any other
	 * combination.
	 * 
	 */
	public MultipleSelect(String text, String[] answerChoices, String answer) 
	{
		//Need to call superclass constructor because thats where the fields 'text' and 'answer' come from 
		super(text, answer);
		//now need to initialize answerChoices field, as it is a unique field of MultipleSelect subclass
		this.answerChoices = answerChoices;
		
		
		
		
	}
	
	
	
	
	/**
	 * Override the toString method to display the question in the
	 * form:
	 * 
	 * 2.   This is the text for question number 2.
	 * 		Select ALL correct answer choices as more than one may be correct:
	 * 
	 * 		A. answer choice one
	 * 		B. answer choice two
	 * 		C. answer choice three
	 * 		D. answer choice four
	 * 
	 * Keep in mind there are no restrictions on the number of answer
	 * choices.  Your method should work no matter the answer array.
	 * As a reminder, you may increment a char using ++ as it is primitive.
	 */
	
	public String toString()
	{
		String result = "";
		result += super.toString() + "\n \t Select ALL correct answer choices as more than one may be correct:\n\n";
		//char var to keep track of current letter for the answer choices
		char currentLetter = 'A';
		for (int i = 0; i<answerChoices.length; i++)
		{
			result += "\t" + currentLetter + ". " + answerChoices[i] + "\n";
			currentLetter++;
		}
		
		return result;
		
		
	}
	
	
	
	/**
	 * Override the inherited isCorrect method which takes a
	 * student's answer as an argument and returns true
	 * if it is correct and false otherwise.  Keep in mind that
	 * the answer choices can be supplied in any order, so an
	 * answer "BAC" would be correct given a correct answer of
	 * "CBA".  Be sure to consider what you have access to from
	 * your super class.
	 *  
	 */
	public boolean isCorrect(String answer)
	{
		String realCorrectAnswer = super.getcorrectAnswer();
		String currentLetter = "";
		for (int i = 0; i<realCorrectAnswer.length(); i++)
		{
			currentLetter = realCorrectAnswer.substring(i, i+1);
			if (! answer.contains(currentLetter))
			{
				return false;
			}
		}
		//for loop over, all letters should be valid
		return true;
		
	}
	
	

}
