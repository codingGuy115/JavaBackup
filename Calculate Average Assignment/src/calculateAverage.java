import java.util.Scanner;

public class calculateAverage 
{

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter a name of a course: ");
		String courseName = in.next();
		in.nextLine(); //must do this step to get rid of the newline
		
		//gathering input about test names 1-3 and score for each 
		System.out.print("Enter a name of the first test: ");
		String test1 = in.next();
		in.nextLine(); //must do this step to get rid of the newline
		System.out.print("Enter score for test1: ");
		double score1 = in.nextDouble();
		in.nextLine();
		
		System.out.print("Enter a name of the second test: ");
		String test2 = in.next();
		in.nextLine(); //must do this step to get rid of the newline
		System.out.print("Enter score for test2: ");
		double score2 = in.nextDouble();
		in.nextLine();
		
		System.out.print("Enter a name of the third test: ");
		String test3 = in.next();
		in.nextLine(); //must do this step to get rid of the newline
		System.out.print("Enter score for test3: ");
		double score3 = in.nextDouble();
		in.nextLine();
		
		
		//calculating average 
		double average = (score1 + score2 + score3) / 3;
		
		//printing data to console
		System.out.println("Course name: " + courseName);
		
		System.out.println("First Assesment name: " + test1);
		System.out.println("First score: " + score1);
		System.out.println("Second Assesment name: " + test2);
		System.out.println("Second score: " + score2);
		System.out.println("Third Assesment name: " + test3);
		System.out.println("Third score: " + score3);
		
		System.out.println(courseName + " Average of " + test1 + ", " + test2 + ", and " + test3 + ": " + average);
		
		

	}

}
