package w3school.Graph;

public class GraphDFS {

	private int[][] adjMatrix;
	private char[] vertex;
	private int size;

	public GraphDFS(int size) {
		this.size = size;
		this.adjMatrix = new int[size][size];
		this.vertex = new char[size];
	}

	/************ add edges **********************/

	public void addEdge(int u, int v) {
		if (u >= 0 && u < size && v >= 0 && v < size) {
			adjMatrix[u][v] = 1;
			adjMatrix[v][u] = 1;
		}
	}
	

	/************* add vertex data *****************/

	public void addVertex(int ver, char data) {
		if (ver >= 0 && ver < size) {
			vertex[ver] = data;
		}
	}

	/*************  print matrix  *****************/

	public void print() {
		System.out.println("Adjacency matrix");
		for (int[] adjM : adjMatrix) {
			for (int adj : adjM) {
				System.out.print(adj + " ");
			}
			System.out.println();
		}
		int i = 0;
		for (int ver : vertex)
			System.out.println("vertex " + i++ + " " + (char) ver);
	}
	
	/*******************DFS Util***************************/
	private void dfsUtill(int v, boolean[] visited) {
		visited[v]=true;
		System.out.print(vertex[v]+"--> ");
		for(int i=0; i<size; i++) {
			if(adjMatrix[v][i]==1 && !visited[i]) {
				dfsUtill(i, visited);
			}
		}
	}

	private void DFS(char start) {
		boolean[] v = new boolean[size];
		int startVertex = new String(vertex).indexOf(start);//3
		dfsUtill(startVertex, v);
	}
	
	
	public static void main(String[] args) {
		GraphDFS g  = new GraphDFS(7);
		g.addVertex(0, 'A');
        g.addVertex(1, 'B');
        g.addVertex(2, 'C');
        g.addVertex(3, 'D');
        g.addVertex(4, 'E');
        g.addVertex(5, 'F');
        g.addVertex(6, 'G');

        g.addEdge(3, 0); // D - A
        g.addEdge(0, 2); // A - C
        g.addEdge(0, 3); // A - D
        g.addEdge(0, 4); // A - E
        g.addEdge(4, 2); // E - C
        g.addEdge(2, 5); // C - F
        g.addEdge(2, 1); // C - B
        g.addEdge(2, 6); // C - G
        g.addEdge(1, 5); // B - F

        g.print();

        System.out.println("\nDepth First Search starting from vertex D:");
        g.DFS('D');
    }

}
