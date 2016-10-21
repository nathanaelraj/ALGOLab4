package ooplab4;

import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
	int[][] distArray;
    int[][] parentArray;
	Graph graph;
	int size;
	
	public Bfs(Graph graph){
		this.graph = graph;
        this.size = graph.getSize();
        distArray = new int[size][size];
        for(int i = 0;i<size;i++){
        	for(int j =0;j<size;j++){
        		distArray[i][j]=999;
        	}
        }
        parentArray = new int[size][size];
        for(int i = 0;i<size;i++){
        	for(int j =0;j<size;j++){
        		parentArray[i][j]=999;
        	}
        }
    	
	}

    public void bfsProcess(){
    	for(int vertice = 1; vertice<=size;vertice++){
  
    	Queue<Integer> queue = new LinkedList<Integer>();
    	
        queue.add(vertice);
        Boolean[] mark = new Boolean[size];
        int[] level = new int[size];
        	
        for(int i = 0;i<size;i++){
        	
        		mark[i]=false;
        	
        }
      
        for(int i = 0;i<size;i++){
        	
    		level[i]=0;
    	
    }
       mark[vertice-1]=true;
       while(queue.peek()!=null){
       
        	Edge currentVertice = graph.vertice[queue.poll()-1];
        	Edge masterVertice = currentVertice;

   
        	
        	distArray[vertice-1][currentVertice.getVertice()-1]=level[currentVertice.getVertice()-1];//should be 0 in the diagonal
        	
        	
        	while(currentVertice.getNext()!=null){
        		System.out.println("now at level" + level[masterVertice.getVertice()-1]);
        		if(mark[currentVertice.getNext().getVertice()-1]==false){
        			mark[currentVertice.getNext().getVertice()-1]=true;
        			
        			int masterLevel = level[masterVertice.getVertice()-1];
        			level[currentVertice.getVertice()-1]=(masterLevel+1);
        			System.out.println("test set level");
        			queue.add(currentVertice.getVertice());
        			
        			distArray[vertice-1][currentVertice.getVertice()-1]=level[currentVertice.getVertice()-1];
        			parentArray[vertice-1][currentVertice.getVertice()-1]=masterVertice.getVertice();
        		
        		}
        		currentVertice = currentVertice.getNext();
        	}
        }
    	}
    }
    
	public int[][] getDistArray() {
		return distArray;
	}

	public int[][] getParentArray() {
		return parentArray;
	}
	
	public void printDistArray(){
		System.out.println("Showing Shortest Distance Array");
		System.out.println("");
		System.out.format("Vertice       ");
		for(int i = 0;i<size;i++){
			System.out.format("%6d", i+1);
		}
		System.out.println("");
	        for(int i = 0;i<size;i++){
	        	System.out.format("Vertice %6d", i+1);
	        	for(int j =0;j<size;j++){
	        		System.out.format("%6d", distArray[i][j]);
	        	}
	        	System.out.println("");
	        }
	}
	
	public void printParentArray(){
		System.out.println("Showing Shortest Distance Array");
		System.out.println("");
		System.out.format("Vertice       ");
		for(int i = 0;i<size;i++){
			System.out.format("%6d", i+1);
		}
		System.out.println("");
	        for(int i = 0;i<size;i++){
	        	System.out.format("Vertice %6d", i+1);
	        	for(int j =0;j<size;j++){
	        		System.out.format("%6d", parentArray[i][j]);
	        	}
	        	System.out.println("");
	        }
	}
}
