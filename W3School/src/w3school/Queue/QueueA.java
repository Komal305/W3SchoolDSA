package w3school.Queue;

public class QueueA {
char[] queue;
int size;
int capacity;
int front;

public QueueA(int capacity) {
	this.capacity = capacity;
	queue = new char[capacity];
	size = 0;
	front = 0;
}

int size() { return size; }

boolean isEmpty() { return size==0 ; }

public void enqueue(char element) {
	if(size==capacity) {
		System.out.println("queue is full ");
		return;
	}
	queue[(front+size)%capacity]=element;
	size++;
}

public char dequeue() {
	if(isEmpty()) {
		System.out.println("queue is empty");
		return ' ';
	}
	char item = queue[front];
	front = (front+1)%capacity;
	size--;
	return item;
}

public char peek() {
	if(isEmpty()) {
		System.out.println("queue is empty : ");
		return ' ';
	}
	return queue[front];
}

public void print() {
	for(short i=0; i<size; i++) {
		System.out.print(queue[(front+i)%capacity]+", ");
	}
	System.out.println();
}

}
