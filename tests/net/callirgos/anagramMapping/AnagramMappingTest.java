package net.callirgos.anagramMapping;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramMappingTest {

    @Test
    void anagramMappings() {

        String A = "hello";
        String B = "billion";
        System.out.printf("Steps = %d", new AnagramMapping().anagramSteps(A,B));
    }
}