package problems;

public class IslandPerimeter {
	// #463 Island Perimeter
	// Status: passed. 241 ms. 2.26%
    int result;
    int[][] g; // grid
    int neiNum; // Number of neighbors
    int s;  //This is # of rows
    int c;  //Number of column;
    
    
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
	
	public static void main(String[] args) {
		IslandPerimeter n = new IslandPerimeter();
		
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
