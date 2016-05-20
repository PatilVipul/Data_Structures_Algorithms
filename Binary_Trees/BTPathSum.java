package com.prac;

public class BTPathSum {

	static class Node{
		int data;
		Node left, right;
		public Node(int d){
			data = d;
			left = null;
			right = null;
		}
	}
	
	// This method verifies whether there exists any path in the binary tree with sum of all nodes
	// across that path is = n. If yes, returns true or else it returns false.
	// Technique: We subtract the n value with current node data and check if it is equal to 0 when
	// it reaches the leaf node.
	public boolean hasPath(Node node, int n){
		if(node == null){
			return (n==0);
		}
		else{
			boolean answer = false;
			if(node.left == null && node.right == null && n - node.data == 0){
				return true;
			}
			if(node.left!=null){
				answer = answer || hasPath(node.left, n - node.data);
			}
			if(node.right != null){
				answer = answer || hasPath(node.right, n - node.data);
			}
			return answer;
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.left = new Node(2);
		
		int n = 14;
		BTPathSum tree = new BTPathSum();
		if(tree.hasPath(root, n))
			System.out.println("YES, there is a path whose sum = " + n);
		else
			System.out.println("NO, there is no such path with sum = " + n);
	}
}
