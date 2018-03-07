package net.callirgos.distributeCandies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DistributeCandiesTest {

    @Test
    void distributeCandies() {
        int[] exampleInput1 = new int[]{1,1,2,2,3,3};
        int expectedOutput1 = 3;
        int actualOutput1 = new DistributeCandies().distributeCandies(exampleInput1);

        int[] exampleInput2 = new int[]{1,1,2,3};
        int expectedOutput2 = 2;
        int actualOutput2 = new DistributeCandies().distributeCandies(exampleInput2);

        assertEquals(expectedOutput1,actualOutput1);
        assertEquals(expectedOutput2,actualOutput2);
    }
}