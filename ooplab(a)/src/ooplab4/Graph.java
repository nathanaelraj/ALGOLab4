package ooplab4;


public class Graph {

	Edge[] vertice;
	int size;
	int numEdge;
	int maxEdge;

	
	public Graph(int size){
		
		this.size = size;
		vertice = new Edge[size];
		this.numEdge = 0;
		this.maxEdge =size * (size-1) /2;
		for(int i=0;i<size;i++){
			
			vertice[i]= new Edge(i+1);
			
		}
		
		
	}
	
	public Graph(int size,int numEdges){//allocate randomly x number of edges
		
		this.size = size;
		vertice = new Edge[size];
		this.numEdge = 0;
		this.maxEdge =size * (size-1) /2;
		for(int i=0;i<size;i++){
			
			vertice[i]= new Edge(i+1);}
		
		
		for(int i =0;i<numEdges;i++){
			int check = 0;
			
			while(check==0){
				int vertice1=0;
				int vertice2=0;
				while(vertice1==vertice2){
				vertice1 = (int)(Math.random() * (size))+1;
				vertice2 = (int)(Math.random() * (size))+1;}
				
			//	System.out.println("Trying Link " + vertice1 + " and " + vertice2);
				check +=  this.AddEdge(vertice1, vertice2);
			//	if(check ==1){
				
			//	System.out.println("Linked " + vertice1 + " and " + vertice2);
			//	}
				if(check ==2){
					break;
				}
			}
		}
		System.out.println("Edges linked: " + numEdge);
		
		
	}
	
	public int AddEdge(int vertice1, int vertice2){
		if(numEdge == maxEdge){
			System.out.print("Max Edges Reaches: ");
			System.out.println("Edges present = " + numEdge);
			return 2;//failed
		}
		if(vertice1==vertice2){
			System.out.println("Error-Parallel Edge");
			return 0;//failed
		}
		if(vertice1>size || vertice2>size){
			System.out.println("Error-Vertice out of Bounds");
			return 0;//failed
		}
		
		int count=0;
		count += AddEdgeInstance( vertice1,  vertice2);
		count += AddEdgeInstance(vertice2,  vertice1);
		
		if(count==2){
			numEdge++;
			return 1;
		}else{
			if(count!= 0){
			if(count!= 2)
				System.out.println("Error pairing Edge instances, count = "+ count);
			}
			return 0;
		}
	}
	
	public int AddEdgeInstance(int vertice1, int vertice2){//2 entries per edge
Edge current = vertice[vertice1-1];
		
		while(true){
			
		if(current.getNext()==null){
			Edge edge = new Edge(vertice2);
			current.connect(edge);
			return 1;//edge created
			
		}else if(current.getNext().getVertice() == vertice2){
			System.out.println("Edge already exists");
			return 0;//failed
			
		}else{current = current.getNext();}
		}
	}
	
	
	public void printGraph(){
		
		for(int i =0;i<size;i++){
			System.out.print( "Vertice " + (i+1) + " > ");
			Edge current = vertice[i];
			while(current.getNext()!=null){
				System.out.print(current.getNext().getVertice() + " > ");
				current = current.getNext();
			}
			System.out.println("");
		}
	}

	public int getSize() {
		return size;
	}
	


    
}
