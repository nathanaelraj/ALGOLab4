package ooplab4;


import java.util.Scanner;

public class GraphApp {


	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter size of Graph");
		int size = scan.nextInt();
		
		
		System.out.println("Enter number of Edges");
		int numEdges = scan.nextInt();
		
		Graph graph = new Graph(size,numEdges);
		Bfs bfs = new Bfs(graph);
		int choice;
		do{
			System.out.println("");
		    System.out.println("Select Choice");
			System.out.println("1)Print Graph");	
		choice = scan.nextInt();
		switch(choice){
		
		case 1:
			graph.printGraph();
			break;
		case 2:
			
			bfs.bfsProcess();
			break;
		case 3:
		    bfs.printDistArray();
		    bfs.printParentArray();
		    break;
		}
		}while(choice>0 && choice < 4);
				
	}
}
