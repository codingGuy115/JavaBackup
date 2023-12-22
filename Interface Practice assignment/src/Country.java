
public class Country implements Measurable
{
	private int population;
	
	public Country(int population)
	{
		this.population = population;
	}

	@Override
	public int getMeasure() 
	{
		return population;
	}

}
