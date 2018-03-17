package net.callirgos.anagramMapping;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramMappingTest {

    @Test
    void anagramMappings() {
        int[] example1Input1 = new int[]{12, 28, 46, 32, 50};
        int[] example1Input2 = new int[]{50, 12, 32, 46, 28};
        int[] expectedOutput1 = new int[]{1, 4, 3, 2, 0};
        int[] actualOutput1 = new AnagramMapping().anagramMappings(example1Input1,example1Input2);

        assertEquals(expectedOutput1.length,actualOutput1.length);
        for(int i =0; i<expectedOutput1.length;i ++) {
            assertEquals(expectedOutput1[i], actualOutput1[i]);
        }
    }
}