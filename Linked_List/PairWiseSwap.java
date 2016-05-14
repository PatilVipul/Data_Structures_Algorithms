package com.prac;

public class PairWiseSwap {

	static class Node{
		int data;
		Node next;
		
		public Node(int d){
			data = d;	
		}
	}
	
	public void pairWiseSwap(Node head){
		if(head == null)
			return;
		Node temp = head;
		int k;
		while(temp!=null && temp.next!=null){
			k = temp.data;
			temp.data = temp.next.data;
			temp.next.data = k;
			temp = temp.next.next;
		}
		
		printLinkedList(head);
	}
	
	public void printLinkedList(Node head){
		if(head == null)
			return;
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data + "\t");
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		
		PairWiseSwap list = new PairWiseSwap();
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		
		System.out.println("Original Linked List...");
		list.printLinkedList(head1);
		
		System.out.println("\n\nAfter pair wise swapping...");
		list.pairWiseSwap(head1);
		

	}

}
