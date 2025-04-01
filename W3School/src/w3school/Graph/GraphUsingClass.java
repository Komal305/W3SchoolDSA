package w3school.Graph;

public class GraphUsingClass {

	private int[][] adjMatrix;
	private int[] vertex;
	private int size;

	public GraphUsingClass(int size) {
		this.size = size;
		this.adjMatrix = new int[size][size];
		this.vertex = new int[size];
	}

	/************ add edges **********************/

	public void addEdge(int u, int v) {
		if (u >= 0 && u < size && v >= 0 && v < size) {
			adjMatrix[u][v] = 1;
			adjMatrix[v][u] = 1;
		}
	}
	
	
	/************ add edges for directed graph **********************/

	public void addEdgeDir(int u,int v, int weight) {
		if (u >= 0 && u < size && v >= 0 && v < size) {
			adjMatrix[u][v] = weight;
		}
	}
	

	/************* add vertex data *****************/

	public void addVertex(int ver, char data) {
		if (ver >= 0 && ver < size) {
			vertex[ver] = data;
		}
	}

	/************* add vertex data *****************/

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

	public static void main(String[] args) {
		GraphUsingClass g = new GraphUsingClass(4);
		g.addVertex(0, 'A');
		g.addVertex(1, 'B');
		g.addVertex(2, 'C');
		g.addVertex(3, 'D');

//		g.addEdge(0, 1);// A-B
//		g.addEdge(0, 2);// A-C
//		g.addEdge(0, 3);// A-D
//		g.addEdge(2, 1);// C-B
//		
		/********************weighted and directed graph***********************/
		
		  g.addEdgeDir(0, 1, 3); // A -> B with weight 3
		  g.addEdgeDir(0, 2, 2); // A -> C with weight 2
		  g.addEdgeDir(3, 0, 4); // D -> A with weight 4
		  g.addEdgeDir(2, 1, 1); // C -> B with weight 1

		g.print();

	}

}
