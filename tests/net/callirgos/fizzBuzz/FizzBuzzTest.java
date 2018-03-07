package net.callirgos.fizzBuzz;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    @Test
    void fizzBuzz() {

        int exampleN = 15;
        List<String> expectedResult = new ArrayList<String>(Arrays.asList("1",
                "2",
                "Fizz",
                "4",
                "Buzz",
                "Fizz",
                "7",
                "8",
                "Fizz",
                "Buzz",
                "11",
                "Fizz",
                "13",
                "14",
                "FizzBuzz"));
        List<String> actualResult = new FizzBuzz().fizzBuzz(exampleN);

        assertEquals(expectedResult,actualResult);

    }
}