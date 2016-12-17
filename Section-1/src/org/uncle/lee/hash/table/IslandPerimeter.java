package org.uncle.lee.hash.table;

public class IslandPerimeter {
	public int islandPerimeter(int[][] grid) {
		int islandPerimeter = 0;
		
		// max column is grid[i].length
		for(int rowIndex = 0; rowIndex < grid.length; rowIndex++){
			for(int columnIndex = 0; columnIndex < grid[rowIndex].length; columnIndex++){
				if(grid[rowIndex][columnIndex] == 1){
					islandPerimeter += cellPerimeter(grid, rowIndex, columnIndex);
				}
			}
		}
		return islandPerimeter;
	}

	private int cellPerimeter(int[][] grid, int rowIndex, int columnIndex) {
		int cellPerimeter = 0;
		// top
		if(rowIndex == 0 || grid[rowIndex - 1][columnIndex] == 0){
			cellPerimeter++;
		}
		// left
		if (columnIndex == 0 || grid[rowIndex][columnIndex - 1] == 0){
			cellPerimeter++;
		}
		// bottom
		if (rowIndex == (grid.length - 1) || grid[rowIndex + 1][columnIndex] == 0){
			cellPerimeter++;
		}
		// right
		if (columnIndex == (grid[rowIndex].length - 1) || grid[rowIndex][columnIndex + 1] == 0){
			cellPerimeter++;
		}
		return cellPerimeter;
	}
	
	public static void main(String[] args) {
		int[][] grid = {{1, 0}};
		/*int[][] grid = {
				{0, 1, 0, 0},
				{1, 1, 1, 0},
				{0, 1, 0, 0},
				{1, 1, 0, 0}
		};*/
		System.out.println("Island perimeter : " + new IslandPerimeter().islandPerimeter(grid));

		// max column is test[i].length
		// not test[0].length
		int[][] test = {
				{0, 1},
				{0, 1, 2}
		};
		System.out.println("max row : " + test.length);
		System.out.println("max column : " + test[0].length);
		System.out.println("max column : " + test[1].length);
	}
}
