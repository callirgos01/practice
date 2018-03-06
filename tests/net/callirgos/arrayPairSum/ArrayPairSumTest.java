package net.callirgos.arrayPairSum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayPairSumTest {

    @Test
    void arrayPairSum() {
        int[] input = new int[]{1,4,3,2};
        int expectedOutput = 4;
        ArrayPairSum aps = new ArrayPairSum();
        int actualOutput = aps.arrayPairSum(input);

        assertEquals(expectedOutput,actualOutput);
    }
}