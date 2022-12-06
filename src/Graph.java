import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Graph {
	public List<Node> nodes;
	public List<Edge> edges;
	
	public Graph(List<Node> nodes, List<Edge> edges) {
		this.nodes = nodes;
		this.edges = edges;
	}
	
//	DIJKSTRA(G, w, s) // graph G, weight function w, source vertex s
	//	INITIALIZE-SINGLE-SOURCE(G, s) //theta n
	//	Let Q be a min priority queue // constant
	//	Add all vertices to Q // O(nlogn)
	//	while Q is not empty  //  O(n) 
	//	   u = EXTRACT-MIN(Q) // logn
	//	   for each vertex v adjacent to u  // n
	//	      RELAX(u, v, w)  // constant
	
	// TODO: Implement
	public void doDijkstra(Node source, boolean isRushHour) {
		
		for(Edge edge : this.edges) {
			
			edge.setIsRushHour(isRushHour);
		}
		
		ArrayList<Node> q = new ArrayList<Node>();
		
		initializeSingleSource(source);
		q.addAll(this.nodes);
		
		while(!q.isEmpty()) {
			Collections.sort(q);
			Node u = q.remove(0);
			for(Edge edges : (LinkedList<Edge>)u.outboundEdges) {
				relax(u, edges.target);
			}
		}
	}
	
	public Node nodeReturn(String name) {
		
		for(Node node : nodes) {
			if(node.name.equalsIgnoreCase(name)) {
				return node;
			}
		}
		return null;
	}
	
	/*
	INITIALIZE-SINGLE-SOURCE(G, s) // graph G with source vertex s
		for each vertex v of G // all vertices including s
	   		v.d = infinity // infinity
	   		v.p = NULL
		s.d = 0 // this is outside the loop. We “fix” s.d to be 0, not infinity

	*/
	private void initializeSingleSource(Node source) {
		//do stuff to each vertex of the graph
		for(Node node : this.nodes) {
			node.d = Integer.MAX_VALUE;
			node.p = null;
		}
		source.d = 0;
	}
	
	private void relax(Node u, Node v) {
		//our weight function is in our Edge! Oh no!
		if(u.d == Integer.MAX_VALUE) {
			return;
		}
		
		Edge edge = u.getBackEdge(v);
		
		if (v.d > (u.d + edge.getWeight())) {
			v.d = u.d + edge.getWeight();
			v.p = u;
		}
	}
	
	// TODO: Implement
	public void printDirections(Node source, Node destination, boolean isRushHour) {
		
		ArrayList<Node> q = new ArrayList<Node>();
		Boolean done = false;
		
		doDijkstra(source, isRushHour);
		q.addAll(this.nodes);
		Collections.sort(q);
		
		Node current = null;
		
		while(current != destination) {
			current = q.remove(0);
			
			if(current == destination) {
				System.out.print(current.name);
			} else {
				System.out.print(current.name + "->");
			}
			for(Edge edge : current.outboundEdges) {
				if(edge.target.equals(destination)) {
					System.out.println(destination.name);
					done = true;
				}
			}
			if (done) {
				break;
			}
		}
		System.out.println();
	}
	
	private void printDashes(int numDashes) {
		for(int i = 0; i < numDashes; i++) {
			System.out.print("-");
		}
		System.out.println();
		
	}
	// Implemented for you:
	public void printNodes() {
		System.out.println();
		printDashes(25);
		System.out.println("id\tname\tparent");
		printDashes(25);
		for (Node node: this.nodes) {
			System.out.println(node);
		}
		printDashes(25);
		System.out.println();
	}
	
	// Implemented for you:
	public void printEdges(boolean isRushHour) {
		System.out.println();
		printDashes(80);
		System.out.println("id\tname\tsource\ttarget\tweight\tlanes\tspeed\tcongestion\tlength");
		printDashes(80);
		for (Edge edge: this.edges) {
			edge.setIsRushHour(isRushHour);
			System.out.println(edge);
		}
		printDashes(80);
		System.out.println();
	}
}
