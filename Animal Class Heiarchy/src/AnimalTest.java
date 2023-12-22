import java.util.ArrayList;

public class AnimalTest 
{

	public static void main(String[] args) 
	{
		ArrayList<Animal> animals  = new ArrayList<Animal>();
		
		for (int i = 0; i<20; i++)
		{
			int num = (int)(Math.random()*4);
			switch(num)
			{
			case 0:
				animals.add(new Animal("animal"));
				break;
			case 1:
				animals.add(new Dog("dog"));
				break;
			case 2:
				animals.add(new Cat("cat"));
			case 3:
				animals.add(new Lion("Beeg cat"));
				break;
			}
		}

	}

}
