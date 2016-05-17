package com.prac;

import java.util.Stack;

public class BTSpiralLevelOrderIterative {

	static class Node{
		int data;
		Node left, right;
		public Node(int d){
			data = d;
			left = null;
			right = null;
		}
	}
	
	// This method uses two stacks: leftStack and rightStack to store and then print those the nodes 
	// in left order and right order respectively -> Spiral traversal achieved 
	public void spiralIterative(Node node){
		if(node == null)
			return;
		else{
			Stack<Node> leftStack = new Stack<Node>();
			Stack<Node> rightStack = new Stack<Node>();
			leftStack.push(node);
			while(!leftStack.isEmpty() || !rightStack.isEmpty()){
				while(!leftStack.isEmpty()){
					Node temp = leftStack.pop();
					System.out.print(temp.data + " ");
					if(temp.left != null)
						rightStack.add(temp.left);
					if(temp.right != null)
						rightStack.add(temp.right);
				}
				while(!rightStack.isEmpty()){
					Node temp = rightStack.pop();
					System.out.print(temp.data + " ");
					if(temp.right != null)
						leftStack.add(temp.right);
					if(temp.left != null)
						leftStack.add(temp.left);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left.left = new Node(8);
		root.left.right.right = new Node(9);
		root.right.left.right = new Node(10);
		root.right.right.right = new Node(11);
		root.left.left.left.left = new Node(12);
		root.left.right.right.left = new Node(13);
		root.right.left.right.left = new Node(14);
		root.right.right.right.right = new Node(15);
		
		/**			1				->
		 * 		  /   \
		 *      2       3			<-
		 *    /  \    /   \
		 *   4    5  6     7  		->
		 *   |    |  |     |
		 *   8    9  10    11		<-
		 *   |    |  |     |
		 *  12   13  14    15		->
		 * 
		 * After spiral this should be printed as 1 3 2 4 5 6 7 11 10 9 8 12 13 14 15 
		 */

		BTSpiralLevelOrderIterative tree = new BTSpiralLevelOrderIterative();
		System.out.println("After level order traversal in spiral form (Iterative method)...");
		tree.spiralIterative(root);
		
	}
}
