package com.prac;

public class LinkedList {
	
	static Node head;
	
	static class Node{
		int data;
		Node next;
		
		public Node(int d){
			data = d;
			next = null;
		}
	}
	
	public void pushFirst(int d){
		Node new_Node = new Node(d);
		new_Node.next = head;
		head = new_Node;
	}
	
	public void pushAfter(int d, int key){
		Node new_Node = new Node(d);
		Node temp = head;
		while(temp!=null && temp.data != key){
			temp = temp.next;
		}
		if(temp!=null){
			new_Node.next = temp.next;
			temp.next = new_Node;
			
		}
	}
	
	public void pushBefore(int d, int key){
		if(head.data == key){
			pushFirst(d);
			return;
		}
		else{
			Node new_Node = new Node(d);
			Node prev = null;
			Node temp = head;
			while(temp!=null && temp.data != key){
				prev = temp;
				temp = temp.next;
			}
			if(prev!=null){
				new_Node.next = temp;
				prev.next = new_Node;
			}
		}
	}
	
	public void pushLast(int d){
		Node new_Node = new Node(d);
		if(head==null){
			head = new_Node;
		}
		else{
			Node temp = head;
			while(temp.next!=null){
				temp = temp.next;
			}
			temp.next = new_Node;
		}
	}
	
	public void delete(int d){
		if(head == null){
			System.out.println("Cannot delete");
			return;
		}
		if(head.data == d){
			head = head.next;
			return;
		}
		Node prev = null;
		Node temp = head;
		while(temp!=null && temp.data!=d){
			prev = temp;
			temp = temp.next;
		}
		if(prev!=null){
			prev.next = temp.next;
		}
	}
	
	public void reverse(){
		Node prev = null;
		Node temp = head;
		Node next = null;
		while(temp!=null){
			next = temp.next;
			temp.next = prev;
			prev = temp;
			temp = next;
		}
		head = prev;
	}
	
	public void countNodes()
	{
		int count = 0;
		Node temp = head;
		while(temp!=null){
			temp = temp.next;
			count++;
		}
		System.out.println("\nTotal number of nodes: " + count);
	}
	
	public void swapNodes(int x, int y){
		if(x==y)
			return;
		Node xCurr = head; Node xPrev = null;
		while(xCurr!=null && xCurr.data!=x){
			xPrev = xCurr;
			xCurr = xCurr.next;
		}
		
		Node yCurr = head; Node yPrev = null;
		while(yCurr!=null && yCurr.data!=y){
			yPrev = yCurr;
			yCurr = yCurr.next;
		}
		
		if(xCurr == null || yCurr == null)
			return;
		
		if(xPrev!=null){			// if xCurr is not head
			xPrev.next = yCurr;
		}
		else{
			head = yCurr;
		}
		
		if(yPrev!=null){			// if yCurr is not head
			yPrev.next = xCurr;
		}
		else{
			head = yCurr;
		}
		
		Node temp = xCurr.next;
		xCurr.next = yCurr.next;
		yCurr.next = temp;
	}
	
	public int countNodesRecursive(Node head){
		if(head == null)
			return 0;
		else{
			return 1+countNodesRecursive(head.next);
		}
	}

	public int searchNode(int index){
		Node temp = head;
		int counter = 0;
		while(temp!=null && index != counter){
			temp = temp.next;
			counter++;
		}
		if(temp!=null)
			return temp.data;
		else
			return -1;
	}
	
	public void middleNode(){
		if(head!=null){
			Node fastTemp = head;
			Node slowTemp = head;
			while(fastTemp!=null && fastTemp.next!=null){
				fastTemp = fastTemp.next.next;
				slowTemp = slowTemp.next;
			}
			System.out.println("\nMiddle Node data: " + slowTemp.data);
		}
	}
	
	public void nthFromLast(int endPosition){
		int length = 0;
		Node temp = head;
		while(temp!=null){
			temp = temp.next;
			length++;
		}
		if(length < endPosition)
			return;
		
		int startPosition = length - endPosition + 1;
		System.out.println("\nStart position: " + startPosition);
		temp = head;
		for(int i = 1; i < startPosition; i++ ){
			temp=temp.next;
		}
		System.out.println("\nNode data from position " + endPosition + " from end is: " + temp.data);
	}
	
	public void printList(){
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data + "\t");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.pushLast(1);
		list.pushLast(2);
		list.pushLast(3);
		list.pushLast(4);
		
		
		System.out.println("Original Linked List (PushFirst and PushLast)...");
		list.printList();
		
//		list.swapNodes(3,1);
//		System.out.println("\n\nLinked List after swapping...");
//		list.printList();
		
//		int key = list.searchNode(2);
//		if(key>=0)
//			System.out.println("\nNode data at position 2 is: " + key);
//		else
//			System.out.println("\nNot node present at this position");
		
//		list.middleNode();
		
//		list.nthFromLast(3);
		
//		list.countNodes();
//		int count = list.countNodesRecursive(head);
//		System.out.println("Total number of nodes (Recursive method): " + count);
//		
//		System.out.println("\nInserting 0 after 1...");
//		list.pushAfter(0, 1);
//		list.printList();
//		
//		System.out.println("\nInserting 9 before 2...");
//		list.pushBefore(9, 2);
//		list.printList();
//		
//		System.out.println("\nDeleting 0...");
//		list.delete(0);
//		list.printList();
//		
//		System.out.println("\nReverse Linked List...");
//		list.reverse();
//		list.printList();

	}

}
