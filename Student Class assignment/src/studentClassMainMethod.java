
public class studentClassMainMethod 
{

	public static void main(String[] args) 
	{
		//testing constructors
		Student s1 = new Student();
		Student s2 = new Student("Nick", "204 Pine Drive", 10, 100.0, 200.0, 2);
		
		// testing methods
		System.out.println("Field values for s1: " + s1.toString());
		System.out.println("Field values for s2: " + s2.toString());
		
		s1.setAddress("100 Great Valley");
		System.out.println("s1 address: " + s1.getAddress());
		
		System.out.println("s2 average: " + s2.average());
		

	}

}
