// This program creates threaded binary tree and displays inorder traversal of threaded binary tree  

package com.prac;

import java.util.Currency;
import java.util.LinkedList;
import java.util.Queue;

import com.prac.BinaryInorderNoRecursion.Node;

public class ThreadedBinaryTree {

	static class Node{
		int data;
		Node left, right;
		boolean rightThread;
		public Node(int d){
			data = d;
			left = null;
			right = null;
			rightThread = false;
		}
	}
	
	// This method moves till the leftmost leaf of the tree.
	public Node leftmost(Node left){
		if(left == null)
			return null;
		else{
			while(left.left != null)
			{
				left = left.left;
			}
			return left;
		}
	}
	
	// This method populates the Queue by inorder traversing the tree
	public void populateQueue(Node node, Queue<Node> q){
		if(node == null)
			return;
		if(node.left!=null){
			populateQueue(node.left, q);
		}
		q.add(node);
		if(node.right!=null){
			populateQueue(node.right, q);
		}
	}
	
	// In this method we again do an inorder traversal and whenever we find a node whose right is NULL, we 
	// take the front item from queuue and make it the right of current node. We also set rightThread to 
	// true to indicate that the right pointer is a threaded link and not right child.
	public void create(Node node, Queue<Node> q){
		if(node == null)
			return;
		if(node.left!=null){
			create(node.left, q);
		}
		q.remove(node);
		if(node.right!=null){
			create(node.right, q);
		}
		else{
			node.right = q.peek();
			node.rightThread = true;
		}
	}
	
	public void createThreads(Node node){
		Queue<Node> q = new LinkedList<Node>();
		populateQueue(node, q);
		create(node,q);
	}
	
	// This method does inorder traversal on threaded binary tree
	public void inorderThreaded(Node root){
		Node temp = leftmost(root);
		while(temp!=null){
			System.out.print(temp.data + " ");
			if(temp.rightThread)
				temp = temp.right;
			else
				temp = leftmost(temp.right);
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.left.left = new Node(6);
		root.left.left.right = new Node(7);
		root.left.right.left = new Node(8);
		root.left.right.right = new Node(9);
		
		ThreadedBinaryTree obj = new ThreadedBinaryTree();
		obj.createThreads(root);
		System.out.println("Inorder traversal after creating threaded binary tree");
		obj.inorderThreaded(root);
	}

}
