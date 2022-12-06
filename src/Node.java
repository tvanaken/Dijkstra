import java.util.LinkedList;

import org.json.simple.JSONObject;

public class Node implements Comparable<Node> {
	public Integer id;
	public String name;
	public Node p;
	public float d;
	public LinkedList<Edge> outboundEdges = new LinkedList<Edge>(); //tracks all of the outbound edges for a particular node
	
	public Node(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void addEdge(Edge edge) {
		
		this.outboundEdges.add(edge);
	}
	
	// TODO: Implement
	public Edge getBackEdge(Node node) {
		
		for(Edge edge : this.outboundEdges) {
			if (edge.target.compareTo(node) == 0) {
				return edge;
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject toJSON() {
		JSONObject entry = new JSONObject();
		JSONObject data = new JSONObject();
		data.put("id", this.id);
		data.put("distance", this.d);
		data.put("label", this.name);
		entry.put("data", data);
		return entry;
	}
		
	
	// Implemented for you:
	public String toString() {
		String edgeString = this.id + "\t";
		edgeString += this.name + "\t";
		edgeString += (this.p != null) ? this.p.name : '*';
		return edgeString;
	}
	
	public int compareTo(Node other) {

		if (this.d < other.d) {
			return -1;
		} else if (this.d > other.d) {
			return 1;
		} else {
			return 0;
		}
	}

}
