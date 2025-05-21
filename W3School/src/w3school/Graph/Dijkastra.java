package w3school.Graph;

import java.util.Arrays;

public class Dijkastra {
	private int[][] adjMatrix;
	private char[] vertex;
	private int size;

	public Dijkastra(int size) {
		this.size = size;
		this.adjMatrix = new int[size][size];
		this.vertex = new char[size];
	}

	/************ add edges **********************/

	public void addEdge(int u, int v, int weight) {
		if (u >= 0 && u < size && v >= 0 && v < size) {
			adjMatrix[u][v] = weight;
			adjMatrix[v][u] = weight;
		}
	}
	
	 public void addVertexData(int ver, char data) {
         if (ver >= 0 && ver < size) {
             vertex[ver] = data;
         }
     }
	
	/*************  print matrix  *****************/

	public void print() {
		char A = 65;
		System.out.println("Adjacency matrix");
		for (int[] adjM : adjMatrix) {
			System.out.print(A++ +" : ");
			for (int adj : adjM) {
				System.out.print(adj + " ");
			}
			System.out.println();
		}

	}
	
	/****************Dijkstra algorithm*********************/
	
	public int[] DijkstraAlgo(char startVertexData) {
		int startV = new String(vertex).indexOf(startVertexData);
		int[] distance = new int[size];
		boolean[] visited = new boolean[size];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[startV] = 0;
		
		for(int i=0; i<size; i++) {
			int u = MinDistance(distance, visited);
			if(u==-1) break;
			visited[u]=true;
			
			for(int v=0; v<size; v++) {
				if(!visited[v] && distance[u] != Integer.MAX_VALUE && adjMatrix[u][v] !=0) {
					int newDis = distance[u]+adjMatrix[u][v];
					if(newDis<distance[v]) {
						distance[v]=newDis;
					}
				}
			}
			
		}
		return distance;
				
	}

	private int MinDistance(int[] distance, boolean[] visited) {

		int min=Integer.MAX_VALUE, minIndex = -1;
		
		for(int v=0; v<size; v++) {
			if(!visited[v] && distance[v]<=min) {
				min = distance[v];
				minIndex = v;
			}
		}
		return minIndex;
	}
	
	
	public static void main(String[] args) {
		Dijkastra g = new Dijkastra(7);
		g.addVertexData(0, 'A');
        g.addVertexData(1, 'B');
        g.addVertexData(2, 'C');
        g.addVertexData(3, 'D');
        g.addVertexData(4, 'E');
        g.addVertexData(5, 'F');
        g.addVertexData(6, 'G');

        g.addEdge(3, 0, 4); // D - A, weight 4
        g.addEdge(3, 4, 2); // D - E, weight 2
        g.addEdge(0, 2, 3); // A - C, weight 3
        g.addEdge(0, 4, 4); // A - E, weight 4
        g.addEdge(4, 2, 4); // E - C, weight 4
        g.addEdge(4, 6, 5); // E - G, weight 5
        g.addEdge(2, 5, 5); // C - F, weight 5
        g.addEdge(2, 1, 2); // C - B, weight 2
        g.addEdge(1, 5, 2); // B - F, weight 2
        g.addEdge(6, 5, 5); // G - F, weight 5
        
        g.print();

        // Dijkstra's algorithm from D to all vertices
        System.out.println("Dijkstra's Algorithm starting from vertex D:\n");
       int[] arr = g.DijkstraAlgo('D');
       for (int i = 0; i < arr.length; i++) {
           System.out.println("Shortest distance from D to " + g.vertex[i] + ": " + arr[i]);
       }
	}
}
