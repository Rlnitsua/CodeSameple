package lizbyu.hash.table;

public class IslandPerimeter_opt {
	public int islandPerimeter(int[][] grid){
		int islandsNumber = 0;
		int neighborsNumber = 0;
		
		for(int rowIndex = 0; rowIndex < grid.length; rowIndex++){
			for(int columnIndex = 0; columnIndex < grid[rowIndex].length; columnIndex++){
				if(grid[rowIndex][columnIndex] == 1){
					islandsNumber++;
					
					// down
					if(rowIndex != (grid.length - 1) && grid[rowIndex + 1][columnIndex] == 1){
						neighborsNumber++;
					}
					// right
					if(columnIndex != (grid[rowIndex].length - 1) && grid[rowIndex][columnIndex + 1] == 1){
						neighborsNumber++;
					}
				}
			}
		}
		
		return islandsNumber * 4 - neighborsNumber * 2;
	}
	
	public static void main(String[] args) {
//		int[][] grid = {{1, 0}};
		int[][] grid = {
				{0, 1, 0, 0},
				{1, 1, 1, 0},
				{0, 1, 0, 0},
				{1, 1, 0, 0}
		};
//		int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
		System.out.println("Island perimeter : " + new IslandPerimeter_opt().islandPerimeter(grid));
	}
}
