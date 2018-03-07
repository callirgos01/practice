package net.callirgos.keyboardRow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KeyboardRowTest {

    @Test
    void findWords() {
        String[] exampleInput = new String[] {"Hello", "Alaska", "Dad", "Peace"};
        String[] expectedOutput = new String[] {"Alaska", "Dad"};
        String[] actualOutput = new KeyboardRow().findWords(exampleInput);

        assertEquals(expectedOutput.length,actualOutput.length);

        for( int i = 0; (i < expectedOutput.length) && (i < actualOutput.length); i++)
        {
            assertEquals(expectedOutput[i],actualOutput[i]);
        }
    }
}