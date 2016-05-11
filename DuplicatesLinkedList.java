package com.prac;

import com.prac.IntersectionLinkedList.Node;

public class DuplicatesLinkedList {
	
	static Node head1, head2;
	
	static class Node{
		int data;
		Node next;	
		public Node(int d){
			data = d;
			next = null;
		}
	}
	
	public void pushNode(Node head, int d){
		Node newNode = new Node(d);
		newNode.next = head;
		head = newNode;
	}
	
//	public Node removeDuplicates(){
//		Node curr = head1;
//		Node next;
//		if(head1 == null)	return null;
//		while(curr.next!=null){
//			if(curr.data == curr.next.data){
//				next = curr.next.next;
//				curr.next = null;
//				next = curr.next;
//			}
//			else{
//				curr = curr.next;
//			}
//		}
//		return head1;
//	}	
	
	public void removeSortedDuplicates(Node head){
		Node temp = head;
		Node dup = null;
		if(head==null)
			return;
		while(temp.next!=null){			// THESE CONDITIONS ARE VERY IMPORTANT temp!=null OR temp.NEXT!=null
			if(temp.data==temp.next.data){
				dup = temp.next.next;
				temp.next.next = null;
				temp.next = dup;
			}
			else{
				temp = temp.next;
			}
		}
	}
	
	public void removeUnsortedDuplicates(Node head){
		Node temp = head;
		Node innerPtr = null;
		Node duplicate;
		
		if(head == null)
			return;
		while(temp.next!=null && temp!=null){
			
			innerPtr = temp;
			while(innerPtr.next!=null){
				if(temp.data == innerPtr.next.data){
					duplicate = innerPtr.next;
					innerPtr.next = innerPtr.next.next;
				}
				else{
					innerPtr = innerPtr.next;
				}
			}
			temp = temp.next;
		}
	}
	
	public boolean compareLists(Node head1, Node head2){
		Node temp1 = head1;
		Node temp2 = head2;
		while(temp1!=null && temp2!=null && temp1.data == temp2.data){
//			System.out.println("List1: " + temp1.data + "\tList2: " + temp2.data);
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		if(temp1!=null || temp2!=null){
			return false;
		}
		return true;

	}
	
	public void printList(Node head){
		Node temp = head;
		while(temp!=null){
			System.out.print("\t" + temp.data);
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		DuplicatesLinkedList list = new DuplicatesLinkedList();
		
		head1 = new Node(11);
		head1.next = new Node(11);
		head1.next.next = new Node(11);
		head1.next.next.next = new Node(33);
		head1.next.next.next.next = new Node(33);
		head1.next.next.next.next.next = new Node(55);
		head1.next.next.next.next.next.next = new Node(55);
		System.out.print("First Original LinkedList: ");
		list.printList(head1);
		
		list.removeSortedDuplicates(head1);
		System.out.println("\n\nAfter removing duplicates from Sorted Linked List...");
		list.printList(head1);
		
		head2 = new Node(11);
		head2.next = new Node(33);
		head2.next.next = new Node(11);
		head2.next.next.next = new Node(44);
		head2.next.next.next.next = new Node(11);
		head2.next.next.next.next.next = new Node(66);
		System.out.print("\nSecond Original LinkedList: ");
		list.printList(head2);
		
		list.removeUnsortedDuplicates(head2);
		System.out.println("\n\nAfter removing duplicates from Unsorted Linked List...");
		list.printList(head2);
				
//		boolean isSame = list.compareLists(head1, head2);
//		System.out.println("LinkedList Similar?: " + isSame);
	}
}