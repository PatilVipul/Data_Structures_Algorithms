package com.prac;

public class BasicTree {
	
	static class TreeNode{
		int data;
		TreeNode right, left;
		public TreeNode(int d){
			data = d;
			right = left = null;
		}
	}
	
	public void inOrder(TreeNode root){
		if(root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + "\t");
		inOrder(root.right);
	}
	
	public void preOrder(TreeNode root){
		if(root == null)
			return;
		System.out.print(root.data + "\t");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public void postOrder(TreeNode root){
		if(root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + "\t");
	}
	
//	public TreeNode printTree(TreeNode root){
//		if(root == null)
//			return null;
//		System.out.println(root.data);
//		printTree(root.left);
//		printTree(root.right);
//		return root;
//	}

	public static void main(String[] args) {
		BasicTree tree = new BasicTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
//		tree.printTree(root);
		System.out.print("Inorder Tree Traversal: ");
		tree.inOrder(root);
		
		System.out.print("\n\nPreorder Tree Traversal: ");
		tree.preOrder(root);
		
		System.out.print("\n\nPostorder Tree Traversal: ");
		tree.postOrder(root);
	}

}
