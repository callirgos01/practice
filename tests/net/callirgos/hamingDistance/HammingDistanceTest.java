package net.callirgos.hamingDistance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HammingDistanceTest {

    @Test
    void hammingDistance() {
        int example1Input1 = 1;
        int example1Input2 = 4;
        int expectedOutput = 2;
        int actualOutput = new HammingDistance().hammingDistance(example1Input1, example1Input2);

        assertEquals(expectedOutput,actualOutput);
    }
}