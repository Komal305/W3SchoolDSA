package w3school.Hashing;

import java.util.LinkedList;

public class HashSet {

	String[] myHash = new String[10];
	static LinkedList<String>[] myHashSet = new LinkedList[10];

	public static void main(String[] args) {

		for (int i = 0; i < myHashSet.length; i++) {
			myHashSet[i] = new LinkedList<>();
		}

		add("Jones");
		add("Lisa");
		add("Bob");
		add("Siri");
		add("Pete");
		add("Sturat");
		for (LinkedList<String> bucket : myHashSet) {
			System.out.println(bucket);
		}

		System.out.println("contain sturat : " + my_contains("Sturat"));
	}

	public static int hashFunction(String value) {
		int sum = 0;
		for (char c : value.toCharArray()) {
			sum += c;
		}
		return sum % 10;
	}

	public static boolean my_contains(String value) {
		int index = hashFunction(value);
		// return (myHash[index] != null && myHash[index].equals(value)) ;

		LinkedList<String> bucket = myHashSet[index];
		return bucket.contains(value);
	}

	static void add(String value) {
		int index = hashFunction(value);
		LinkedList<String> bucket = myHashSet[index];

		if (!bucket.contains(value)) {
			bucket.add(value);
		}

	}

}
