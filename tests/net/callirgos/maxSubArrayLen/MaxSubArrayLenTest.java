package net.callirgos.maxSubArrayLen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxSubArrayLenTest {

    @Test
    void maxSubArrayLen() {
        int[] example1Input1 = new int[]{1, -1, 5, -2, 3};
        int example1Input2 = 3;
        int expectedOutput1 = 4;
        int actualOutput1 = new MaxSubArrayLen().maxSubArrayLen(example1Input1,example1Input2);

        int[] example2Input1 = new int[]{1, -1, 5, -2, 3};
        int example2Input2 = 3;
        int expectedOutput2 = 4;
        int actualOutput2 = new MaxSubArrayLen().maxSubArrayLen(example2Input1,example2Input2);

        assertEquals(expectedOutput1,actualOutput1);
        assertEquals(expectedOutput2,actualOutput2);
    }
}