package net.callirgos.Google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoogleTest {
    @Test
    void atoiTest(){
        for(int expectedOutput=Integer.MIN_VALUE; expectedOutput<Integer.MAX_VALUE; expectedOutput++) {
            String input = String.valueOf(expectedOutput);
            int actualOutput = new Google.PhoneScreen().atoi(input);
            assertEquals(expectedOutput, actualOutput);
        }
    }
}