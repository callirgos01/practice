package net.callirgos.selfDividing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SelfDividingTest {

    @Test
    void selfDividingNumbers() {

        int left = 1;
        int right = 22;
        ArrayList<Integer> expectOutput = new ArrayList<Integer>();
        expectOutput.add(1);
        expectOutput.add(2);
        expectOutput.add(3);
        expectOutput.add(4);
        expectOutput.add(5);
        expectOutput.add(6);
        expectOutput.add(7);
        expectOutput.add(8);
        expectOutput.add(9);
        expectOutput.add(11);
        expectOutput.add(12);
        expectOutput.add(15);
        expectOutput.add(22);

        ArrayList<Integer> actualOutput;
        actualOutput = (ArrayList<Integer>) (new SelfDividing()).selfDividingNumbers(left,right);

        assertEquals(expectOutput,actualOutput);
    }
}