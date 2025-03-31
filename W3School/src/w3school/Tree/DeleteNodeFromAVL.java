package w3school.Tree;


public class DeleteNodeFromAVL {
	
	static class AVLTree{
		class TreeNode{
			char data;
			TreeNode left, right;
			int height;
			TreeNode(char d){
				data = d;
				height = 1;
			}
		}
		
		TreeNode root;
		/************************** height  ******************************/
		int height(TreeNode N) {
			if(N==null) return 0;
			return N.height;
		}
		/**************************  balance ******************************/
		
		int getBalance(TreeNode N) {
			if(N==null) return 0;
			return height(N.left)-height(N.right);
		}
		
/**************************  Rotate Right ******************************/		
		TreeNode rightRotate(TreeNode y) {
			System.out.println("rotate right on node: "+y.data);
			
			TreeNode x = y.left;
			TreeNode T2= x.right;
			
			x.right = y;
			y.left = T2;
		
			y.height = Math.max(height(y.left), height(y.right))+1;
			x.height = Math.max(height(x.left), height(x.right))+1;
			return x;
		}	
/************************** Left Rotate ***********************************/		
		TreeNode leftRotate(TreeNode x) {
			System.out.println("rotate left on node : "+x.data);
			
			TreeNode y = x.right;
			TreeNode T2 = y.left;
			
			y.left = x;
			x.right = T2;
			
			x.height = Math.max(height(x.left), height(x.right))+1;
			y.height = Math.max(height(y.left), height(y.right))+1;
			
			return y;
		}
/************************** Minimum Value ***********************************/
		TreeNode minValue(TreeNode node) {
			TreeNode curr = node;
			while(curr.left != null) {
				curr = curr.left;
			}
			return curr;
		}
/************************** Delete Node ***********************************/
		private TreeNode Delete(TreeNode root, char data) {
			if(root==null) return root;
			
			if(data < root.data) {
				root.left = Delete(root.left, data);
			}else if(data > root.data) {
				root.right = Delete(root.right, data);
			}else {
				if( (root.left==null) || (root.right==null)) {
					TreeNode temp = (root.left != null) ?root.left:root.right;
					if(temp==null) root=null;
					else root = temp;
				}
				else {
					TreeNode temp = minValue(root.right);
					root.data = temp.data;
					root.right = Delete(root.right, temp.data);
				}
			}
			if(root==null) return root;
			
			root.height = Math.max(height(root.left), height(root.right))+1;
			int balance = getBalance(root);
			
			//left left case
			if(balance >1 && getBalance(root.left)>=0) {
				return rightRotate(root);
			}
			
			//left right case
			if(balance > 1 && getBalance(root.left)<0) {
				root.left = leftRotate(root.left);
				return rightRotate(root);
			}
			
			//right right case
			if(balance <-1 && getBalance(root.right)<=0) {
				return leftRotate(root);
			}
			
			//right left case
			if(balance < -1 && getBalance(root.right) > 0) {
				root.right = rightRotate(root.right);
				return leftRotate(root);
			}
			
			return root;
		}
		
		void inOrder(TreeNode node) {
			if(node != null) {
				inOrder(node.left);
				System.out.print(node.data+", ");
				inOrder(node.right);
			}
		}
		
		
	
	
	
	
	
	
	
	/************************** Insert Node ***********************************/
	TreeNode insert(TreeNode root, char data) {
		if(root==null) return new TreeNode(data);
		
		if(data<root.data) {
			root.left = insert(root.left, data);
		}else if(data>root.data) {
			root.right = insert(root.right, data);
		}else {
			return root;
		}
		
		root.height = 1+Math.max(height(root.left), height(root.right));
		int balance = getBalance(root);
		
		//left left case
		if(balance>1 && getBalance(root.left) >= 0) {
			return rightRotate(root);
		}
		
		//
		if(balance>1 && getBalance(root.left) < 0) {
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}
		
		//
		if(balance>1 && getBalance(root.right) <= 0) {
			return leftRotate(root);
		}
		
		//
		if(balance>1 && getBalance(root.right) > 0) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}
		
		return root;
	}
	
	}
	public static void main(String[] args) {
		
		 AVLTree tree = new AVLTree();
         char[] letters = {'C', 'B', 'E', 'A', 'D', 'H', 'G', 'F'};
         for (char letter : letters) {
             tree.root = tree.insert(tree.root, letter);
         }

         tree.inOrder(tree.root);

         System.out.println("\nDeleting A");
         tree.root = tree.Delete(tree.root, 'A');
         tree.inOrder(tree.root);
	}
	

}
