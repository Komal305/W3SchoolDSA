package w3school.Stack;

class Node{
	Node next;
	int value;
	
	Node(int value){
		this.value = value;
		next = null;
	}
}

public class StackList {

 Node head;
 int size;
 
	StackList(){
		head = null;
		size = 0;
	}
 
	int size() { return size; }
	
	boolean isEmpty() { return size==0; }
	
	public void push(int element) {
		Node newNode = new Node(element);
		
		if(head != null) {
			newNode.next = head;
		}
		head = newNode;
		size++;
	}
	
	public int pop() {
		if(isEmpty()) return -0;
		int poped = head.value;
		head = head.next;
		size--;
		return poped;
		
	}
	
	public int peek() {
		if(isEmpty()) return -0;
		return head.value;
	}
	
}
