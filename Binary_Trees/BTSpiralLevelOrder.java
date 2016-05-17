package com.prac;

public class BTSpiralLevelOrder {

	static class Node{
		int data;
		Node left, right;
		public Node(int d){
			data = d;
			left = null;
			right = null;
		}
	}
	
	// This method moves level by level and then prints each level by alternatively reversing it
	public void spiral(Node node){
		int i = 0;
		boolean flip = true;
		for(i = 1; i <= height(node); i++){
			printLevel(node, i, flip);
			flip = !flip;
		}
	}
	
	// If flip is true then that particular level is printed in reverse order i.e. from right to left
	public void printLevel(Node node, int level, boolean flip){
		if(node == null)
			return;
		if(level == 1)
			System.out.print(node.data + " ");
		else if(level > 1){
			if(flip == false){
				printLevel(node.left, level-1, flip);
				printLevel(node.right, level-1, flip);
			}
			else{
				printLevel(node.right, level-1, flip);
				printLevel(node.left, level-1, flip);
			}
		}
	}
	
	// This method calculates the maximum height of the given binary tree 
	public int height(Node node){
		if(node == null)
			return 0;
		else{
			int lHeight, rHeight;
			lHeight = 1 + height(node.left);
			rHeight = 1 + height(node.right);
			if(lHeight > rHeight)
				return lHeight;
			else
				return rHeight;
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
		
		/**			1				<-
		 * 		  /   \
		 *      2       3			->
		 *    /  \    /   \
		 *   4    5  6     7  		<-
		 *   |    |  |     |
		 *   8    9  10    11		->
		 *   |    |  |     |
		 *  12   13  14    15		<-
		 * 
		 * After spiral this should be printed as 1 2 3 7 6 5 4 8 9 10 11 15 14 13 12
		 */

		BTSpiralLevelOrder tree = new BTSpiralLevelOrder();
		System.out.println("After level order traversal in spiral form...");
		tree.spiral(root);
		
	}
}
