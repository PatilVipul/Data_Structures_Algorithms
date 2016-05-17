package com.prac;

public class BTChildernSum {
	
	static class Node{
		int data;
		Node left, right;
		public Node(int d){
			data = d;
			left = null;
			right = null;
		}
	}
	
	// This method calculates the sum of left child node and right child node and check if it is 
	// equal to the parent node. If even one case is false, false result is returned.
	public boolean sum(Node node){
		int leftSum = 0, rightSum = 0;
		if(node == null || node.left == null && node.right == null)
			return true;
		else{
			if(node.left!=null){
				leftSum = node.left.data;
			}
			if(node.right!=null){
				rightSum = node.right.data;
			}
			if((node.data == (leftSum + rightSum)) && sum(node.left) && sum(node.right)){
				return true;
			}
			else
				return false;
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.right = new Node(2);	
		
		BTChildernSum tree = new BTChildernSum();
		boolean result = tree.sum(root);
		if(result == true)
			System.out.println("The children sum property is satisfied");
		else
			System.out.println("The children sum property is NOT satisfied");
	}
}
