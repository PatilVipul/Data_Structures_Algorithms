package com.prac;

public class BinaryTreeDeletion {

	static class Node{
		int data;
		Node left, right;
		public Node(int d){
			data = d;
			left = null;
			right = null;
		}
	}
	
	public void delete(Node node){
		if(node == null)
			return;
		delete(node.left);
		delete(node.right);
		System.out.println("Deleted Node: " + node.data);
		node = null;
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		BinaryTreeDeletion tree = new BinaryTreeDeletion();
		tree.delete(root);
	}
}
