package com.prac;

public class DetectRemoveLoop {

	static class Node{
		int data;
		Node next;
		public Node(int d){
			data = d;
		}
	}
	
	public Boolean detectRemoveLoop(Node head){
		if(head == null)
			return true;
		Node slowPtr = head;
		Node fastPtr = head;
		Node meetPtr = null;
		while(fastPtr!=null){
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if(fastPtr == slowPtr){
				meetPtr = slowPtr;
				break;
			}
		}
		System.out.print("\nMeeting Node: " + meetPtr.data);
		return false;
	}

	public void printList(Node head){
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data + "\t");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		
		DetectRemoveLoop list = new DetectRemoveLoop();
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);
		head1.next.next.next.next.next.next.next = head1.next.next.next;
		
		System.out.println("Linked List 1...");
//		list.printList(head1);

		
		Boolean isLoop = list.detectRemoveLoop(head1);
	}
}
