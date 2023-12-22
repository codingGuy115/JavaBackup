import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class g_address_thing 
{

	public static void main(String[] args) 
	{
		// You are going to use a scanner to read each word of the Gettysburg address and add each word to an ArrayList of Strings.
		//Evaluate and remove punctuation before adding words to array list. 
		//The program should then identify the longest word in the address, as well as the average word length.   
		//Do not include punctuation in word length!  Look at the text file carefully to see what punctuation you need to consider.  
		//Some of the Strings you read will need to be added to your list as two different words.  
		
		String fileName= "GettysburgAddress.txt";
		Scanner file = null;
		
		try 
		{
			file = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//START HERE
		
		//making the arrayList of String objects
		ArrayList<String> words = new ArrayList<String>();
		
		String word;
		String wordWithoutLastChar;
		//making loop to read the file
		while(file.hasNext())
		{
			word = file.next();
			if (word.charAt(word.length()-1) == ',' || word.charAt(word.length()-1) == '.')
			{
				//if this executes, must add new string to 'words' without last character
				wordWithoutLastChar = word.substring(0, word.length()-1);
				words.add(wordWithoutLastChar);
				
			}
			else
			{
				words.add(word);
			}
			
			
		}
		
		//file has been read, words minus punctuation put into arrayList, now must find longest word and av word length
		String longestWord = words.get(0);
		int wordLengthTotal = 0;
		String currentWord;
		
		for (int i = 0; i<words.size() - 1; i++)
		{
			currentWord = words.get(i);
			
			//System.out.println(currentWord);
			
			wordLengthTotal += currentWord.length();
			//checking if currentWord length is larger than longestWord
			
			//System.out.println("Current word length: " + currentWord.length());
			//System.out.println("Longest word length: " + longestWord.length());
			
			if (currentWord.length() > longestWord.length());
			{
				longestWord = currentWord;
				//System.out.println("Longest word: " + longestWord);
			}
		}
		
		//loop over, longestWord should be acquired, now must divide wordLengthTotal by words.size();
		
		double avWordLength = 1.0 * wordLengthTotal / words.size();
		
		System.out.println("Longest word: " + longestWord + " \nAverage Word Length: " + avWordLength);
		
		//everything should be done, so close to avoid resource leak
		file.close();

	}

}
