package com.prac;

import com.prac.BTDiameter1.Node;

public class BTDiameter2 {

	static class Node{
		int data;
		Node left, right;
		public Node(int d){
			data = d;
			left = null;
			right = null;
		}
	}
	
	static class Height{
		int h;
	}
	
	public int diameter(Node node, Height height){
		Height lHeight = new Height();
		Height rHeight = new Height();
		if(node == null){
			height.h = 0;
			return 0;
		}
		
		lHeight.h++;
		rHeight.h++;
		int lDiameter = diameter(node.left, lHeight);
		int rDiameter = diameter(node.right, rHeight);
		
		height.h = Math.max(lHeight.h, rHeight.h) + 1;
		
		return Math.max((lHeight.h+ rHeight.h + 1), Math.max(lDiameter, rDiameter));
	}
	
	public static void main(String[] args) {
		
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
		
		Node root2 = new Node(1);
		root2.left = new Node(2);
		root2.right = new Node(3);
		root2.right.right = new Node(4);
		root2.right.right.left = new Node(5);
		root2.right.right.left.left = new Node(7);
		root2.right.right.left.left.left = new Node(9);
		root2.right.right.left.left.left.left= new Node(11);
		root2.right.right.left.left.left.left.left = new Node(13);
		root2.right.right.right = new Node(6);
		root2.right.right.right.right = new Node(8);
		root2.right.right.right.right.right = new Node(10);
		root2.right.right.right.right.right.right = new Node(12);
		root2.right.right.right.right.right.right.right = new Node(14);
		
		BTDiameter2 tree = new BTDiameter2();
		Height height = new Height();
		System.out.println("The diameter of first binary tree is: " + tree.diameter(root1, height));
		System.out.println("The diamter of second binary tree is: " + tree.diameter(root2, height));
		
		

	}

}
