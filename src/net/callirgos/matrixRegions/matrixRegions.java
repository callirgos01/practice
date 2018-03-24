package net.callirgos.matrixRegions;

public class matrixRegions {
    //given an n x m matrix
    // find the area with the largest continuous 1s
    //general case

    private int getRegionSize(int[][] matrix, int row, int column) {
        int regionSize = 1;
        if(row<0 || column <0 || row >= matrix.length || column >= matrix[0].length) {
            return 0;
        }
        if(matrix[row][column] <=0 ) {
            return 0;
        }
        matrix[row][column] = -1;

        for(int r=row-1; r <= row+1; r++) {
            for(int c=column-1; c<=column+1; c++) {
                if((r!=row) || (c!=column)) {
                    regionSize += getRegionSize(matrix, r, c);
                }
            }
        }
        return regionSize;
    }
    public int getBiggestRegion(int[][] matrix ) {
        int maxArea = 0;
        //iterate through the whole matrix looking for 1s
        for(int row = 0; row<matrix.length; row++){
            for(int column = 0; column<matrix[0].length; column++) {
                if(matrix[row][column] == 1) {
                    maxArea = Math.max(maxArea, getRegionSize(matrix, row, column));
                }
                else {
                    matrix[row][column] = -1;
                }
            }
        }

        return maxArea;
    }
    //follow up
    //find the area with the most continuous 1s that form a square
    //this seems like a subset of the first problem
}
