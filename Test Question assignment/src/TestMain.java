import java.util.ArrayList;
import java.util.Scanner;

public class TestMain 
{

	public static void main(String[] args) 
	{
		/**
		 *  -Create an ArrayList capable of storing all questions
			-Prompt the user if they would like to create Multiple Choice or Multiple Select question
			-Prompt for text, prompt for how many answer choices there will be, create the necessary array for answers, 
			  and prompt for the answer choices
			-Create a new question with the information provided
			-Add the question to the ArrayList
			-Ask if the user would like to add another question and continue until the user is finished
			-Once done, display all created questions in the appropriate format, in order to show the user what the 
			  test looks like.
		 */
		
		//creating arrayList to hold all questions no matter the type
		ArrayList<TestQuestion> questions = new ArrayList<TestQuestion>();
		
		//creating a scanner object to take input from user 
		Scanner in = new Scanner(System.in);
		
		//creating variables to hold the input 
		String qChoice;
		String qText;
		String qAnswer;
		int numAnswerChoices;
		
		//creating String answerChoice array that can be used for both MC and MS objects
		//String answerChoices[];
		
		// going to loop until the user is finished adding questions to the test 
		boolean complete = false;
		while (! complete)
		{
			System.out.print("Would you like to add a MultipleChoice question, or a MultipleSelect question? (Enter 'mc' or 'ms') : ");
			qChoice = in.next();
			in.nextLine();
			
			if (qChoice.equals("mc"))
			{
				//add multiple choice question to questions arrayList
				System.out.print("Enter the text you want the question to have: ");
				qText = in.next();
				in.nextLine();
				
				System.out.print("Enter the number of answer choices you want to have for this question: ");
				numAnswerChoices = in.nextInt();
				in.nextLine();
				
				//creating an answerChoice array of size numAnswerChoices
				String answerChoices[] = new String[numAnswerChoices];
				
				//asking user for answer choices, then filling array with them 
				char currentLetter = 'A';
				for (int i=0; i<numAnswerChoices; i++)
				{
					System.out.print("Enter the answer choice for letter " + currentLetter + " : ");
					answerChoices[i] = in.next();
					in.nextLine();
					currentLetter++;
				}
				
				//asking user for answer
				System.out.print("Enter the answer you want for the question: ");
				qAnswer = in.next();
				in.nextLine();
				
				//now have all information. Creating a new MCQuestion object and adding it to questions ArrayList
				questions.add(new MCQuestion(qText, answerChoices, qAnswer));
				
				//having created the new object and added it to the questions arrayList, must ask user if they wish to continue
				System.out.print("Would you like to continue? (y/n): ");
				if (in.next().equals("y"))
				{
					in.next();
					complete = false;
				}
				else
				{
					in.next();
					complete = true;
				}
				
				
				
				
			}
			else
			{
				//add multiple select question to questions arrayList
				System.out.print("Enter the text you want the question to have: ");
				qText = in.next();
				in.nextLine();
				
				System.out.print("Enter the number of answer choices you want to have for this question: ");
				numAnswerChoices = in.nextInt();
				in.nextLine();
				
				//creating an answerChoice array of size numAnswerChoices
				String answerChoices[] = new String[numAnswerChoices];
				
				//asking user for answer choices, then filling array with them 
				char currentLetter = 'A';
				for (int i=0; i<numAnswerChoices; i++)
				{
					System.out.print("Enter the answer choice for letter " + currentLetter + " : ");
					answerChoices[i] = in.next();
					in.nextLine();
					currentLetter++;
				}
				
				//asking user for answer
				System.out.print("Enter the answers you want for the question (ex: 'ABC'): ");
				qAnswer = in.next();
				in.nextLine();
				
				//now have all information. Creating a new MultipleSelect object and adding it to questions ArrayList
				questions.add(new MultipleSelect(qText, answerChoices, qAnswer));
				
				//having created the new object and added it to the questions arrayList, must ask user if they wish to continue
				System.out.print("Would you like to continue? (y/n): ");
				if (in.next().equals("y"))
				{
					complete = false;
				}
				else
				{
					complete = true;
				}
				in.nextLine();
				
			}
			
			
		}
		//loop is over, user is finished adding questions to the test. Print all the questions (toString() methods) with \n in between each
		System.out.println("\n\n\n \t ****FINAL EXAM****");
		for (TestQuestion q : questions)
		{
			System.out.println(q.toString() + "\n\n");
		}
		

	}

}
