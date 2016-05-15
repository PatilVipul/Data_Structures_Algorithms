package com.prac;

import java.util.Stack;

public class BinaryInorderNoRecursion {

	static class Node{
		int data;
		Node left, right;
		public Node(int d){
			data = d;
			left = null; right = null;
		}
	}
	
	public void iterativeInorder(Node root){
		if(root == null)
			return;
		Stack<Node> st = new Stack<Node>();
		while(root!=null){
			st.push(root);
			root = root.left;
		}
		while(st.size() != 0){
			Node temp = st.pop();
			System.out.print(temp.data + " ");
			if(temp.right != null){
				temp = temp.right;
				while(temp!=null){
					st.push(temp);
					temp = temp.left;
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
		root.left.left.left = new Node(6);
		root.left.left.right = new Node(7);
		root.left.right.left = new Node(8);
		root.left.right.right = new Node(9);
		
		BinaryInorderNoRecursion obj = new BinaryInorderNoRecursion();
		obj.iterativeInorder(root);

	}

}
