package net.callirgos.reverseWords;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseWordsTest {

    @Test
    void reverseWords() {
        String exampleInput = "Let's take LeetCode contest";
        String expectedOutput = "s'teL ekat edoCteeL tsetnoc";
        String actualOutput = new ReverseWords().reverseWords(exampleInput);

        assertEquals(expectedOutput,actualOutput);

    }
}