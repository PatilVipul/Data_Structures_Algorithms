package com.prac;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeBreadthQueue {

	static class Node{
			int data;
			Node left, right;
			public Node(int d){
				data = d;
				left = null;
				right = null;
			}
	}
	
	public void traverseQueue(Node root){
		Queue<Node> q = new LinkedList<Node>();
		if(root == null)
			return;
		q.add(root);
		while(!q.isEmpty()){
			Node tempNode = q.poll();
			System.out.print(tempNode.data + " ");
			if(tempNode.left!=null){
				q.add(tempNode.left);
			}
			if(tempNode.right!=null){
				q.add(tempNode.right);
			}
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		BinaryTreeBreadthQueue obj = new BinaryTreeBreadthQueue();
		obj.traverseQueue(root);
		
	}

}
