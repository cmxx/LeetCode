package problems;

public class NimGame {
	// #292 Nim Game
	// Status: Passed. 0ms.

	public boolean canWinNim(int n) {

		/*
		 * 1 yes 
		 * 2 yes 
		 * 3 yes 
		 * 4 no 
		 * 5 yes 5-1 = 4 
		 * 6 yes 6-2 = 4 
		 * 7 yes 7-3 = 4 
		 * 8 no 7 6 5 
		 * 9 yes 9-1 = 8 
		 * 10 
		 * 11 
		 * 12 no
		 */

		return n % 4 != 0;
	}

}
