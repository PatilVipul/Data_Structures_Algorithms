package com.prac;

public class ReverseGroup {

	static class Node{
		int data;
		Node next;
		public Node(int d){
			data = d;
		}
	}
	
	public Node reverseGroup(Node head, int groupSize){
		if(head == null)
			return null;
		Node temp = head;
		Node prev = null;
		Node next = null;
		int count = 0;
		while(count < groupSize && temp!=null){
			next = temp.next;
			temp.next = prev;
			prev = temp;
			temp = next;
			count++;
		}
		if(next!=null)
			head.next = reverseGroup(next, groupSize);
		return prev;
		
	}

	public void printList(Node head){
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data + "\t");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		
		ReverseGroup list = new ReverseGroup();
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);
			head1.next.next.next.next.next.next.next = new Node(8);
		
		System.out.println("Linked List 1...");
		list.printList(head1);

		System.out.println("\n\nAfter reversing in a group of 3...");
		Node reversedNode = list.reverseGroup(head1, 3);
		list.printList(reversedNode);
	}
}
