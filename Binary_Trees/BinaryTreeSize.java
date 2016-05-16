package com.prac;

public class BinaryTreeSize {

	static class Node{
		int data;
		Node right, left;
		public Node(int d){
			data = d;
			right = null;
			left = null;
		}
	}
	
	// This method calculates the size of complete Binary tree as: 
	// leftBinaryTreeSize + 1 (root) + rightBinaryTreeSize 
	public int BTsize(Node node){
		if(node!=null)
			return BTsize(node.left) + 1 + BTsize(node.right);
		else
			return 0;
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(7);
		
		BinaryTreeSize tree = new BinaryTreeSize();
		int size = tree.BTsize(root);
		System.out.println("Size of this tree is: " + size);
	}

}
