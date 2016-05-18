package com.prac;

public class BTDiameter1 {
	
	static class Node{
		int data;
		Node left, right;
		public Node(int d){
			data = d;
			left = null;
			right = null;
		}
	}
	
	/**This method calculates the diameter (is the number of nodes on the longest path between two
	 * leaves in the tree) of the binary tree.
  	 * Diameter is calculated as maximum of left-subtree-diameter, right-subtree-diameter and longest 
	 * path between leaves that goes through the root.	
	 */
	public int diameter(Node node){
		if(node == null)
			return 0;
		else{
			int lHeight = height(node.left);
			int rHeight = height(node.right);
			
			int lDiameter = diameter(node.left);
			int rDiameter = diameter(node.right);
			
			return Math.max((lHeight+rHeight+1), Math.max(lDiameter, rDiameter));
		}
	}
	
	// This method calculates the height of the binary tree using recursion technique
	public int height(Node node){
		if(node == null){
			return 0;
		}
		else{
			int lHeight = 1 + height(node.left);
			int rHeight = 1 + height(node.right);
			if(lHeight < rHeight)
				return rHeight;
			else
				return lHeight;
		}
	}
	
	public static void main(String[] args) {
		
		BTDiameter1 tree = new BTDiameter1();
		
		// This tree has the diameter as 9
		Node root1 = new Node(1);
		root1.left = new Node(2);
		root1.right = new Node(3);
		root1.left.left = new Node(4);
		root1.left.right = new Node(5);
		root1.right.right = new Node(6);
		root1.left.right.left = new Node(7);
		root1.left.right.right = new Node(8);
		root1.right.right.right = new Node(9);
		root1.right.right.right.left = new Node(10);
		root1.right.right.right.right = new Node(11);
		root1.right.right.right.left.left = new Node(12);
		root1.right.right.right.left.right = new Node(13);
		
		// This tree has the diameter as 11
		Node root2 = new Node(1);
		root2.left = new Node(2);
		root2.right = new Node(3);
		root2.right.right = new Node(4);
		root2.right.right.left = new Node(5);
		root2.right.right.left.left= new Node(7);
		root2.right.right.left.left.left = new Node(9);
		root2.right.right.left.left.left.left= new Node(11);
		root2.right.right.left.left.left.left.left = new Node(13);
		root2.right.right.right = new Node(6);
		root2.right.right.right.right = new Node(8);
		root2.right.right.right.right.right = new Node(10);
		root2.right.right.right.right.right.right = new Node(12);
		root2.right.right.right.right.right.right.right = new Node(14);
		
		System.out.println("Diameter of first binary tree is: " + tree.diameter(root1));
		System.out.println("Diameter of second binary tree is: " + tree.diameter(root2));
	}
}
