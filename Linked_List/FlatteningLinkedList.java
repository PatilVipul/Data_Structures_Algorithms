package com.prac;

public class FlatteningLinkedList {

	static class Node{
		int data;
		Node right;
		Node down;
		public Node(int d){
			data = d;
			right = null;
			down = null;
		}
	}
	
	public Node flatten(Node head){
		if(head == null || head.right == null)
			return head;
		Node temp = head;
		temp.right = flatten(temp.right);	// traverse to the rightmost linked list
		temp = merge(temp,temp.right);
		return temp;
	}
	
	public Node merge(Node a, Node b){
		if(a == null)
			return b;
		if(b == null)
			return a;
		Node result;
		if(a.data < b.data){
			result = a;
			result.down = merge(a.down,b);
		}
		else{
			result = b;
			result.down = merge(a,b.down);
		}
		return result;
	}
	
	public void printList(Node head){
		if(head == null)
			return;
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data + " ");
			temp = temp.down;
		}
	}
	
	public static void main(String[] args) {
		Node head = new Node(5);
		head.down = new Node(7);
		head.down.down = new Node(8);
		head.down.down.down = new Node(30);
		
		head.right = new Node(10);
		head.right.down = new Node(20);
		
		head.right.right = new Node(19);
		head.right.right.down = new Node(22);
		head.right.right.down.down = new Node(50);
		
		head.right.right.right = new Node(28);
		head.right.right.right.down = new Node(35);
		head.right.right.right.down.down = new Node(40);
		head.right.right.right.down.down.down = new Node(45);
		
		FlatteningLinkedList list = new FlatteningLinkedList();
		Node newHead = list.flatten(head);
		
		System.out.println("Original Linked List");
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data+"\t");
			temp = temp.right;
			
		}
		System.out.println("\nAfter flattening the Linked List...");
		
		list.printList(newHead);
		
	}

}
