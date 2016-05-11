package com.prac;

import com.prac.DetectRemoveLoop.Node;

public class RotateLinkedList {
	static class Node{
		int data;
		Node next;
		public Node(int d){
			data = d;
		}
	}
	
	public void rotate(Node head, int k){
		if(head == null){
			return;
		}
		Node temp = head;
		Node prev = null;
		int count = 0;
		while(temp!=null && count!=k){
			count++;
			prev = temp;
			temp = temp.next;
		}
		if(temp == null)
			return;
		prev.next = null;
		Node head2 = temp;
		while(temp.next!=null){
			temp = temp.next;
		}
		temp.next = head;
		printList(head2);
	}
	public void printList(Node head){
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data + "\t");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		
		RotateLinkedList list = new RotateLinkedList();
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		
		System.out.print("Original Linked List: ");
		list.printList(head1);
		
		System.out.println("\n\nRotated Linked List: ");
		list.rotate(head1, 4);
	}

}
