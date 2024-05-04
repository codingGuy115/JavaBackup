
public class Node 
{
	private boolean visited;
	private int ID;
	private int status;
	private int row;
	private int col;
	private boolean usedInPath;
	
	public Node(int ID, int row, int col)
	{
		visited = false;
		status = 0;
		this.ID = ID;
		this.row = row;
		this.col = col;
		setUsedInPath(false);
	}
	
	public boolean isVisited()
	{
		return visited;
	}
	
	public void setVisited(boolean visited)
	{
		this.visited = visited;
		if (visited)
			status = 1;
		else
			status = 0;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public int getStatus()
	{
		return status;
	}
	//--
	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public boolean isUsedInPath() {
		return usedInPath;
	}

	public void setUsedInPath(boolean usedInPath) {
		this.usedInPath = usedInPath;
	}
}
