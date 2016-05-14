package com.prac;

public class BinaryTreeBreadth {
	
	static class TreeNode{
		int data;
		TreeNode right, left;
		public TreeNode(int d){
			data = d;
			right = left = null;
		}
	}
	
	public void printLevelOrder(TreeNode root){
		int h = height(root);
		int i = 0;
		for(i = 1; i <= h; i++){
			printGivenLevel(root, i);
			System.out.println("");
		}
	}
	
	public void printGivenLevel(TreeNode root, int level){
		if(root == null)
			return;
		if(level == 1)
			System.out.print(root.data + "\t");
		else if(level > 1){
			printGivenLevel(root.left, level-1);
			printGivenLevel(root.right, level-1);
		}
	}
	
	public int height(TreeNode root){
		if(root == null)
			return 0;
		else{
			int leftHeight = height(root.left);
			int rightHeight = height(root.right);
			if(leftHeight > rightHeight)
				return leftHeight + 1;
			else
				return rightHeight + 1;
		}
	}

	public static void main(String[] args) {
		BinaryTreeBreadth tree = new BinaryTreeBreadth();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		System.out.println("Breadth First Traversal: ");
		tree.printLevelOrder(root);
	}
}
