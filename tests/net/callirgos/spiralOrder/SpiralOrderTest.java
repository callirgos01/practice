package net.callirgos.spiralOrder;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpiralOrderTest {

    @Test
    void spiralOrder() {

        int [][] example1Input1 = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> expectedResult1 = new ArrayList<>();
        expectedResult1.add(1);
        expectedResult1.add(2);
        expectedResult1.add(3);
        expectedResult1.add(6);
        expectedResult1.add(9);
        expectedResult1.add(8);
        expectedResult1.add(7);
        expectedResult1.add(4);
        expectedResult1.add(5);

        List<Integer> actualResult1 = new SpiralOrder().spiralOrder(example1Input1);

        //[[3],[2]]
        int [][] example1Input2 = new int[][]{{2,3}};
        List<Integer> expectedResult2 = new ArrayList<>();
        expectedResult2.add(2);
        expectedResult2.add(3);

        List<Integer> actualResult2 = new SpiralOrder().spiralOrder(example1Input2);

        assertEquals(expectedResult1,actualResult1);
        assertEquals(expectedResult2,actualResult2);
    }
}