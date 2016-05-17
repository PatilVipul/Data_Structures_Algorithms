package com.prac;

public class BTLeafCount {

	static class Node{
		int data;
		Node left, right;
		public Node(int d){
			data = d;
			left = null;
			right = null;
		}
	}
	
	// This method counts total number of leaf nodes in the given Binary tree using recursive method
	public int countLeafNodes(Node node){
		if(node == null)
			return 0;
		else if(node.left == null && node.right == null)
			return 1;
		return countLeafNodes(node.left) + countLeafNodes(node.right);
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(3);
		root.right = new Node(2);
		root.right.left = new Node(5);
		root.right.right = new Node(4);
		root.right.right.right = new Node(6);
		root.right.right.left = new Node(7);
		
		BTLeafCount tree = new BTLeafCount();
		int count = tree.countLeafNodes(root);
		System.out.println("Total number of leaves in this Binary tree are: " + count);
	}

}
