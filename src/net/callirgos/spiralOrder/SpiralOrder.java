package net.callirgos.spiralOrder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SpiralOrder {
    /*
    * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in
    * spiral order.
    * For example,
    * Given the following matrix:
    * [
    * [ 1, 2, 3 ],
    * [ 4, 5, 6 ],
    * [ 7, 8, 9 ]
    * ]
    * You should return [1,2,3,6,9,8,7,4,5].
    * */

    public int[]  getNextNeighbor(int[] currentPoint, int[][] matrix)
    {
        //priority of the spiral
        //first go right
        if( currentPoint[1] + 1 < matrix[0].length )
        {
            if(matrix[currentPoint[0]][currentPoint[1]+1] != -100 )
            {
                return new int[]{currentPoint[0],currentPoint[1]+1};
            }
        }
        //then go down

        if( currentPoint[0] + 1 < matrix.length )
        {
            if(matrix[currentPoint[0]+1][currentPoint[1]] != -100 )
            {
                return new int[]{currentPoint[0]+1,currentPoint[1]};
            }
        }

        //then go left
        if( (currentPoint[1] - 1) >= 0 )
        {
            if(matrix[currentPoint[0]][currentPoint[1]-1] != -100 )
            {
                return new int[]{currentPoint[0],currentPoint[1]-1};
            }
        }
        //then go up
        if( (currentPoint[0] - 1) >= 0 )
        {
            if(matrix[currentPoint[0]-1][currentPoint[1]] != -100 )
            {
                return new int[]{currentPoint[0]-1,currentPoint[1]};
            }
        }

        return null;
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length == 0)
            return result;

        //dfs on a 2d array
        Queue<int[]> dfsQueue = new ArrayDeque<>();

        dfsQueue.add(new int[]{0,0});

        while(!dfsQueue.isEmpty())
        {
            int[] currentPoint = dfsQueue.remove();
            result.add(matrix[currentPoint[0]][currentPoint[1]]);

            matrix[currentPoint[0]][currentPoint[1]] = -100;

            int[]  nextPoint = getNextNeighbor(currentPoint, matrix);
            if(nextPoint != null){
                dfsQueue.add(nextPoint);
            }
        }
        return result;
    }
}
