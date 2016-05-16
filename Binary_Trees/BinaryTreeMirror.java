package com.prac;

import com.prac.BinaryTreeDeletion.Node;

public class BinaryTreeMirror {
	static class Node{
		int data;
		Node left, right;
		public Node(int d){
			data = d;
			left = null;
			right = null;
		}
	}
	
	// This method interchanges the left child and right child of every node so that a mirror of the original
	// tree would be created.
	public void mirror(Node node){
		if(node == null)
			return;
		else{
			mirror(node.left);
			mirror(node.right);
			Node temp;
			temp = node.left;
			node.left = node.right;
			node.right = temp;
		}
	}
	
	// This method does the inorder binary tree traversal and prints that order
	public void inorder(Node node){
		if(node == null)
			return;
		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(3);
		root.right = new Node(2);
		root.right.left = new Node(5);
		root.right.right = new Node(4);
		root.right.right.right = new Node(6);
		root.right.right.right.right = new Node(7);
		
		BinaryTreeMirror tree = new BinaryTreeMirror();
		
		System.out.print("The original tree inorder traversal is: ");
		tree.inorder(root);
		
		tree.mirror(root);
		
		System.out.print("\nAfter mirroring, inorder traversal becomes: ");
		tree.inorder(root);
	}
}
