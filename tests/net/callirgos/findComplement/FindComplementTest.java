package net.callirgos.findComplement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindComplementTest {

    @Test
    void findComplement() {

        int input1 = 5;
        int expectedOutput1 = 2;
        int actualOutput1 = new FindComplement().findComplement(input1);

        int input2 = 1;
        int expectedOutput2 = 0;
        int actualOutput2 = new FindComplement().findComplement(input2);


        assertEquals(expectedOutput1,actualOutput1);
        assertEquals(expectedOutput2,actualOutput2);

    }
}