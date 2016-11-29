package problems;

public class IslandPerimeter_op {
	/*
	 * # 463 Island Perimeter Optimized Solution O(n) = n.
	 * Count Total number of islands. 
	 * Count total number of neighbors at each islands' right and
	 * bottom. 
	 * total edges = island * 4 - neighbor * 2 
	 * for examples, two connected islands, first one = 4 - 2 = 2 
	 * second one = 4 
	 * total = 6
	 */
	public int islandPerimeter(int[][] grid) {
		int island = 0;
		int neighbor = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					island++;
					if (i < grid.length - 1 && grid[i + 1][j] == 1)
						neighbor++;
					if (j < grid[i].length - 1 && grid[i][j + 1] == 1)
						neighbor++;
				}
			}
		}
		return island * 4 - neighbor * 2;
	}
}
