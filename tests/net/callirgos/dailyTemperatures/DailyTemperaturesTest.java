package net.callirgos.dailyTemperatures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DailyTemperaturesTest {

    @Test
    void dailyTemperatures() {
        int[] example1Input = new int[] {73, 74, 75, 71, 69, 72, 76, 73};
        int[] expectedOutput = new int[] {1, 1, 4, 2, 1, 1, 0, 0};
        int[] actualOutput = new DailyTemperatures().dailyTemperatures(example1Input);
        assertEquals(expectedOutput.length,actualOutput.length);
        for( int i=0; i<expectedOutput.length; i++) {
            assertEquals(expectedOutput[i], actualOutput[i]);
        }
    }
}