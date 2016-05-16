package com.prac;

public class IdenticalBinaryTrees {
	
	static class Node{
		int data;
		Node right, left;
		public Node(int d){
			data = d;
			right = null;
			left = null;
		}
	}
	
	// This method checks that every node in both the trees has same data and same left and right node by
	// recursively calling
	public boolean isIdentical(Node root1, Node root2){
		if(root1 == null && root2 == null)
			return true;
		else if(root1 != null && root2 != null){
			if(root1.data == root2.data && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right))
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	public static void main(String[] args) {
		// This creates the first tree with root1
		Node root1 = new Node(1);
		root1.left = new Node(2);
		root1.right = new Node(3);
		root1.left.left = new Node(4);
		root1.left.right = new Node(5);
		root1.right.right = new Node(7);
		
		// This creates another tree, similar to first tree, with root2
		Node root2 = new Node(1);
		root2.left = new Node(2);
		root2.right = new Node(3);
		root2.left.left = new Node(4);
		root2.left.right = new Node(5);
		root2.right.right = new Node(7);
		
		IdenticalBinaryTrees trees = new IdenticalBinaryTrees();
		if(trees.isIdentical(root1, root2))
			System.out.println("Both the Binary trees are identical");
		else
			System.out.println("Both the Binary trees are NOT identical");	
	}
}
