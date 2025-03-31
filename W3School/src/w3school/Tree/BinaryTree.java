package w3school.Tree;

public class BinaryTree {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		Character[] c = { 'R', 'A', 'B', 'C', 'D', 'E', 'F', null, null, null, null, null, null, 'G' };
		int rightNode = bt.rightNode(0);
		int leftChildOfRightNode = bt.leftNode(rightNode);

		Character data = bt.getData(c, leftChildOfRightNode);
		System.out.println("OutPut  " + data);

	}

	int leftNode(int index) {
		return 2 * index + 1;
	}

	int rightNode(int index) {
		return 2 * index + 2;
	}

	Character getData(Character[] tree, int index) {
		if (index >= 0 && tree.length > index) {
			return tree[index];
		}
		return null;
	}

	
}
