package com.prac;

public class LinkedList1 {

	Node head;
	
	static class Node{
		int data;
		Node next;
		
		public Node(int d){
			data = d;
			next = null;
		}
	}
	
	public void pushLast(int d){
		Node newNode = new Node(d);
		if(head == null){	
			head = newNode;
		}
		else{
			Node temp = head;
			while(temp.next!=null){
				temp = temp.next;
			}
			temp.next = newNode;		
		}
	}
	
	public void countSameNumber(int key){
		Node temp = head;
		int counter = 0;
		while(temp!=null){
			if(temp.data == key){counter++;}
			temp = temp.next;
		}
		System.out.println("\n\n" + key + " appears " + counter + " times.");
	}
	
	public void detectLoop(){
		Node slowPtr = head;
		Node fastPtr = head;
		boolean loop = false;
		while(fastPtr!=null && slowPtr!=null && fastPtr.next!=null){
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if(slowPtr == fastPtr){
				loop = true;
				break;
			}
			else{
				loop = false;
			}
		}
		if(loop){System.out.println("\nLoop detected.");}
		else{System.out.println("\nNo loop");}
	}
	
	public Node mergeLists(Node head1, Node head2){
		Node fakeHead = new Node(0);
		Node temp = fakeHead;
		
		Node temp1 = head1;
		Node temp2 = head2;
		
		if(temp1 == null && temp2 != null){return temp2;}
		else if(temp1 != null && temp2 == null){return temp1;}
		else if(temp1 == null && temp2 == null){return null;}
		else{
			while(temp1!=null && temp2!=null){
				if(temp1.data <= temp2.data){
					temp.next = temp1;
					temp1 = temp1.next;
				}
				else{
					temp.next = temp2;
					temp2 = temp2.next;
				}
				temp = temp.next;
			}

			if(temp1!=null)
				temp.next = temp1;
			if(temp2!=null)
				temp2.next = temp2;
			return fakeHead.next;
		}		
	}
	
	public Node insertElement(Node head, int element){
		Node newNode = new Node(element);
		if(head == null){
			head = newNode;
		}
		else{
			Node temp = head;
			Node prev = null;
			if(element<head.data){
				newNode.next = head;
				head = newNode;
			}
			else{			
				while(temp!=null && temp.data < element){
					prev = temp;
					temp = temp.next;
				}
				newNode.next = temp;
				prev.next = newNode;
			}
		}
		return head;
	}
	
	public void printList(Node head){
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data + "\t");
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedList1 list1 = new LinkedList1();
		list1.pushLast(1);
		list1.pushLast(2);
		list1.pushLast(3);
		list1.pushLast(11);
		list1.pushLast(30);
		System.out.print("First Linked List:\t");
		list1.printList(list1.head);
		
		LinkedList1 list2 = new LinkedList1();
		list2.pushLast(2);
		list2.pushLast(5);
		list2.pushLast(7);
		list2.pushLast(10);
		list2.pushLast(15);
		System.out.print("\nSecond Linked List:\t");
		list2.printList(list2.head);
		
//		LinkedList1 mergedList = new LinkedList1();
//		mergedList.head = mergedList.mergeLists(list1.head, list2.head);
//		if(mergedList.head!=null){
//			System.out.print("\nMerged List is: \t");
//			mergedList.printList(mergedList.head);
//		}
		
		
		list2.head = list2.insertElement(list2.head, 30);		
		System.out.println("\nAfter inserting 30 in second list...");
		list2.printList(list2.head);
		
		
		
//		head.next.next.next.next = head.next;
		
		
		
//		list.detectLoop();
		
//		list.countSameNumber(1);
	}
}
