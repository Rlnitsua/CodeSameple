package org.uncle.lee.hash.table;

public class IslandPerimeter {
	public int islandPerimeter(int[][] grid) {
		int islandPerimeter = 0;
		int maxRow = grid.length;
		int maxColumn = grid[0].length;
		
		for(int rowIndex = 0; rowIndex < maxRow; rowIndex++){
			for(int columnIndex = 0; columnIndex < maxColumn; columnIndex++){
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
		if (columnIndex == (grid[0].length - 1) || grid[rowIndex][columnIndex + 1] == 0){
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
	}
}
