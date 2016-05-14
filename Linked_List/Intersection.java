package com.prac;

import com.prac.DuplicatesLinkedList.Node;

public class Intersection {
	static class Node{
		int data;
		Node next;
		public Node(int d){
			data = d;
		}
	}
	
	public void IntersectionLinkedList(Node head1, Node head2){
		if(head1 == null || head2 == null)
			return;
		Node head3 = new Node(0);
		Node tail = head3;
		while(head1!=null && head2!=null){
			if(head1.data == head2.data){
				tail.next = head1;
				head1 = head1.next;
				head2 = head2.next;
				tail = tail.next;
			}
			else if(head1.data<head2.data){
				head1 = head1.next;
			}
			else
				head2 = head2.next;
		}
		printList(head3.next);
	}

	public void printList(Node head){
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data + "\t");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		
	Intersection list = new Intersection();
	Node head1 = new Node(1);
	head1.next = new Node(2);
	head1.next.next = new Node(3);
	head1.next.next.next = new Node(4);
	head1.next.next.next.next = new Node(6);
		
	System.out.println("Linked List 1...");
	list.printList(head1);

	Node head2 = new Node(2);
	head2.next = new Node(4);
	head2.next.next = new Node(6);
	head2.next.next.next = new Node(8);
	System.out.println("\n\nLinked List 2...");
	list.printList(head2);
	
	System.out.println("\n\nIntersection of two Linked Lists...");
	list.IntersectionLinkedList(head1,head2);

		
	}

}
