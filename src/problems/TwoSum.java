package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	// #1 Two Sum

	public int[] bruteForce(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++)
			for (int j = i + 1; j < nums.length; j++)
				if (nums[i] + nums[j] == target)
					return new int[] { i, j };
		return null;
	}

	public int[] hashSolution(int[] nums, int target) {
		Map<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			hm.put(nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			// if (nums[i]<=target)
			int complement = target - nums[i];
			if (hm.containsKey(complement) && hm.get(complement) != i) {
				return new int[] { i, hm.get(complement) };
			}
		}
		return null;
	}

	public int[] hashSolution2(int[] nums, int target) {
		// This solution has deficiency. See below
		Map<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			hm.put(nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			// this would only work for addition, not subtraction.
			// When negative number presents, this will fail.
			// See test2
			if (nums[i] > target)
				continue;
			int complement = target - nums[i];
			if (hm.containsKey(complement) && hm.get(complement) != i) {
				return new int[] { i, hm.get(complement) };
			}
		}
		return null;
	}

	public int[] hashOnePass(int[] nums, int target) {
		Map<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (hm.containsKey(complement)) {
				// hm.get(complement) must be larger than i, so place i at
				// later.
				return new int[] { hm.get(complement), i };
			}
			hm.put(nums[i], i);
		}
		return null;
	}

	private void runtest(int[] n, int t, TwoSum ts) {
		System.out.println("Array2: " + Arrays.toString(n));
		System.out.println("Target " + t);
		System.out.println("BruteForce: " + Arrays.toString(ts.bruteForce(n, t)));
		System.out.println("HashMap: " + Arrays.toString(ts.hashSolution(n, t)));
		System.out.println("HashMap2: " + Arrays.toString(ts.hashSolution2(n, t)));
		System.out.println("HashOnePass: " + Arrays.toString(ts.hashOnePass(n, t)));

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoSum ts = new TwoSum();
		// int[] test = new int[] { 2, 5, 3, 6, 7 };
		// int target = 10;
		int[] test2 = new int[] { -1, -2, -3, -4, -5 };
		int target2 = -8;

		ts.runtest(test2, target2, ts);

	}

}
