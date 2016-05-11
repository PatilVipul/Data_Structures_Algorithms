package com.prac;

import com.prac.DeleteAlternatives.Node;

public class MergeSort {
	static class Node{
		int data;
		Node next;
		public Node(int d){
			data = d;
		}
	}
	
	public Node mergeSort(Node head){
		if(head == null || head.next == null)
			return head;
		int count = 0;
		Node temp = head;
		while(temp!=null){
			count++;
			temp = temp.next;
		}
		int middle = count / 2;
		
		Node left = head, right = null;
		Node leftTemp = head;
		int countMiddle = 0;
		while(leftTemp!=null){
			countMiddle++;
			Node next = leftTemp.next;
			if(countMiddle == middle){
				leftTemp.next = null;
				right = next;
			}
			leftTemp = next;
		}
		Node e1 = mergeSort(left);
		Node e2 = mergeSort(right);
		
		Node merged = merge(e1,e2);
		return merged;
	}
	
	public Node merge(Node e1, Node e2){
		Node temp1 = e1, temp2 = e2;
		Node fakeHead = new Node(0);
		Node fakeTemp = fakeHead;
		while(temp1!=null || temp2!=null){
			if(temp1==null){
				fakeTemp.next = new Node(temp2.data);
				temp2 = temp2.next;
				fakeTemp = fakeTemp.next;
			}
			else if(temp2 == null){
				fakeTemp.next = new Node(temp1.data);
				temp1 = temp1.next;
				fakeTemp = fakeTemp.next;
			}
			else{
				if(temp1.data < temp2.data){
					fakeTemp.next = new Node(temp1.data);
					temp1 = temp1.next;
					fakeTemp = fakeTemp.next;
				}
				else if(temp2.data < temp1.data){
					fakeTemp.next = new Node(temp2.data);
					temp2 = temp2.next;
					fakeTemp = fakeTemp.next;
				}
				else{
					fakeTemp.next = new Node(temp1.data);
					fakeTemp.next.next = new Node(temp2.data);
					fakeTemp = fakeTemp.next.next;
					temp1 = temp1.next;
					temp2 = temp2.next;
				}
			}				
		}
//		printList(fakeHead.next);
		return fakeHead.next;
	}
	
	public void printList(Node head){
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data + "\t");
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		MergeSort list = new MergeSort();
		Node head1 = new Node(2);
		head1.next = new Node(3);
		head1.next.next = new Node(4);
		head1.next.next.next = new Node(3);
		head1.next.next.next.next = new Node(4);
		head1.next.next.next.next.next = new Node(5);
		
		System.out.println("Original Linked List...");
		list.printList(head1);
		
		System.out.println("\nAfter applying merge sort...");
		head1 = list.mergeSort(head1);
		System.out.println(head1);
	}

}
