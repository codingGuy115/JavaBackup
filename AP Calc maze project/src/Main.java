import java.util.ArrayList;

public class Main 
{	
	//fields
	private Node[][] nodes; //[rows][cols]
	private int mazeRows;
	private int mazeCols;
	private ArrayList<Node> holyPath;
	
	//entrypoint to program
	public Main()
	{
		mazeRows = 10;
		mazeCols = 10;
		nodes = new Node[mazeRows][mazeCols];
		holyPath = new ArrayList<Node>();
		//fill up the array
		int nodeId = 1;
		for (int r=0; r<nodes.length; r++) {
			for (int c=0; c<nodes[0].length; c++)
			{
				nodes[r][c] = new Node(nodeId, r, c);
				nodeId++;
			}
		}
		//print out the graph (lets do GUI later, print to console for now)
		printGraph(nodes);
		System.out.println("\n");
		//perform the Depth first search algorithm
		int x = 0;
		int y = 0;
		dfs(nodes, x, y);
		
	}
	
	public void printGraph(Node[][] graph)
	{
		for (int r=0; r<nodes.length; r++) {
			for (int c=0; c<nodes[0].length; c++)
			{
				System.out.print(nodes[r][c].getID() + " ");
			}
			System.out.println();
		}
	}
	
	// ***Where the actual logic happens***
	public void dfs(Node[][] graph, int row, int col)
	{
		//basecase, when program should terminate
		if (holyPath.size()==graph.length * graph[0].length)
		{
			System.out.print("\n\t The program is over, final holyPath: ");
			for (Node n : holyPath) {
				System.out.print(n.getID()+", ");
			} System.out.println();
			printGraph(graph);
			return;
		}
		
		Node cnode = graph[row][col]; System.out.println("CURRENT NODE: "+cnode.getID());
		cnode.setVisited(true);
		if (!doesIDExist(holyPath, cnode))
		{	
			holyPath.add(cnode); 
		}
		//now find all neighbors of current node
		ArrayList<Node> neighbors = new ArrayList<Node>();
		neighbors = findNeighbors(graph, row, col);
		
		System.out.println("Node ID:"+cnode.getID()+" has the following neighbors:");
		for (Node n : neighbors)
		{
			System.out.print(n.getID() + ", ");
		}
		System.out.println();
		// ** DONE WITH FINDING NEIGHBORS **
		
		// for testing purposes
		System.out.print("CURRENT holypath: ");
		for (Node n : holyPath) {
			System.out.print(n.getID()+", ");
		} System.out.println();
		
		
		Node choice = neighbors.get((int) (Math.random()*neighbors.size() + 0));
		if(!choice.isVisited()) {
			choice.setVisited(true);
			if (!doesIDExist(holyPath, choice))
			{	
				holyPath.add(choice); 
			}
			dfs(graph, choice.getRow(), choice.getCol());
		}
		else {
			//if here, means we chose a node where visited=true
			//check if neighbors around are all visited or not
			if (isAllVisited(neighbors)) {
				System.out.println("case1, need to go back to previous node.");
				// **** go back to last node **** -USE METHOD
				Node previous = findMostRecentNodeWithAvailableNeighbor(holyPath);
				if (previous==null) { 
					System.out.println("NO UNVISITED NEIGHBORS FOUND.");
					printGraph(nodes);
					return;
				}
				
				dfs(graph, previous.getRow(), previous.getCol());
			}
			else {
				//this means not all have been visited, therefore we can call method again on the current node
				System.out.println("case2");
				dfs(graph, cnode.getRow(), cnode.getCol());
			}
			
		}
		
	}
	
	private ArrayList<Node> findNeighbors(Node[][] graph, int row, int col) {
		ArrayList<Node> neighbors = new ArrayList<Node>();
		boolean leftedge = false, rightedge = false, topedge = false, bottomedge = false;
		
		if (row==0) { topedge=true;} 
		if (row==graph.length-1) { bottomedge=true;}
		if (col==0) { leftedge=true;}
		if (col==graph[0].length-1) { rightedge = true;}
		
		//it can only be one of the following (christ this is so inefficient. smarter solution later)
		//top left
		if(leftedge && topedge) {
			neighbors.add(graph[row][col+1]);
			neighbors.add(graph[row+1][col]);
		}
		//top right
		else if(rightedge && topedge) {
			neighbors.add(graph[row][col-1]);
			neighbors.add(graph[row+1][col]);
		}
		//bottom left
		else if(leftedge && bottomedge) {
			neighbors.add(graph[row-1][col]);
			neighbors.add(graph[row][col+1]);
		}
		//bottom right
		else if(rightedge && bottomedge) {
			neighbors.add(graph[row-1][col]);
			neighbors.add(graph[row][col-1]);
		}
		//top
		else if(topedge) {
			neighbors.add(graph[row][col+1]);
			neighbors.add(graph[row][col-1]);
			neighbors.add(graph[row+1][col]);
		}
		//bottom
		else if(bottomedge) {
			neighbors.add(graph[row][col+1]);
			neighbors.add(graph[row][col-1]);
			neighbors.add(graph[row-1][col]);
		}
		//left
		else if(leftedge) {
			neighbors.add(graph[row+1][col]);
			neighbors.add(graph[row-1][col]);
			neighbors.add(graph[row][col+1]);
		}
		//right
		else if(rightedge) {
			neighbors.add(graph[row+1][col]);
			neighbors.add(graph[row-1][col]);
			neighbors.add(graph[row][col-1]);
		}
		// see now all of that was just for edge nodes. now it can only be a middle node
		else if(!topedge && !bottomedge && !leftedge && !rightedge) {
			neighbors.add(graph[row+1][col]);
			neighbors.add(graph[row-1][col]);
			neighbors.add(graph[row][col+1]); 
			neighbors.add(graph[row][col-1]);
		}
		
		return neighbors;
	}

	//helper method
	public boolean isAllVisited(ArrayList<Node> neighbors)
	{
		for (Node n : neighbors) {
			if(!(n.isVisited())) {
				return false;
			}
		}
		return true;
	}
	
	public boolean doesIDExist(ArrayList<Node> nodes, Node n) 
	{
		for (Node i : nodes) {
			if (i.getID()==n.getID()) {
				return true;
			}
		}
		return false;
	}
	
	public Node findMostRecentNodeWithAvailableNeighbor(ArrayList<Node> holyPath)
	{
		ArrayList<Node> nbrs = new ArrayList<Node>();
		//go thru the list backwards
		for (int i=holyPath.size()-1; i>-1; i--) {
			Node n = holyPath.get(i);
			nbrs = findNeighbors(nodes, n.getRow(), n.getCol());
			//now go thru neighbors of current previous node and if there's an unvisited neighbor, return it
			for (Node nb : nbrs) {
				if (nb.isVisited()==false) {
					return nb;
				}
			}
		}
		
		return null;
	}
	
	public static void main(String[] args)
	{
		new Main();
	}

}
