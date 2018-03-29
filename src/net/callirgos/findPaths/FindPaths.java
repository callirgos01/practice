package net.callirgos.findPaths;

public class FindPaths {
    private boolean validSquare(boolean[][] grid, int row, int col) {
        return grid[row][col];
    }
    private boolean isAtEnd(boolean[][] grid, int row, int col) {

        return true;
    }
    public int countPaths(boolean[][]grid, int row, int col) {
        if(!validSquare(grid, row, col)) {
            return 0;
        }
        if(isAtEnd(grid, row, col)) {
            return 1;
        }

        return countPaths(grid, row+1, col) + countPaths(grid, row, col+1);
    }
}
