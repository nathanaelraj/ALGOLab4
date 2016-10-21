package ooplab4;

public class Edge {

	Edge next;
	int vertice;

	
	public Edge(int vertice){
	
		this.vertice = vertice;
		this.next = null;
	

		
	}
	
	public Edge getNext(){
		return this.next;
	}
	
	public void connect(Edge edge){
		this.next = edge;
	}
	
	public int getVertice(){
		
		return vertice;
		
	}

	
}
