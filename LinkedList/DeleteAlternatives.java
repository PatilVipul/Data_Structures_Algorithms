package com.prac;

import com.prac.Intersection.Node;

public class DeleteAlternatives {

	static class Node{
		int data;
		Node next;
		public Node(int d){
			data = d;
		}
	}
	
	public void deleteAlternativeNodes(Node head){
		if(head == null || head.next == null)
			return;
		Node temp = head;
		while(temp!=null && temp.next!=null){
			temp.next = temp.next.next;
			temp = temp.next;
		}
		printList(head);
	}
	
	public void printList(Node head){
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data + "\t");
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		DeleteAlternatives list = new DeleteAlternatives();
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		
			
		System.out.println("Original Linked List...");
		list.printList(head1);
		
		System.out.println("\n\nAfter deleting alternative nodes...");
		list.deleteAlternativeNodes(head1);
		
	}

}
