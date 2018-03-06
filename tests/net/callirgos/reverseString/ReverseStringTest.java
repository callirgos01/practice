package net.callirgos.reverseString;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseStringTest {

    @Test
    void reverseString() {
        String exampleInput = "hello";
        String expectedResult = "olleh";
        String actualResult = new ReverseString().reverseString(exampleInput);

        assertEquals(expectedResult,actualResult);
    }
}