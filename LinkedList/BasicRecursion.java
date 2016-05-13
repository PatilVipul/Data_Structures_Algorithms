package com.prac;

import com.prac.AlternativeSplits.Node;

public class BasicRecursion {


	static class Node{
		int data;
		Node next;
		public Node(int d){
			data = d;
			next = null;
		}
	}
	
	public int linkedListLength(Node head){
		if(head == null)
			return 0;
		return (1 + linkedListLength(head.next));
	}
	
	public int sumLinkedList(Node head){
		if(head == null)
			return 0;
		return (head.data + sumLinkedList(head.next));
	}
	
	public void printList(Node head){
//		Node temp = head;
//		while(temp!=null){
//			System.out.print(temp.data + "\t");
//			temp = temp.next;
//		}
		if(head == null)
			return;
		System.out.print(head.data + "\t");
		printList(head.next);
	}
	
	public void reversePrintList(Node head){
		if(head == null)
			return;
		reversePrintList(head.next);
		System.out.print(head.data + "\t");
	}
	
	public int linearSearch(Node head, int d){
		if(head == null)
			return -1;
		if(head.data == d)
			return 1;
		else{
			return 1 + linearSearch(head.next, d);
		}
	}
	
	public Node copyLinkedList(Node head){
		if(head == null){
			printList(head);
			return null;
		}
		else{
			Node temp = new Node(head.data);
			System.out.print(temp.data + "\t");
			return (temp.next = copyLinkedList(head.next));
		}
	}

	public static void main(String[] args) {
		
	BasicRecursion list = new BasicRecursion();
	Node head1 = new Node(1);
	head1.next = new Node(2);
	head1.next.next = new Node(3);
	head1.next.next.next = new Node(4);
	head1.next.next.next.next = new Node(5);
	head1.next.next.next.next.next = new Node(6);
	head1.next.next.next.next.next.next = new Node(7);
	head1.next.next.next.next.next.next.next = new Node(8);
	head1.next.next.next.next.next.next.next.next = new Node(9);
		
	System.out.println("Linked List 1...");
	list.printList(head1);

	System.out.print("\n\nLinked List Length: " + list.linkedListLength(head1));
	System.out.print("\nSum of all Nodes: " + list.sumLinkedList(head1));
	
	System.out.println("\n\nLinked List in reverse order...");
	list.reversePrintList(head1);
	
	System.out.println("\n\nSearching 1 in Linked List...");
	int got = list.linearSearch(head1, 1);
	if(got>=0){
		System.out.println("Found 1 at position " + got);
	}
	else
		System.out.println("NOT Found 1" + got);
	
	System.out.println("Copying Linked List into another...");
	list.copyLinkedList(head1);
	
	
	
	
	}
	
	


}
