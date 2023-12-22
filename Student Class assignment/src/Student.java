public class Student 
{
	//fields 
	private String name;
	private String address;
	private int gradeLevel;
	private double pointsEarned;
	private double pointsTotal;
	private int numAssignments;
	
	
	//constructors (different ways to create an object of this class, w/ different arguments)
	//constructor that sets pointsEarned, pointsTotal, and numAssignments to 0
	public Student()
	{
		name = "NO NAME";
		address = "NO ADDRESS";
		gradeLevel = 0;
		pointsEarned = 0.0;
		pointsTotal = 0.0;
		numAssignments = 0;
		
	}
	
	//constructor that takes all data as arguments 
	public Student(String n, String addr, int gLevel, double pEarned, double pTotal, int numA)
	{
		name = n;
		address = addr;
		gradeLevel = gLevel;
		pointsEarned = pEarned;
		pointsTotal = pTotal;
		numAssignments = numA;
		
	}
	
	
	//methods  
	//set of methods to get name, gradeLevel, address, numAssignments
	public String getName()
	{
		return name;
		
	}
	
	public String getAddress()
	{
		return address;
		
	}
	
	public int getGradeLevel()
	{
		return gradeLevel;
		
	}
	
	public int numAssignments()
	{
		return numAssignments;
		
	}
	
	//average
	public double average()
	{
		return pointsTotal / numAssignments;
		
	}
	
	//add an assignment score to the points earned and total points
	public void addScore(double score)
	{
		pointsEarned += score;
		pointsTotal += score;
		
	}
	
	//increment grade level.   Simply add one to current grade level.
	public void incGradeLevel()
	{
		gradeLevel += 1;
		
	}

	//reset all score data with one method call including number of assignments
	public void reset()
	{
		pointsEarned = 0.0;
		pointsTotal = 0.0;
		numAssignments = 0;
		
	}
	
	//set the address to a new address given as an argument
	public void setAddress(String newAddress)
	{
		address = newAddress;
		
	}
	
	//write a good toString method
	public String toString()
	{
		return "Name: " + name + " Address: " + address + " Grade Level: " + gradeLevel + " Points Earned: " + pointsEarned + " Points Total: " + pointsTotal +  " Number of Assignments: " + numAssignments;
		
	}
	
	
}