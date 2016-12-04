package problems;

import java.util.LinkedList;
import java.util.List;

public class FizzBuzz {
	// # 412

	public List<String> fizzBuzz(int n) {
		List<String> s = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0)
				s.add("FizzBuzz");
			else if (i % 5 == 0)
				s.add("Buzz");
			else if (i % 3 == 0)
				s.add("Fizz");
			else
				s.add(Integer.toString(i));
		}
		return s;
	}

	public static void main(String[] args) {
		FizzBuzz t = new FizzBuzz();
		System.out.println(t.fizzBuzz(16));
	}

}
