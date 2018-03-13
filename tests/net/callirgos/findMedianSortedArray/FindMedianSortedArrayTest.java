package net.callirgos.findMedianSortedArray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindMedianSortedArrayTest {

    @Test
    void findMedianSortedArrays() {
        int[] example1Input1 = new int[] { 1, 3 };
        int[] example1Input2 = new int[] { 2 };
        double expectedResult1 = 2.0;
        double actualResult1 = new FindMedianSortedArray().findMedianSortedArrays(example1Input1,example1Input2);

        int[] example2Input1 = new int[] { 1, 2 };
        int[] example2Input2 = new int[] { 3, 4 };
        double expectedResult2 = 2.5;
        double actualResult2 = new FindMedianSortedArray().findMedianSortedArrays(example2Input1,example2Input2);

        assertEquals(expectedResult1,actualResult1);
        assertEquals(expectedResult2,actualResult2);

    }
}