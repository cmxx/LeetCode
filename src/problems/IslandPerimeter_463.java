package problems;

public class IslandPerimeter_463 {
	// #463 Island Perimeter
	// Status: passed. 241 ms. 2.26%
    int result;
    int[][] g; // grid
    int neiNum; // Number of neighbors
    int s;  //This is # of rows
    int c;  //Number of column;
    
    
    // Island Perimeter Optimized solution   
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
    public int islandPerimeter_op(int[][] grid) {
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
    
    
    // -------------------------------------------------------------
    // There is my own solution
    
    
    public int islandPerimeter(int[][] grid) {
        result = 0;
        g = grid;
        s = grid.length;
        c = grid[0].length;
        
        for (int i=0; i<s;i++)
            for (int j=0; j<c;j++)
                if (g[i][j]==1){
                    int ct = 4;
                    ct -= checkNeighbors(i-1,j);
                    ct -= checkNeighbors(i+1,j);
                    ct -= checkNeighbors(i,j-1);
                    ct -= checkNeighbors(i,j+1);
                    result += ct;
                }

        return result;
    }
    private int checkNeighbors(int i, int j){
        if (i>=0 && i < s && j>=0 && j< c){
            if (g[i][j] == 1){
                return 1;
            }
        }
        return 0;
    }
	
    // Testing
	public static void main(String[] args) {
		IslandPerimeter_463 n = new IslandPerimeter_463();
		
		int[][] grid = {
				{0,1,0,0},
				{1,1,1,0},
				{0,1,0,0},
				{1,1,0,0}
				};
		int[][] grid2 = {
				{1,0}
		};
		System.out.println("result: " + n.islandPerimeter(grid));
	}

}
