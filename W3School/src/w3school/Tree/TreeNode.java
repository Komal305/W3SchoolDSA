package w3school.Tree;

public class TreeNode {
	int c;
	TreeNode left, right;

	TreeNode(int c) {
		this.c = c;
		left = right = null;
	}

	static void inOrderTraversal(TreeNode node) {
		if (node == null)
			return;
		inOrderTraversal(node.left);
		System.out.print(node.c + ", ");
		inOrderTraversal(node.right);
	}

	public static void main(String[] args) {
		int[] in = { 3, 7, 8, 13, 14, 15, 18, 19, };
		TreeNode tree = null;
		InsertNode i = new InsertNode();
		DeleteNodeBST d = new DeleteNodeBST();

		for (int arr : in) {
			tree = i.Insert(tree, arr);
		}

		inOrderTraversal(tree);
		d.delete(tree, 13);
		System.out.println();
		inOrderTraversal(tree);
	}
}
