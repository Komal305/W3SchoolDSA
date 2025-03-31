package w3school.Stack;

public class MyStackImpl {

	public static void main(String[] args) {

		Stackk s = new Stackk(4);
		

		s.push('A');
		s.push('H');
		s.push('D');
		s.push('K');

//		s.print();
//
//		System.out.println("peeking :" + s.peek());
//		System.out.println("pop :" + s.pop());
//		s.print();
//
//		System.out.println("peeking :" + s.peek());
//		s.print();
//
//		System.out.println("size :" + s.size());
//		System.out.println("is empty : " + s.isEmpty());
//		
		
		StackList sl = new StackList();
		
		sl.push(8);
		sl.push(3);
		sl.push(7);
		
		System.out.println("peeking :" + sl.peek());
		System.out.println("pop :" + sl.pop());
		

		System.out.println("peeking :" + sl.peek());
		

		System.out.println("size :" + sl.size());
		System.out.println("is empty : " + sl.isEmpty());
		
		

	}

}
