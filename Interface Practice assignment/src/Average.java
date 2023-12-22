import java.util.ArrayList;

public class Average 
{
	public static double getAverage(ArrayList<Measurable> list)
	{
		double total = 0;
		
		for (Measurable item : list)
		{
			total += (double)(item.getMeasure());
		}
		return total / list.size();
	}
}
