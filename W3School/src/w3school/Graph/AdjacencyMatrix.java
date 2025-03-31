package w3school.Graph;



public class AdjacencyMatrix {
	public static void main(String[] args) {
		String[] vertexData = { "A", "B", "C", "D" };

		int[][] adjacencyMatrix = { { 0, 1, 1, 1 }, // Edges for A
				{ 1, 0, 1, 0 }, // Edges for B
				{ 1, 1, 0, 0 }, // Edges for C
				{ 1, 0, 0, 0 } // Edges for D
		};

		for (String s : vertexData)
			System.out.print(s + " ");
		System.out.println("\n");
		printAdjacencyMatrix(adjacencyMatrix);
		
		System.out.println("\nConnections \n");
		printConnections(adjacencyMatrix, vertexData);
	}

	static void printAdjacencyMatrix(int[][] arr) {

		for (int[] ar : arr) {
			for (int a : ar) {
				System.out.print(a + " ");
			}
			System.out.println();
		}

	}
	
	static void printConnections(int[][] adjacencyMatrix, String[] vertexData){
		int n = vertexData.length;
		for(int i=0; i<n; i++) {
			System.out.print(vertexData[i]+": ");
			for(int j=0; j<n; j++) {
				if(adjacencyMatrix[i][j]!=0) {
					System.out.print(vertexData[j]+" ");
				}
			}
			System.out.println();
		}
	}
}
