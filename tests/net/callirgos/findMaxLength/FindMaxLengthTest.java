package net.callirgos.findMaxLength;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindMaxLengthTest {

    @Test
    void findMaxLength() {
        int[] example1Input = new int[]{0,1};
        int expectedOutput1 = 2;
        int actualOutput1 = new FindMaxLength().findMaxLength(example1Input);

        int[] example2Input = new int[]{0,1,0};
        int expectedOutput2 = 2;
        int actualOutput2 = new FindMaxLength().findMaxLength(example2Input);

        int[] example3Input = new int[]{0,0,1,0,0,0,1,1};
        int expectedOutput3 = 6;
        int actualOutput3 = new FindMaxLength().findMaxLength(example3Input);

        assertEquals(expectedOutput1,actualOutput1);
        assertEquals(expectedOutput2,actualOutput2);
        assertEquals(expectedOutput3,actualOutput3);

    }
}