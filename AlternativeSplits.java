package com.prac;

public class AlternativeSplits {
	
	static class Node{
		int data;
		Node next;
		public Node(int d){
			data = d;
		}
	}
	
	public void alternativeSplit(Node head1){
		if(head1 == null)
			return;
		if(head1.next == null)
			printList(head1);
		Node temp1 = head1, temp2 = null, temp3 = null;
		Node head2 = null, head3 = null;
		int check = 0;
		while(temp1!=null){
			if(check == 0){
				if(head2==null){
					head2 = temp1;
					temp2 = head2;
				}
				else{
					temp2.next = temp1;
					temp2 = temp2.next;
					temp3.next = null;					
				}
				
				check = 1;
			}
			else{
				if(head3==null){
					head3 = temp1;
					temp3 = head3;
				}
				else{
					temp3.next = temp1;
					temp3 = temp3.next;
					temp2.next = null;
				}
				
				check = 0;
			}
			temp1 = temp1.next;
		}
		System.out.println("First part of split...");
		printList(head2);
		System.out.println("\nSecond part of split...");
		printList(head3);
	}

	public void printList(Node head){
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data + "\t");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		
	AlternativeSplits list = new AlternativeSplits();
	Node head1 = new Node(1);
	head1.next = new Node(0);
	head1.next.next = new Node(1);
	head1.next.next.next = new Node(0);
	head1.next.next.next.next = new Node(1);
	head1.next.next.next.next.next = new Node(0);
	head1.next.next.next.next.next.next = new Node(1);
//	head1.next.next.next.next.next.next.next = new Node(0);
		
	System.out.println("Linked List 1...");
	list.printList(head1);

	System.out.println("\n\nAfter splitting alternatively...");
	list.alternativeSplit(head1);

		
	}

}
