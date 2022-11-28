import java.util.LinkedList;

import org.json.simple.JSONObject;

public class Node {
	public Integer id;
	public String name;
	public Node p;
	public float d;
	public LinkedList<Edge> outboundEdges = new LinkedList<Edge>(); //tracks all of the outbound edges for a particular node
	
	public Node(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	// TODO: Implement
	public void addEdge(Edge edge) {
		
	}
	
	// TODO: Implement
	public Edge getBackEdge(Node node) {
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

}
