package problems;

public class IslandPerimeter {
	// #463 Island Perimeter
	int result;
	int[][] g; // grid
	int neiNum; // Number of neighbors
	int s;	//This is # of rows
	int c;  //Number of column;
	public int islandPerimeter(int[][] grid) {
		result = 0;
		g = grid;
		s = grid.length;
		c = grid[0].length;
		
		System.out.println("length: " + s);
		System.out.println("column: " + c);
		
        for (int i=0; i<s;i++)
        	for (int j=0; j<s;j++)
        		if (g[i][j]==1)
        			checkNeighbors(i,j);
		return result;
    }
	private void checkNeighbors(int i, int j){
		neiNum = 4;
		validate(i,j+1);
		validate(i,j-1);
		validate(i+1,j);
		validate(i-1,j);
		result += neiNum;
	}
	private void validate(int i, int j){
		if (i>=0 && i < s && j>=0 && j< c)
			if (g[i][j]==1)
				neiNum--;
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
		System.out.println("result: " + n.islandPerimeter(grid2));
	}

}
