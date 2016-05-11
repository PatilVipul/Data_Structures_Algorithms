package com.prac;

import com.prac.LinkedList.Node;

public class PalindromeLinkedList {
	
	static Node head;
	
	static class Node{
		int data;
		Node next;
		
		public Node(int d){
			data = d;
		}
	}
	
	public void pushNode(int d){
		Node newNode = new Node(d);
		newNode.next = head;
		head = newNode;
	}
	
	public boolean checkPalindrome(){
		
		// Find Mid of LinkedList using Fast and Slow pointer technique
		if(head == null || head.next == null)
			return true;
		Node temp = head;
		Node slowPtr = head;
		Node fastPtr = head;
		while(fastPtr!=null && fastPtr.next!=null){
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
		}
		Node reverseHead = null;
		
		if(fastPtr!=null){
			reverseHead = slowPtr.next;
			slowPtr = null;
		}
		else
			reverseHead = slowPtr;
		
		// Reverse second part of the Linked List
		Node curr = reverseHead;
		Node prev = null;
		Node next = null;
		while(curr!=null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		reverseHead = prev;			
		
		// Compare both halves of the linked list to verify if it is Palindrome or not
		Node reverseTemp = reverseHead;
		while(temp!=null && reverseTemp!=null){
			if(temp.data!=reverseTemp.data)
				return false;
			else{
				temp = temp.next;
				reverseTemp = reverseTemp.next;
			}
		}
		return true;
	}
	
	public void printList(){
		Node temp = head;
		while(temp!=null){
			System.out.print("\t" + temp.data);
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		PalindromeLinkedList list = new PalindromeLinkedList();
		list.pushNode(1);
		list.pushNode(3);
		list.pushNode(5);
		list.pushNode(3);
		list.pushNode(1);
		
		System.out.print("Original Linked List: ");
		list.printList();
		
		if(list.checkPalindrome())
			System.out.println("\nLL is palindrome");
		else
			System.out.println("\nNOT Palindrome");
	}
}
