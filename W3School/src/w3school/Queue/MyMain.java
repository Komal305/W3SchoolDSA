package w3school.Queue;

public class MyMain {

	public static void main(String[] args) {
		
		QueueA q = new QueueA(10);
		q.enqueue('A');
		q.enqueue('x');
		q.enqueue('B');
		q.enqueue('T');
		
		q.print();
		
		System.out.println(q.dequeue());
		q.print();
		System.out.println(q.peek());
	}

}
