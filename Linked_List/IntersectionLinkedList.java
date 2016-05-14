package com.prac;

public class IntersectionLinkedList {
	
	static Node head1, head2;
	static class Node{
		int data;
		Node next;
		
		public Node(int d){
			data = d;
			next = null;
		}
	}
	
	public int findIntersection(){
		int count1 = getCount(head1);
		int count2 = getCount(head2);
		int diff = 0;
		if(count1 > count2){
			diff = count1 - count2;
			return getInterSectionNode(diff, head1, head2); 
		}
		else{
			diff = count2 - count1;
			return getInterSectionNode(diff, head2, head1);
		}
	}
	
	public int getInterSectionNode(int diff, Node head1, Node head2){
		Node temp1 = head1;
		Node temp2 = head2;
		int i = 0;
		for(i = 0; i < diff; ++i){
			if(temp1 == null)
				return -1;
			temp1 = temp1.next;
		}
		while(temp1 != null && temp2 != null){
			if(temp1 == temp2){
				return temp1.data;
			}
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		return -1;
		
	}
	
	public int getCount(Node head){
		Node temp = head;
		int counter = 0;
		while(temp!=null){
			counter++;
			temp = temp.next;
		}
		return counter;
	}
	
	public void printList(Node head){
		Node temp = head;
		while(temp!=null){
			System.out.print("\t" + temp.data);
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		IntersectionLinkedList list = new IntersectionLinkedList();
		head1 = new Node(3);
		head1.next = new Node(6);
		head1.next.next = new Node(9);
		head1.next.next.next = new Node(15);
		head1.next.next.next.next = new Node(30);
		
		System.out.print("First Linked List: ");
		list.printList(head1);
		
		head2 = new Node(10);
		head2.next = head1.next;
		head2.next.next = new Node(40);
		System.out.print("\nSecond Linked List: ");
		list.printList(head2);
		
		int intersect = list.findIntersection();
		
		System.out.println("\n\nBoth Linked List intersect at: " + intersect);
	}

}
