package w3school.Stack;

public class Stackk {

	char[] stack;
	int top;
	int capacity;
	
	public Stackk(int capacity) {
		this.capacity = capacity;
		stack = new char[capacity];
		top = -1;
	}
	
	int size() {
		return top+1;
	}
	
	boolean isEmpty() {
		return (top == -1);
	}
	
	void push(char element) {
		if(top == capacity-1) {
			System.out.print("stack is full: ");
			return ;
		}
		stack[++top] = element;
	}
	
	 public char pop() {
		 if(isEmpty()) {
				System.out.println("stack is empty");
				return ' ';
			}
			return stack[top--];
	}
	
	public char peek() {
		if(isEmpty()) {
			System.out.println("stack is empty");
			return ' ';
		}
		return stack[top];
	}
	
	public void print() {
		for(char c:stack)
			System.out.println(c+", ");
	}

}
