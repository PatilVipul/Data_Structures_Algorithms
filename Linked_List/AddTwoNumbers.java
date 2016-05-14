package com.prac;

import com.prac.ReverseGroup.Node;

public class AddTwoNumbers {

	static class Node{
		int data;
		Node next;
		public Node(int d){
			data = d;
			next = null;
		}
	}
	
	public void addTwoNumbers(Node head1, Node head2){
		Node temp1 = head1;
		Node temp2 = head2;
		Node head3 = null, temp3 = null;
		int sum = 0, carry = 0;
		while(temp1!=null || temp2!=null){
			sum = (temp1!=null?temp1.data:0) + (temp2!=null?temp2.data:0) + carry;
			carry = (sum>=10) ? 1 : 0;
			sum = sum % 10;
			if(head3 == null){
				temp3 = new Node(sum);
				head3 = temp3;
			}
			else{
				temp3.next = new Node(sum);
				temp3 = temp3.next;
			}
			if(temp1!=null)
				temp1 = temp1.next;
			if(temp2!=null)
				temp2 = temp2.next;
		}
		if(carry > 0)
			temp3.next = new Node(carry);
		printList(head3);
	}
	
	
	public void printList(Node head){
//		Node temp = head;
//		while(temp!=null){
//			System.out.print(temp.data);
//			temp = temp.next;
//		}
		if(head == null)		// Recursion: To print the Linked List in reverse order: complete corect number
			return;
		printList(head.next);
		System.out.print(head.data);
	}

	public static void main(String[] args) {
		
		AddTwoNumbers list = new AddTwoNumbers();
		Node head1 = new Node(9);
		head1.next = new Node(9);
		head1.next.next = new Node(9);
		head1.next.next.next = new Node(9);
		head1.next.next.next.next = new Node(9);
		
		Node head2 = new Node(9);
		head2.next = new Node(9);
		head2.next.next = new Node(9);
		head2.next.next.next = new Node(9);
		head2.next.next.next.next = new Node(9);
		
		
		System.out.print("Linked List 1 (First Number): ");
		list.printList(head1);
		
		System.out.print("\n\nLinked List 2 (Second Number): ");
		list.printList(head2);

		System.out.print("\n\nAddition of both Linked Lists (Sum): ");
		list.addTwoNumbers(head1, head2);
	}

}
