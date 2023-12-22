
public abstract class TestQuestion 
{
	
	private int questionNumber;
	private static int nextQuestionNumber = 0;
	private String text;
	private String correctAnswer;
	
	
	/*
	 * Write a constructor which takes the test and correct
	 * answer as arguments.
	 */
	
	public TestQuestion(String text, String answer)
	{
		this.text = text;
		correctAnswer = answer;
		nextQuestionNumber++;
		questionNumber = nextQuestionNumber;
		//in main method, make it so every time a new question is made, nextQuestionNumber++;
	
	}

	/*
	 * Write a method called isCorrect which takes a
	 * student's answer as an argument and returns true
	 * if it is correct and false otherwise
	 */
	public boolean isCorrect(String answer)
	{
		if (answer.equals(correctAnswer))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * returns a string representation of the question
	 */
	public String toString()
	{
		return questionNumber + ".\t" + text;
	}
	
	/*
	 * You may need to add additional methods to this class in order
	 * to implement your sub classes.
	 * 
	 */
	public String getcorrectAnswer()
	{
		return correctAnswer;
	}
	
	public int getquestionNumber()
	{
		return questionNumber;
	}
	
	public String getText()
	{
		return text;
	}
	
	public void numerateQuestionNumber()
	{
		nextQuestionNumber++;
	}
}
