package net.callirgos.matrixRegions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class matrixRegionsTest {

    @Test
    void getBiggestRegion() {
        int[][] matrix = {{0,0,0,1,1,0,0},{0,1,0,0,1,1,0},{1,1,0,1,0,0,1},{0,0,0,0,0,1,0,},{1,1,0,0,0,0,0,},{0,0,0,1,0,0,0,}};
        System.out.println("input");
        for(int i=0; i<matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%d,",matrix[i][j]);
            }
            System.out.println("");
        }
        int expectedResult = 7;
        int actualResult = new matrixRegions().getBiggestRegion(matrix);

        assertEquals(expectedResult,actualResult);

        System.out.println("output");
        for(int i=0; i<matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%d,",matrix[i][j]);
            }

            System.out.println("");
        }
    }
}