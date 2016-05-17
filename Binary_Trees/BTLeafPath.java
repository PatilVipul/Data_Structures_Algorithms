package com.prac;

public class BTLeafPath {

	static class Node{
		int data;
		Node left, right;
		public Node(int d){
			data = d;
			left = null;
			right = null;
		}
	}
	
	/**This method prints all the paths from the root to all the leaves separately using recursion method 
	 * @param root - current node
	 * @param paths - integer array which stores a single path
	 * @param pathLength - length of the path
	 */
	public void printPaths(Node node, int paths[], int pathLength){
		if(node == null)
			return;
		else{
			paths[pathLength] = node.data;
			pathLength++;
		}
		
		// if current node is a leaf, print the array contents, which is one complete path to that leaf 
		if(node.left == null && node.right == null){
			int i = 0;
			for(i = 0; i < pathLength; i++){
				System.out.print(paths[i] + " ");
			}
			System.out.println("");
		}
		
		// recursively find paths upto left subtree and right subtree leaves
		else{
			printPaths(node.left, paths, pathLength);
			printPaths(node.right, paths, pathLength);
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(50);
		root.left.right.left = new Node(51);
		root.left.right.left.left = new Node(99);
		root.left.right.right = new Node(52);
		root.left.right.left.right = new Node(53);
		root.right.right = new Node(6);
		root.right.right.right = new Node(7);

		/**							1
		 * 						  /   \
		 * 						 2     3
		 * 					   /   \	 \		
		 *  				 4     50	  6 
		 * 						  /  \
		 *                      51    52
		 * 	                  /   \
		 *                   99   53 
		 */
		
		BTLeafPath tree = new BTLeafPath();
		int paths[] = new int[1000];
		int pathLength = 0;
		tree.printPaths(root, paths, pathLength);
	}

}
