package w3school.Graph;

public class DfsBsfGraphUnDirected {

	private int[][] adjMatrix;
	private char[] vertex;
	private int size;

	public DfsBsfGraphUnDirected(int size) {
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
		System.out.print(vertex[v]+"-->");
		for(int i=0; i<size; i++) {
			if(adjMatrix[v][i]==1 && !visited[i]) {
				dfsUtill(i, visited);
			}
		}
	}

	private void DFS(char start) {
		boolean[] v = new boolean[size];
		int startVertex = new String(vertex).indexOf(start);//3
		dfsUtill(startVertex, v);//3,v
	}
	
	
	public void Bfs(char startVertexData) {
		boolean[] visited = new boolean[size];
		int[] queue = new int[size];
		int qStart = 0, qEnd =0;
		
		int startVertex = new String(vertex).indexOf(startVertexData);//3
		queue[qEnd++] = startVertex;//[3,
		visited[startVertex] = true;//[ 0,1 ,2 ,true ,4, 5,6,]
		
		while(qStart<qEnd) {//0<1 1<2 2<3 3<7 4<7 5<7 6<7
			/*3 0 2 4 1 5  6*/int currentVertex = queue[qStart++];//qs 1 2 3 4 5 6
			System.out.print(currentVertex+";");
			System.out.print(vertex[currentVertex]+"-->");//d a c e b f g
		
				
			for(int i=0; i<size; i++) {
				if(adjMatrix[currentVertex][i]==1 && !visited[i] ) {
					queue[qEnd++]=i;
					visited[i]=true;
				}
			}
			
			
			
		}
		
	}
	
	
	public static void main(String[] args) {
		DfsBsfGraphUnDirected g  = new DfsBsfGraphUnDirected(7);
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

        System.out.println("\nDFS");
        g.DFS('D');//        D-->A-->C-->B-->F-->E-->G-->
        System.out.println("\nBFS");
        g.Bfs('D');//        D-->A-->C-->E-->B-->F-->G-->
    }

}
