package net.callirgos.numJewelsInStones;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumJewelsInStonesTest {

    @Test
    void numJewelsInStones() {
        String inputJ = "aA";
        String inputS = "aAAbbbb";
        int expecterResult = 3;
        int actualResult = new NumJewelsInStones().numJewelsInStones(inputJ, inputS);

        assertEquals(expecterResult,actualResult);
    }
}