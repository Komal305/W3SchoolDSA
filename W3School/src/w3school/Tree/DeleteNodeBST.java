package w3school.Tree;

public class DeleteNodeBST {

	public TreeNode MinValue(TreeNode node) {
		TreeNode curr = node;
		while (curr.left != null) {
			curr = curr.left;
		}
		return curr;
	}
	
	
	public TreeNode delete(TreeNode node, int data) {
		if(node==null)return null;
		if(data<node.c) {
			node.left =  delete(node.left, data);
		}else if(data>node.c) {
		node.right = delete(node.right, data);
		}
		else {
			if(node.left==null) return node.right;
			else if(node.right==null) return node.left;
			
			node.c = MinValue(node.right).c;
			node.right = delete(node.right, node.c);
		}
		return node;
	}
}
