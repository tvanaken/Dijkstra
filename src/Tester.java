import java.util.Scanner;

public class Tester {
	
	
	
	public static void main(String[] args) {
		
		Boolean rush;
		
		Graph graph = JSONHelper.createGraphFromJSON();
		Visualizer vis = new Visualizer(graph);
		
		System.out.println("Testing Code Here...");
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Type the origin node: ");
		Node origin = graph.nodeReturn(scan.next());
		System.out.println("Type the destination node: ");
		Node dest = graph.nodeReturn(scan.next());
		System.out.println("Is it rush hour? (y/n): ");
			if(scan.next().equalsIgnoreCase("y")) {
				rush = true;
			} else {
				rush = false;
			}
			
		graph.printDirections(origin, dest, rush);
		 //Display Graph to the screen 

		System.out.println("Nodes:");
		graph.printNodes();
		System.out.println("Edges (NOT Rush Hour):");
		graph.printEdges(false);
		System.out.println("Edges (Rush Hour):");
		graph.printEdges(true);
		
		
		System.out.println("Outputting Graph to JavaScript file (open dijkstra.html in your web browser");
		vis.save("output.js");
		
	}

}
