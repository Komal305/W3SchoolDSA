package w3school.Tree;

public class BinarySearch {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(13);
        root.left = new TreeNode(7);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(8);

        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(19);

        root.right.right.left = new TreeNode(18);
        
        inOrder(root);
        TreeNode ans = SearchNode(root, 155);
        if(ans != null) System.out.println(" yes got "+ ans.c +" in tree");
        else System.out.println( " data is not there buddy ");;
	}

	/*******************************
	 *     search item in tree     *
	 *******************************/
	static TreeNode SearchNode(TreeNode node, int target) {   //time complexity 0(h)
		if (node == null)
			return null;
		else if(target == node.c) return node;
		else if (target < node.c)
			return SearchNode(node.left, target);
		else
			return SearchNode(node.right, target);
	}
	
	static void inOrder(TreeNode node) {
		if(node == null) return;
		inOrder(node.left);
		System.out.print(node.c+" ");
		inOrder(node.right);
	}

}
