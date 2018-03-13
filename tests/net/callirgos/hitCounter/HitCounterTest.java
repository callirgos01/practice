package net.callirgos.hitCounter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HitCounterTest {

    @Test
    void getHits() {
        HitCounter counter = new HitCounter();
        // hit at timestamp 1.
        counter.hit(1);
        // hit at timestamp 2.
        counter.hit(2);
        // hit at timestamp 3.
        counter.hit(3);

        int expectedResult1 = 3;
        // get hits at timestamp 4, should return 3.
        int actualResult1 = counter.getHits(4);
        // hit at timestamp 300.
        counter.hit(300);
        int expectedResult2 = 4;
        // get hits at timestamp 300, should return 4.
        int actualResult2 = counter.getHits(300);
        int expectedResult3 = 3;
        // get hits at timestamp 301, should return 3.
        int actualResult3 = counter.getHits(301);

        assertEquals(expectedResult1,actualResult1);
        assertEquals(expectedResult2,actualResult2);
        assertEquals(expectedResult3,actualResult3);



    }
}