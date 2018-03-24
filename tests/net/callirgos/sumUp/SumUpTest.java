package net.callirgos.sumUp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumUpTest {

    @Test
    void getArrayLengthSun() {

        int[] sampleInput = new int[] {1,2,3,6,10,2,24,-12,6,37,18,29,-500};
        int target = 12;

        System.out.println(new SumUp().getArrayLengthSun(sampleInput, target));


    }
}