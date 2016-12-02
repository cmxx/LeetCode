package problems;

import java.util.*;

public class ShortestWordDistance_243 {

	// Passed. 3ms. 48.10%
	public int shortestDistance(String[] words, String word1, String word2) {
		List<Integer> start = new ArrayList<>();
		List<Integer> end = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1))
				start.add(i);
			else if (words[i].equals(word2))
				end.add(i);
			else
				continue;
		}

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < start.size(); i++) {
			for (int j = 0; j < end.size(); j++) {
				int diff = Math.abs(start.get(i) - end.get(j));
				if (diff < ans) {
					ans = diff;
				}
			}
		}
		return ans;
	}

	// Status: passed. 3ms. 48.10%
	// Although is method has same speed as my own solution,
	// but in large scale, this will faster. (less comparison)
	public int op(String[] words, String word1, String word2) {
		int p1 = -1;
		int p2 = -1;
		int min = Integer.MAX_VALUE;
		boolean flag = false;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				p1 = i;
				flag = true;
			} else if (words[i].equals(word2)) {
				p2 = i;
				flag = true;
			}

			if (flag && p1 != -1 && p2 != -1) {
				min = Math.min(min, Math.abs(p1 - p2));
				flag = false;
			}
		}
		return min;
	}

	public static void main(String[] args) {
		ShortestWordDistance_243 t = new ShortestWordDistance_243();

		String[] w = { "a", "c", "d", "b", "e", "a", "b" };

		System.out.println(t.shortestDistance(w, "a", "b"));

	}
}
