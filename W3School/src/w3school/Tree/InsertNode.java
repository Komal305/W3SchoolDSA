package w3school.Tree;

public class InsertNode {

	public TreeNode Insert(TreeNode node, int data) {
		if (node == null)
			return new TreeNode(data);

		else {
			if (data < node.c) {
				node.left = Insert(node.left, data);
			} else if (data > node.c) {
				node.right = Insert(node.right, data);
			}
		}
		return node;
	}

}
